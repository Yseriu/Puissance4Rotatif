package main;

        import javax.swing.*;

public class P4UI extends JFrame
{
    public P4UI(Puissance4 game) {
        this.setTitle("Puissance 4 Rotatif");
        this.setSize(550, 380);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(new gamePane(game));

        this.setVisible(true);
    }
}
