package GUI;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Yseriu on 06/12/2015.
 */
public class menuPane extends p4Pane {

    public menuPane(AbstractP4 game) {
        super(game);
    }

    public Rectangle getCell(int id)
    {
        return new Rectangle((int) (this.getWidth()*0.2), ((int) (this.getHeight()*(0.08*(id+1)+0.15*id))), ((int) (this.getWidth() * 0.6)), ((int) (this.getHeight() * 0.15)));
    }
    public static Polygon RectangleToPolygon(Rectangle rect) { Polygon result = new Polygon(); result.addPoint(rect.x, rect.y); result.addPoint(rect.x + rect.width, rect.y); result.addPoint(rect.x + rect.width, rect.y + rect.height); result.addPoint(rect.x, rect.y + rect.height); return result; }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(font20);
        g.setColor(Color.PINK);
        for(int i=0; i < 4; i++)
        {
            g.fillPolygon(RectangleToPolygon(getCell(i)));
        }

        g.setColor(Color.BLACK);
        g.drawString("1 Joueur", (int)(0.42*this.getWidth()), (int)(0.17*this.getHeight()));
        g.drawString("2 Joueurs", (int)(0.41*this.getWidth()), (int)(0.40*this.getHeight()));
        g.drawString("Host", (int)(0.46*this.getWidth()), (int)(0.63*this.getHeight()));
        g.drawString("Connect", (int)(0.43*this.getWidth()), (int)(0.86*this.getHeight()));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);

        if(this.getCell(0).contains(this.getMousePosition()))
        {
            this.getGame().changePhase(AbstractP4.PHASE_GAME, AbstractP4.TYPE_IA);
        }
        else if(this.getCell(1).contains(this.getMousePosition()))
        {
            this.getGame().changePhase(AbstractP4.PHASE_GAME, AbstractP4.TYPE_LOCAL);
        }
        else if(this.getCell(2).contains(this.getMousePosition()))
        {
            this.getGame().changePhase(AbstractP4.PHASE_GAME, AbstractP4.TYPE_LAN, true);
        }
        else if(this.getCell(3).contains(this.getMousePosition()))
        {
            this.getGame().changePhase(AbstractP4.PHASE_GAME, AbstractP4.TYPE_LAN, false);
        }
    }
}
