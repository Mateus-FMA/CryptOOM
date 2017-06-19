package br.ufpe.cin.infrastructure.handlers;

import java.net.InetAddress;

public interface ClientRequestHandler {

    InetAddress getAdress();

    int getPort();

    void send(byte[] data);

    byte[] receive();
}
