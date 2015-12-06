package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

public abstract class p4Pane extends JPanel implements MouseListener {

    public AbstractP4 game;

    public static final Font font20 = new Font("Arial", Font.BOLD, 20);
    public static final Font font16 = new Font("Arial", Font.BOLD, 16);

    public void instaPaint() {
        this.paintImmediately(0, 0, this.getWidth(), this.getHeight());
    }

    /**
     * This method centers a <code>String</code> in
     * a bounding <code>Rectangle</code>.
     * @param g - The <code>Graphics</code> instance.
     * @param r - The bounding <code>Rectangle</code>.
     * @param s - The <code>String</code> to center in the
     * bounding rectangle.
     * @param font - The display font of the <code>String</code>
     *
     * @see java.awt.Graphics
     * @see java.awt.Rectangle
     * @see java.lang.String
     */
    public void centerString(Graphics g, Rectangle r, String s,
                             Font font) {
        FontRenderContext frc =
                new FontRenderContext(null, true, true);

        Rectangle2D r2D = font.getStringBounds(s, frc);
        int rWidth = (int) Math.round(r2D.getWidth());
        int rHeight = (int) Math.round(r2D.getHeight());
        int rX = (int) Math.round(r2D.getX());
        int rY = (int) Math.round(r2D.getY());

        int a = (r.width / 2) - (rWidth / 2) - rX;
        int b = (r.height / 2) - (rHeight / 2) - rY;

        g.setFont(font);
        g.drawString(s, r.x + a, r.y + b);
    }

    public static Polygon RectangleToPolygon(Rectangle rect)
    {
        Polygon result = new Polygon();

        result.addPoint(rect.x, rect.y);
        result.addPoint(rect.x + rect.width, rect.y);
        result.addPoint(rect.x + rect.width, rect.y + rect.height);
        result.addPoint(rect.x, rect.y + rect.height);

        return result;
    }

    public p4Pane(AbstractP4 game) {
        this.setGame(game);
        this.addMouseListener(this);
    }

    public AbstractP4 getGame() {
        return game;
    }

    public void setGame(AbstractP4 game) {
        this.game = game;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
}
