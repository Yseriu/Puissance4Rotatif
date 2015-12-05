package GUI;

import javax.swing.*;
import java.util.function.Function;

public class P4UI extends JFrame
{
    /**
     * @param game
     */
    public P4UI(Object game) {
        this.setTitle("Puissance 4 Rotatif");
        this.setSize(550, 380);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(new gamePane(game));

        this.setVisible(true);
    }
}
