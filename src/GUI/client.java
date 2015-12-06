package GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Yseriu on 05/12/2015.
 */
public class client {

    protected Socket socket;
    protected PrintWriter out;
    protected BufferedReader in;

    public client(int port) {
        try {
            this.socket = new Socket(InetAddress.getLocalHost(), port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(char col)
    {
        try {
            out = new PrintWriter(socket.getOutputStream());
            out.print(col);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int recieve()
    {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            return in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
