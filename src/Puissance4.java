/**
 * Created by Yseriu on 26/11/2015.
 */
public class Puissance4 {

    protected char[][] map;
    protected int[] remainingRotations = {4, 4};
    protected int[] remainigPreviews = {2, 2};
    protected char player = 'X';

    public void play(int col) {}
    public boolean canPlay(int col) {}
    public boolean isValidColumn(int col) {}
    public int ask() {}
    public void disp()
    {
        for (int i = 0; i < 7; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                System.out.print(this.getMap()[i][j]);
            }
            System.out.println();
        }
    }
    public void initMap()
    {
        char[] line = {' ', ' ', ' ', ' ', ' ', ' ', ' '};
        char[][] lmap = {line, line, line, line, line, line, line};
        this.setMap(lmap);
    }

    public void changePlayer()
    {
        this.setPlayer(this.getPlayer() == 'X' ? 'O' : 'X');
    }

    public static void main(String args[])
    {

    }

    public Puissance4()
    {
        this.initMap();
    }

    public void changeMapItem(int x, int y, char p)
    {
        char[][] lmap = this.getMap();
        lmap[x][y] = p;
        this.setMap(lmap);
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
}
