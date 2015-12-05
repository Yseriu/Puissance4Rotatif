package GUI;

import java.awt.*;

public abstract class AbstractP4 {

    protected static final int PHASE_MENU = 0;
    protected static final int PHASE_GAME = 1;
    protected static final int PHASE_WON = 2;

    protected static char PLAYER_1 = 'X';
    protected static char PLAYER_2 = 'O';
    protected static char PLAYER_NONE = ' ';

    protected static Color PLAYER_COLOR_1 = Color.RED;
    protected static Color PLAYER_COLOR_2 = Color.YELLOW;
    protected static Color PLAYER_COLOR_NULL = Color.WHITE;

    public abstract void play(int col);

    public abstract char getMapItem(int col, int line);

    public abstract int getRemainingRotations();

    public abstract int getRemainingPreviews();

    public abstract boolean canUseRotation();

    public abstract boolean canUsePreview();

    public abstract int getRemainingTokens();

    /**
     * @return Le char du joueur actuel, parmis AbstractP4.PLAYER_1 et AbstractP4.PLAYER_2
     */
    public abstract char getPlayer();

    /**
     * @return La phase de jeu actuelle parmis les constantes PHASE_* de cette classe.
     */
    public abstract int getPhase();

    public abstract void setPhase(int phase);

    public abstract void setIA(boolean IA);

    public abstract void init();

    public AbstractP4() {
        new P4UI(this);
    }
}