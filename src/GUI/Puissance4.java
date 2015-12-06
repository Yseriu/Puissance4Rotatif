package GUI;

public class Puissance4 extends AbstractP4 {

    protected char[][] map = {{' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' '}};
    protected int[] remainingRotations = {4, 4};
    protected int[] remainingPreviews = {2, 2};
    protected int[] remainingTokens = {21, 21};
    protected char player;
    protected int type;
    protected int phase = PHASE_MENU;
    protected boolean isServer = false;
    protected server server;
    protected client client;

    protected static int PORT = 12345;

    public boolean canPlay(int col)
    {
        return this.getMapItem(col, 0) == Puissance4.PLAYER_NONE;
    }

    public void play(int col) {
        if (this.canPlay(col)
                && !this.isLAN() // Case not lan
                || this.getPlayer() == this.whoami() // I am the one to play
                )
        {
            System.out.println("playing !");
            int i = 6;
            while (getMapItem(col, i) != Puissance4.PLAYER_NONE) i--;
            this.setMapItem(col, i, this.getPlayer());
            this.useToken();

            if(this.isLAN())
            {
                System.out.println("Sending "+col);
                if(this.isServer)
                    this.getServer().send((char) col);
                else
                    this.getClient().send((char) col);
                System.out.println("col send");
            }

            this.changePlayer();
        }
    }
    public void playRecieved(int col)
    {
        if(this.canPlay(col))
        {
            int i = 6;
            while (getMapItem(col, i) != Puissance4.PLAYER_NONE) i--;
            this.setMapItem(col, i, this.getPlayer());
            this.useToken();
            this.changePlayer();
        }
    }

    public void SecondPlayer() {
        if(this.isIA() && this.getPlayer() == Puissance4.PLAYER_2)
        {
            this.IA();
        }
        else if (this.isLAN() && this.whoami() != this.getPlayer())
        {
            this.LAN();
        }
    }

    public void IA()
    {
        this.play((int)(Math.random()*6));
    }

    public void LAN()
    {
        int col;
        System.out.println("Recieving col");
        if(this.isServer)
            col = this.getServer().recieve();
        else
            col = this.getClient().recieve();
        System.out.println(" Recieved");
        this.playRecieved(col);

        this.SecondPlayer();
    }

    public void initLan(boolean isServer)
    {
        this.isServer = isServer;
        if(isServer)
        {
            System.out.println("Serveside");
            this.server = new server(Puissance4.PORT);
            this.init();
            this.getServer().send(this.getPlayer());
            System.out.println("Sent player " + this.getPlayer());

        }
        else
        {
            System.out.println("ClientSide");
            this.client = new client(Puissance4.PORT);
            this.setPlayer((char)(this.getClient().recieve()));
            System.out.println("Recieved player " + this.getPlayer());
        }
        this.debug();
    }

    public void changePlayer()
    {
        this.setPlayer(this.getPlayer() == Puissance4.PLAYER_1 ? Puissance4.PLAYER_2 : Puissance4.PLAYER_1);
    }

    public static void main(String args[])
    {
        new Puissance4();
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
        return this.type == Puissance4.TYPE_IA;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    @Override
    public void init() {
            this.setPlayer(Math.random() > 1 ? Puissance4.PLAYER_1 : Puissance4.PLAYER_2);
    }

    public boolean isLAN(){ return this.type == TYPE_LAN; }

    public char whoami() {
        return this.isServer ? Puissance4.PLAYER_1 : Puissance4.PLAYER_2;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public GUI.server getServer() {
        return server;
    }

    public GUI.client getClient() {
        return client;
    }

    @Override
    public void debug() {
        System.out.println(this.isLAN());
        System.out.println(this.isServer);
        System.out.println(this.getPlayer());
        System.out.println(this.whoami());
    }
}
