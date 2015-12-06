package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Yseriu on 06/12/2015.
 */
public abstract class p4Pane extends JPanel implements MouseListener {

    public AbstractP4 game;

    public static final Font font20 = new Font("Arial", Font.BOLD, 20);
    public static final Font font16 = new Font("Arial", Font.BOLD, 16);

    public void instaPaint() {
        this.paintImmediately(0, 0, this.getWidth(), this.getHeight());
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
