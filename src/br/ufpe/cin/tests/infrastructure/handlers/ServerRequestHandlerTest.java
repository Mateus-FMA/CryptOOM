package br.ufpe.cin.tests.infrastructure.handlers;

import br.ufpe.cin.cryptoom.infrastructure.handlers.ServerRequestHandler;
import br.ufpe.cin.cryptoom.infrastructure.handlers.TCPServerRequestHandler;

import java.io.IOException;

/**
 * Created by Ricardo on 21/06/2017.
 */
public class ServerRequestHandlerTest {

    public static void main(String[] args) throws IOException {
        ServerRequestHandler srh = new TCPServerRequestHandler(50000);

        byte[] receiveData, sendData;
        String sReceiveData = "";
        System.out.println("Server started");
        receiveData = srh.receive();
        System.out.println("Server received");
        sReceiveData = new String(receiveData, "UTF-8");
        System.out.println(sReceiveData);
        sReceiveData += " MA MAAAN";
        sendData = sReceiveData.getBytes();
        srh.send(sendData);
        System.out.println("Server sent");

    }

}
