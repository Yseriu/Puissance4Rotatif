package main;

/**
 * Created by Yseriu on 26/11/2015.
 */
public class Puissance4 {

    protected char[][] map = {{' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}};
    protected int[] remainingRotations = {4, 2};
    protected int[] remainigPreviews = {2, 2};
    protected int[] remainingTokens = {21, 21};
    protected char player = 'X';
    protected boolean IA = false;

    public boolean canPlay(int col)
    {
        return this.getMapItem(col, 0) == ' ';
    }

    public Puissance4 play(int col) {
        if (!this.canPlay(col)) return null;
        int i = 6;
        while (getMapItem(col, i) != ' ') i--;
        this.setMapItem(col, i, this.getPlayer());
        this.useToken();
        this.changePlayer();

        if(this.isIA() && this.getPlayer() == 'O')
        {
            this.play(this.IA());
        }
        return this;
    }

    private int IA() {
        return 1;
    }

    public void changePlayer()
    {
        this.setPlayer(this.getPlayer() == 'X' ? 'O' : 'X');
    }

    public static void main(String args[])
    {
        Puissance4 game = new Puissance4();
        if(args.length > 0)
            if (args[0] == "ia")
                game.setIA(true);
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

    public int[] getRemainingRotations() {
        return remainingRotations;
    }

    public void setRemainingRotations(int[] remainingRotations) {
        this.remainingRotations = remainingRotations;
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

    public int[] getRemainigPreviews() {
        return remainigPreviews;
    }

    public void setRemainigPreviews(int[] remainigPreviews) {
        this.remainigPreviews = remainigPreviews;
    }

    public void usePreview(char player)
    {
        int[] lp = this.getRemainigPreviews();
        lp[player == 'X' ? 0 : 1]--;
        this.setRemainigPreviews(lp);
    }

    public void useRotation(char player)
    {
        int[] lr = this.getRemainingRotations();
        lr[player == 'X' ? 0 : 1]--;
        this.setRemainingRotations(lr);
    }

    public void useToken()
    {
        int[] lt = this.getRemainingTokens();
        lt[this.getPlayer() == 'X' ? 0 : 1]--;
        this.setRemainingTokens(lt);
    }

    public boolean canUseRotation()
    {
        return this.getRemainingRotations()[this.getPlayer() == 'X' ? 0 : 1] > 0;
    }

    public boolean canUsePreview()
    {
        return this.getRemainigPreviews()[this.getPlayer() == 'X' ? 0 : 1] > 0;
    }

    public int[] getRemainingTokens() {
        return remainingTokens;
    }

    public void setRemainingTokens(int[] remainingTokens) {
        this.remainingTokens = remainingTokens;
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
}
