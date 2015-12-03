package main;

/**
 * Created by Yseriu on 26/11/2015.
 */
public class Puissance4 {

    protected char[][] map;
    protected int[] remainingRotations = {4, 4};
    protected int[] remainigPreviews = {2, 2};
    protected char player = 'X';
    protected P4UI ui;

    public boolean canPlay(int col)
    {
        return this.getMapItem(col, 0) == ' ';
    }

    public Puissance4 play(int col)
    {
        if(!this.canPlay(col)) return null;
        int i = 6;
        while(getMapItem(col, i) != ' ') i--;
        this.setMapItem(col, i, this.getPlayer());
        this.changePlayer();
        return this;
    }
    public char[][] initMap()
    {
        char[][] lmap = {{' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}};
        this.setMap(lmap);
        return lmap;
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
        this.initMap();
        this.setUi(new P4UI(this));
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

    public boolean canUseRotation(char player)
    {
        return this.getRemainingRotations()[player == 'X' ? 0 : 1] > 0;
    }

    public boolean canUsePreview(char player)
    {
        return this.getRemainigPreviews()[player == 'X' ? 0 : 1] > 0;
    }

    public P4UI getUi() {
        return ui;
    }

    public void setUi(P4UI ui) {
        this.ui = ui;
    }
}
