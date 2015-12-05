package GUI;

/**
 * Created by Yseriu on 04/12/2015.
 */
public abstract class AbstractP4 {

    protected char[][] map = {{' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}};
    protected int[] remainingRotations = {4, 4};
    protected int[] remainigPreviews = {2, 2};
    protected int[] remainingTokens = {21, 21};
    protected char player = AbstractP4.PLAYER_1;
    protected boolean IA = false;
    protected int phase = 0;

    protected static int PHASE_MENU = 0;
    protected static int PHASE_GAME = 1;
    protected static int PHASE_WON = 2;

    protected static char PLAYER_1;
    protected static char PLAYER_2;

    public abstract boolean canPlay(int col);

    public abstract Class play(int col);

    public abstract void IA();

    public abstract void changePlayer();

    public abstract char getMapItem(int col, int line);

    public abstract int getRemainingRotations();

    public abstract char getPlayer();

    public abstract char[][] getMap();

    public abstract int getRemainigPreviews();

    public abstract void usePreview(char player);

    public abstract void useRotation(char player);

    public abstract void useToken();

    public abstract boolean canUseRotation();

    public abstract boolean canUsePreview();

    public abstract int getRemainingTokens();

    public abstract boolean isWon();

    public abstract boolean isIA();

    public void setIA(boolean IA) {
        this.IA = IA;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }
}

}
