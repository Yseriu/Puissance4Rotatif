package main;

/**
 * Created by Yseriu on 03/12/2015.
 */
import javax.swing.*;

public class P4UI extends JFrame
{
    protected gamePane pane;

    public P4UI(Puissance4 game) {
        this.setTitle("Puissance 4 Rotatif");
        this.setSize(550, 380);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(new gamePane(game));

        this.setVisible(true);
    }

    public void refresh(Puissance4 game)
    {
        this.getPane().setGame(game);
        this.setContentPane(this.getPane());
        this.getContentPane().repaint();
        this.repaint();
    }

    public gamePane getPane() {
        return pane;
    }

    public void setPane(gamePane pane) {
        this.pane = pane;
    }
}
