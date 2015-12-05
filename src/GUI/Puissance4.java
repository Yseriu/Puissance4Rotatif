package GUI;

public class Puissance4 extends AbstractP4 {

    protected char[][] map = {{' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}};
    protected int[] remainingRotations = {4, 4};
    protected int[] remainingPreviews = {2, 2};
    protected int[] remainingTokens = {21, 21};
    protected char player = PLAYER_1;
    protected boolean IA = false;
    protected int phase = PHASE_MENU;

    public boolean canPlay(int col)
    {
        return this.getMapItem(col, 0) == ' ';
    }

    public void play(int col) {
        if (this.canPlay(col)) {
            int i = 6;
            while (getMapItem(col, i) != ' ') i--;
            this.setMapItem(col, i, this.getPlayer());
            this.useToken();
            this.changePlayer();

            this.IA();
        }
    }

    private void IA() {
        if(this.isIA() && this.getPlayer() == 'O')
        {
            this.play(1);
        }
    }

    public void changePlayer()
    {
        this.setPlayer(this.getPlayer() == 'X' ? 'O' : 'X');
    }

    public static void main(String args[])
    {
        Puissance4 game = new Puissance4();
    }

    public Puissance4()
    {
        new P4UI(this);
    }

    public void setMapItem(int x, int y, char p)
    {
        char[][] lmap = this.getMap();
        lmap[y][x] = p;
        this.setMap(lmap);
    }

    public char getMapItem(int col, int line)
    {
        return this.getMap()[line][col];
    }

    public int getRemainingRotations() {
        return remainingRotations[this.getPlayer() == Puissance4.PLAYER_1 ? 0 : 1];
    }

    public void setRemainingRotations(int remainingRotations) {
        this.remainingRotations[this.getPlayer() == Puissance4.PLAYER_1 ? 0 : 1] = remainingRotations;
    }

    public char getPlayer() {
        return player;
    }

    public void setPlayer(char player) {
        this.player = player;
    }

    public char[][] getMap() {
        return map;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

    public int getRemainingPreviews() {
        return remainingPreviews[this.getPlayer() == Puissance4.PLAYER_1 ? 0 : 1];
    }

    public void setRemainingPreviews(int remainingPreviews) {
        this.remainingPreviews[this.getPlayer() == Puissance4.PLAYER_1 ? 0 : 1] = remainingPreviews;
    }

    public void usePreview(char player)
    {
        this.setRemainingPreviews(this.getRemainingPreviews()-1);
    }

    public void useRotation(char player)
    {
        this.setRemainingRotations(this.getRemainingRotations()-1);
    }

    public void useToken()
    {
        this.setRemainingTokens(this.getRemainingTokens()-1);
    }

    public boolean canUseRotation()
    {
        return this.getRemainingRotations() > 0;
    }

    public boolean canUsePreview()
    {
        return this.getRemainingPreviews() > 0;
    }

    public int getRemainingTokens() {
        return remainingTokens[this.getPlayer() == Puissance4.PLAYER_1 ? 0 : 1];
    }

    public void setRemainingTokens(int remainingTokens) {
        this.remainingTokens[this.getPlayer() == Puissance4.PLAYER_1 ? 0 : 1] = remainingTokens;
    }

    public boolean isWon() {
        return false;
    }

    public boolean isIA() {
        return IA;
    }

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
