package br.ufpe.cin.cryptoom.infrastructure.handlers.tcp;

import br.ufpe.cin.cryptoom.infrastructure.handlers.ClientRequestHandler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Ricardo on 21/06/2017.
 */
public class TCPClientRequestHandler implements ClientRequestHandler {

    private InetAddress address;
    private int port;

    private Socket connectionSocket;
    private DataOutputStream outToServer;
    private DataInputStream inFromServer;

    public TCPClientRequestHandler(InetAddress address, int port) throws IOException {
        this.address = address;
        this.port = port;
        connectionSocket = new Socket(address, port);
        outToServer = new DataOutputStream(connectionSocket.getOutputStream());
        inFromServer = new DataInputStream(connectionSocket.getInputStream());
    }

    public InetAddress getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }

    public void send(byte[] data) throws IOException {
        int dataLength = data.length;
        outToServer.writeInt(dataLength);
        outToServer.write(data, 0, dataLength);
        outToServer.flush();
    }

    public byte[] receive() throws IOException {
        int dataLength = inFromServer.readInt();
        byte[] data = new byte[dataLength];
        inFromServer.read(data, 0, dataLength);

        outToServer.close();
        inFromServer.close();
        connectionSocket.close();

        return data;
    }

}
