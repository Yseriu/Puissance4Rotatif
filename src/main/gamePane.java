package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * Created by Yseriu on 03/12/2015.
 */
public class gamePane extends JPanel implements MouseListener {

    protected Puissance4 game;

    @Override
    protected void paintComponent(Graphics g) {
        int elemDim = this.getHeight()/7;
        for(int i = 0; i < 7; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                g.setColor(Color.GRAY);
                g.fillRect(i*elemDim,j*elemDim,elemDim, elemDim);

                switch (this.getGame().getMapItem(i, j))
                {
                    case 'O': g.setColor(Color.RED);break;
                    case 'X': g.setColor(Color.YELLOW);break;
                    default: g.setColor(Color.WHITE);break;
                }
                g.fillOval((int)(0.1*elemDim)+i*elemDim, (int)(0.1*elemDim)+j*elemDim, (int)(0.8*elemDim), (int)(0.8*elemDim));
            }
        }
        Font font = new Font("Arial", Font.BOLD, 20);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("Tourner", (int)(this.getWidth()*0.74), (int)(this.getHeight()*0.2));
        g.drawString("Prévisualiser", (int)(this.getWidth()*0.74), (int)(this.getHeight()*0.4));
    }

    public gamePane(Puissance4 game) {
        this.setGame(game);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int w = (int)(this.getMousePosition().getX()/(int)(this.getHeight()/7));
        if (w >= 7)
        {
            int h = this.getHeight();
            int y = (int)(this.getMousePosition().getY());
            if(y < 0.3*h && y >= 0.1*h)
            {
               System.out.println("Tourner");
            }
            else if (y < 0.5*h && y >= 0.3*h)
            {
                System.out.println("Prévisualiser");
            }
        }
        else
            this.setGame(this.getGame().play(w));
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

    public Puissance4 getGame() {
        return game;
    }

    public void setGame(Puissance4 game) {
        if(game != null) this.game = game;
    }
}
