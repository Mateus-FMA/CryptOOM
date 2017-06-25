package br.ufpe.cin.infrastructure.handlers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Ricardo on 21/06/2017.
 */
public class TCPServerRequestHandler implements ServerRequestHandler{

    private int port;

    private ServerSocket welcomeSocket;
    private Socket connectionSocket;
    private DataOutputStream outToClient;
    private DataInputStream inFromClient;

    public TCPServerRequestHandler(int port) throws IOException {
        this.port = port;

        welcomeSocket = new ServerSocket(port);
        connectionSocket = welcomeSocket.accept();
        outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        inFromClient = new DataInputStream(connectionSocket.getInputStream());
    }

    public int getPort() {
        return port;
    }

    public void send(byte[] data) throws IOException {
        int dataLength = data.length;
        outToClient.writeInt(dataLength);
        outToClient.write(data);
        outToClient.flush();

        outToClient.close();
        inFromClient.close();
        connectionSocket.close();
    }

    public byte[] receive() throws IOException {
        int dataLength = inFromClient.readInt();
        byte[] data = new byte[dataLength];
        inFromClient.read(data, 0, dataLength);

        return data;
    }

}
