package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class gamePane extends JPanel implements MouseListener {

    protected AbstractP4 game;
    public static final Font font20 = new Font("Arial", Font.BOLD, 20);
    public static final Font font16 = new Font("Arial", Font.BOLD, 16);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        switch (this.getGame().getPhase())
        {
            case AbstractP4.PHASE_MENU:
                this.paintMenuBoard(g);
                break;

            case AbstractP4.PHASE_GAME:
                this.paintGameBoard(g);
                break;

            case AbstractP4.PHASE_WON:
                break;
        }

    }
    protected void paintGameBoard(Graphics g)
    {
        int elemDim = this.getHeight()/7;
        for(int i = 0; i < 7; i++)
        {
            for(int j = 0; j < 7; j++) {
                g.setColor(Color.GRAY);
                g.fillRect(i * elemDim, j * elemDim, elemDim, elemDim);

                if (this.getGame().getMapItem(i, j) == AbstractP4.PLAYER_1)
                    g.setColor(AbstractP4.PLAYER_COLOR_1);
                else if (this.getGame().getMapItem(i, j) == AbstractP4.PLAYER_2)
                    g.setColor(AbstractP4.PLAYER_COLOR_2);
                else
                    g.setColor(AbstractP4.PLAYER_COLOR_NULL);

                g.fillOval((int)(0.1*elemDim)+i*elemDim, (int)(0.1*elemDim)+j*elemDim, (int)(0.8*elemDim), (int)(0.8*elemDim));
            }
        }
        g.setFont(font20);
        g.setColor(Color.BLACK);
        int rot = this.getGame().getRemainingRotations();
        int prev = this.getGame().getRemainingPreviews();
        g.setColor(rot > 0 ? Color.BLACK : Color.GRAY);
        g.drawString("Tourner ("+rot+")", (int)(this.getWidth()*0.65), (int)(this.getHeight()*0.2));
        g.setColor(prev > 0 ? Color.BLACK : Color.GRAY);
        g.drawString("Prévisualiser ("+prev+")", (int)(this.getWidth()*0.65), (int)(this.getHeight()*0.4));
        g.setFont(font16);
        g.setColor(this.getGame().getPlayer() == AbstractP4.PLAYER_1 ? AbstractP4.PLAYER_COLOR_1 : AbstractP4.PLAYER_COLOR_2);
        g.fillOval((int)(this.getWidth()*0.75), (int)(this.getHeight()*0.55), (int)(0.8*elemDim), (int)(0.8*elemDim));
        g.setColor(Color.BLACK);
        g.drawString(Integer.toString(this.getGame().getRemainingTokens()), (int)(this.getWidth()*0.775+0.25*0*elemDim), (int)(this.getHeight()*0.625));
    }

    protected void paintMenuBoard(Graphics g)
    {
        g.setFont(font20);
        g.setColor(Color.PINK);
        g.fillRect((int)(0.05*this.getWidth()), (int)(0.2*this.getHeight()), (int)(0.40*this.getWidth()), (int)(0.6*this.getHeight()));
        g.fillRect((int)(0.55*this.getWidth()), (int)(0.2*this.getHeight()), (int)(0.40*this.getWidth()), (int)(0.6*this.getHeight()));

        g.setColor(Color.BLACK);
        g.drawString("1 Joueur", (int)(0.17*this.getWidth()), (int)(0.5*this.getHeight()));
        g.drawString("2 Joueurs", (int)(0.66*this.getWidth()), (int)(0.5*this.getHeight()));
    }

    public gamePane(AbstractP4 game) {
        this.setGame(game);
        this.addMouseListener(this);
    }

    public void paintWon(Graphics g)
    {

    }

    public void enterGamePhase(boolean ia)
    {
        this.getGame().setIA(ia);
        this.getGame().setPhase(AbstractP4.PHASE_GAME);
        this.getGame().init();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(this.getGame().getPhase() == AbstractP4.PHASE_MENU)
        {
            if(this.getMousePosition().getX() > this.getWidth()*0.05
                    && this.getMousePosition().getX() < this.getWidth()*0.45
                    && this.getMousePosition().getY() > this.getHeight()*0.2
                    && this.getMousePosition().getY() < this.getHeight()*0.8)
            {
                this.enterGamePhase(true);
            }
            else if(this.getMousePosition().getX() > this.getWidth()*0.55
                    && this.getMousePosition().getX() < this.getWidth()*0.95
                    && this.getMousePosition().getY() > this.getHeight()*0.2
                    && this.getMousePosition().getY() < this.getHeight()*0.8)
            {
                this.enterGamePhase(false);

            }
        }
        else if(this.getGame().getPhase() == AbstractP4.PHASE_GAME)
        {
            int w = (int)(this.getMousePosition().getX()/(this.getHeight()/7));
            if (w >= 7)
            {
                int h = this.getHeight();
                int y = (int)(this.getMousePosition().getY());
                if(y < 0.3*h && y >= 0.1*h && this.getGame().canUseRotation())
                {
                    System.out.println("Tourner");
                }
                else if (y < 0.5*h && y >= 0.3*h && this.getGame().canUsePreview())
                {
                    System.out.println("Prévisualiser");
                }
            }
            else
                this.getGame().play(w);
        }

        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public AbstractP4 getGame() {
        return game;
    }

    public void setGame(AbstractP4 game) {
        if(game != null) this.game = game;
    }
}
