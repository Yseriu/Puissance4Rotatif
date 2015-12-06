package GUI;

import javax.swing.*;

public class P4UI extends JFrame
{
    public P4UI(p4Pane pane) {
        this.setTitle("Puissance 4 Rotatif");
        this.setSize(550, 380);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(pane);

        this.setVisible(true);
    }

    public void changeContentPane(JPanel pane)
    {
        System.out.print("Changing pane ...");
        this.getContentPane().removeAll();
        this.setContentPane(pane);
        this.revalidate();
        this.repaint();
    }
}
