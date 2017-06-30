package br.ufpe.cin.cryptoom.distribution.management;

import br.ufpe.cin.cryptoom.distribution.invocation.AOR;
import br.ufpe.cin.cryptoom.distribution.invocation.Base;
import br.ufpe.cin.cryptoom.distribution.requesting.Invocation;
import br.ufpe.cin.cryptoom.distribution.requesting.Message;
import br.ufpe.cin.cryptoom.distribution.requesting.Termination;
import br.ufpe.cin.cryptoom.infrastructure.handlers.ServerRequestHandler;
import br.ufpe.cin.cryptoom.infrastructure.handlers.tcp.TCPServerRequestHandler;
import br.ufpe.cin.cryptoom.infrastructure.serializer.Marshaller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Invoker {
    private static Invoker instance;

    private Map<AOR, Base> services;

    private Invoker() {
        this.services = new ConcurrentHashMap<>();
    }

    public static Invoker getInstance() {
        return Invoker.instance == null ? new Invoker() : Invoker.instance;
    }

    public void bindService(Base remoteObj) {
        this.services.put(remoteObj.getAOR(), remoteObj);
    }

    public void unbindService(Base remoteObj) {
        this.services.remove(remoteObj.getAOR());
    }

    public void start() {
        services.forEach((aor, service) -> new Thread(new RequestListener(aor)).start());
    }


    private class RequestListener implements Runnable {
        private AOR aor;

        public RequestListener(AOR aor) {
            this.aor = aor;
        }

        @Override
        public void run() {
            try {
                ServerSocket welcomeSocket = new ServerSocket(aor.getPort(), 50, aor.getAddress());
                while (true) {
                    Socket connectionSocket = welcomeSocket.accept();
                    new Thread(new RunRequest(new TCPServerRequestHandler(connectionSocket))).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class RunRequest implements Runnable {
        private ServerRequestHandler srh;

        public RunRequest(ServerRequestHandler srh) {
            this.srh = srh;
        }

        @Override
        public void run() {
            try {
                Message message = (Message) Marshaller.unmarshal(srh.receive());
                Invocation invocation = (Invocation) message.getBody();
                Termination termination =  services.get(invocation.getAOR()).processAndRunRemoteInvocation(invocation);
                Message reply = new Message(termination);
                srh.send(Marshaller.marshal(reply));
            } catch (Exception e) {
                //change exception
                e.printStackTrace();
            }
        }
    }

}
