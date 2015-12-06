package GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    protected ServerSocket serverSocket;
    protected Socket socket;
    protected PrintWriter out;
    protected BufferedReader in;

    public server(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            this.listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen()
    {
        try {
            this.socket = serverSocket.accept();
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
