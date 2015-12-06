package GUI;

import java.awt.*;

public abstract class AbstractP4 {

    protected static final int PHASE_MENU = 0;
    protected static final int PHASE_GAME = 1;
    protected static final int PHASE_WON = 2;

    protected static final int TYPE_LOCAL = 0;
    protected static final int TYPE_IA = 1;
    protected static final int TYPE_LAN = 2;

    protected static char PLAYER_1 = 'X';
    protected static char PLAYER_2 = 'O';
    protected static char PLAYER_NONE = ' ';

    protected static Color PLAYER_COLOR_1 = Color.RED;
    protected static Color PLAYER_COLOR_2 = Color.YELLOW;
    protected static Color PLAYER_COLOR_NULL = Color.WHITE;

    private P4UI UI;

    protected p4Pane pane;

    protected p4Pane getPane() { return pane; }

    protected void repaint()
    {
        this.getPane().instaPaint();
    }

    /**
     * @param phase
     * @param p2 either the game type, or the winner
     */
    protected void changePhase(int phase, int p2) { changePhase(phase, p2, false);}
    protected void changePhase(int phase, int p2, boolean hosting)
    {
        if(phase == AbstractP4.PHASE_GAME)
        {
            this.setPhase(AbstractP4.PHASE_GAME);
            this.setPane(new gamePane(this));
            this.getUI().changeContentPane(this.getPane());
            this.setType(p2);
            this.initLan(hosting);
            this.init();
        }
        this.repaint();
    }


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

    public abstract void setType(int type);

    public abstract void SecondPlayer();

    public abstract void init();

    public abstract void initLan(boolean isServer);

    public AbstractP4() {
        this.setPane(new menuPane(this));
        UI = new P4UI(this.getPane());
    }

    public void setPane(p4Pane pane) {
        this.pane = pane;
    }

    public P4UI getUI() {
        return UI;
    }

    public void debug() {}
}