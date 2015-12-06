package GUI;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Yseriu on 06/12/2015.
 */
public class hostingPane extends p4Pane {

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(font20);
        centerString(g, new Rectangle(0, 0, this.getWidth(), ((int) (this.getHeight() * 0.9))), "En attente de clients", font20);
        try {
            centerString(g, new Rectangle(0, ((int) (this.getHeight() * 0.1)), this.getWidth(), this.getHeight()),InetAddress.getLocalHost().toString(), font20);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public hostingPane(AbstractP4 game) {
        super(game);
    }
}
