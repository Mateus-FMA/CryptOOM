package br.ufpe.cin.infrastructure.handlers;

import java.io.IOException;

public interface ServerRequestHandler {
    int getPort();

    void send(byte[] data) throws IOException;
    byte[] receive() throws IOException;
}
