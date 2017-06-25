package br.ufpe.cin;

import br.ufpe.cin.infrastructure.handlers.ClientRequestHandler;
import br.ufpe.cin.infrastructure.handlers.TCPClientRequestHandler;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by Ricardo on 21/06/2017.
 */
public class ClientRequestHandlerTest {

    public static void main(String[] args) throws IOException {
        ClientRequestHandler crh = new TCPClientRequestHandler(InetAddress.getLocalHost(), 50000);

        System.out.println("Client started");
        byte[] sendData = "Hello world".getBytes();
        byte[] receiveData;
        crh.send(sendData);
        System.out.println("Client sent");
        receiveData = crh.receive();
        System.out.println("Client received");
        System.out.println(new String(receiveData, "UTF-8"));
    }
}
