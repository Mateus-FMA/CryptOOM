package br.ufpe.cin.cryptoom.distribution.management;

import br.ufpe.cin.cryptoom.distribution.requesting.Invocation;
import br.ufpe.cin.cryptoom.distribution.requesting.Message;
import br.ufpe.cin.cryptoom.distribution.requesting.Termination;
import br.ufpe.cin.cryptoom.infrastructure.handlers.ClientRequestHandler;

public class Requestor {

    private ClientRequestHandler clientRequestHandler;

    public Requestor() {
    }

    public Termination remoteMethodInvocation(Invocation invocation){
        //TODO
        //create new Impl ClientRequestHandler with invocation.getAOR().getPort() and invocation.getAOR().getAddress()
        //clientRequestHandler = new TCPClientRequestHandler();
        Message request = new Message(invocation);
        //clientRequestHandler.send(Chryptographer.crypt(Marshaller.marshall(request));
        // Message reply = (Message) Marshaller.unmarshall(Cryptographer.decrypt(clientRequestHandler.receive())
        //return (Termination) reply.body()
        return null;
    }
}
