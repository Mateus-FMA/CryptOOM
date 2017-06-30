package br.ufpe.cin.cryptoom.distribution.management;

import br.ufpe.cin.cryptoom.distribution.requesting.Invocation;
import br.ufpe.cin.cryptoom.distribution.requesting.Message;
import br.ufpe.cin.cryptoom.distribution.requesting.Termination;
import br.ufpe.cin.cryptoom.infrastructure.handlers.ClientRequestHandler;
import br.ufpe.cin.cryptoom.infrastructure.handlers.tcp.TCPClientRequestHandler;
import br.ufpe.cin.cryptoom.infrastructure.serializer.AESCipher;
import br.ufpe.cin.cryptoom.infrastructure.serializer.Marshaller;

public class Requestor {

    private ClientRequestHandler clientRequestHandler;

    public Requestor() {
    }

    public Termination remoteMethodInvocation(Invocation invocation) throws Exception {
        clientRequestHandler = new TCPClientRequestHandler(invocation.getAOR().getAddress(), invocation.getAOR().getPort());
        Message request = new Message(invocation);
        clientRequestHandler.send(AESCipher.encryptByteArray(Marshaller.marshal(request)));
        Message reply = (Message) Marshaller.unmarshal(AESCipher.decryptByteArray(clientRequestHandler.receive()));

        return (Termination)reply.getBody();
    }
}
