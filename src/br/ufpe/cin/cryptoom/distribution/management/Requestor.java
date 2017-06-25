package br.ufpe.cin.cryptoom.distribution.management;

import br.ufpe.cin.cryptoom.distribution.requesting.Invocation;
import br.ufpe.cin.cryptoom.distribution.requesting.Message;
import br.ufpe.cin.cryptoom.distribution.requesting.Termination;
import br.ufpe.cin.cryptoom.infrastructure.handlers.ClientRequestHandler;
import br.ufpe.cin.cryptoom.infrastructure.handlers.TCPClientRequestHandler;
import br.ufpe.cin.cryptoom.infrastructure.serializer.AESCipher;
import br.ufpe.cin.cryptoom.infrastructure.serializer.Marshaller;

import java.io.IOException;

public class Requestor {

    private ClientRequestHandler clientRequestHandler;

    public Requestor() {
    }

    public Termination invokeRemoteMethod(Invocation invocation) throws Exception {
        clientRequestHandler = new TCPClientRequestHandler(invocation.getAOR().getAddress(), invocation.getAOR().getPort());
        Message request = new Message(invocation);

        //TODO encrypt
        clientRequestHandler.send(Marshaller.marshal(request));
        //clientRequestHandler.send(AESCipher.encryptByteArray(Marshaller.marshal(request)));

        //TODO reply
        Message reply = (Message) Marshaller.unmarshal(clientRequestHandler.receive());
        //Message reply = (Message) Marshaller.unmarshal(AESCipher.decryptByteArray(clientRequestHandler.receive()));
        return (Termination) reply.getBody();

//        return null;
    }
}
