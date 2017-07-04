package br.ufpe.cin.cryptoom.infrastructure.handlers.tcp;

import br.ufpe.cin.cryptoom.infrastructure.handlers.ServerRequestHandler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Ricardo on 21/06/2017.
 */
public class TCPServerRequestHandler implements ServerRequestHandler {

    private Socket connectionSocket;
    private DataOutputStream outToClient;
    private DataInputStream inFromClient;

    public TCPServerRequestHandler(Socket connectionSocket) throws IOException {
        this.connectionSocket = connectionSocket;
        outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        inFromClient = new DataInputStream(connectionSocket.getInputStream());
    }

    public void close() throws IOException {
        outToClient.close();
        inFromClient.close();
        connectionSocket.close();
    }

    public void send(byte[] data) throws IOException {
        int dataLength = data.length;
        outToClient.writeInt(dataLength);
        outToClient.write(data);
        outToClient.flush();
    }

    public byte[] receive() throws IOException {
        int dataLength = inFromClient.readInt();
        byte[] data = new byte[dataLength];
        inFromClient.read(data, 0, dataLength);

        return data;
    }

}
