package br.ufpe.cin.infrastructure.handlers;

import java.net.InetAddress;


public interface ServerRequestHandler {
    void send(byte[] data);

    byte[] receive();
}
