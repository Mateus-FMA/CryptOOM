package br.ufpe.cin.cryptoom.infrastructure.handlers;

import java.io.IOException;
import java.net.InetAddress;

public interface ClientRequestHandler {
    InetAddress getAddress();
    int getPort();
    void close() throws IOException;

    void send(byte[] data) throws IOException;
    byte[] receive() throws IOException;
}
