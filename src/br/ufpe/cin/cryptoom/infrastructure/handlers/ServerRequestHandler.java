package br.ufpe.cin.cryptoom.infrastructure.handlers;

import java.io.IOException;

public interface ServerRequestHandler {
    void send(byte[] data) throws IOException;
    byte[] receive() throws IOException;
}
