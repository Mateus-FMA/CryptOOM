package br.ufpe.cin.cryptoom.common;

import br.ufpe.cin.cryptoom.distribution.invocation.AOR;
import br.ufpe.cin.cryptoom.distribution.invocation.Proxy;
import br.ufpe.cin.cryptoom.distribution.requesting.Termination;
import javafx.util.Pair;

import java.net.InetAddress;

public class NameServiceProxy extends Proxy implements INameService {

    public NameServiceProxy(InetAddress localHost, int port) {
        super(new AOR(0, localHost, port));
    }

    @Override
    public String getIdentifier() {
        return "Name Service Proxy";
    }

    @Override
    @SuppressWarnings("unchecked")
    public void bind(String identifier, Proxy proxy) throws Exception {
        class Local {};
        invoke(Local.class.getEnclosingMethod().getName(), new Pair[]{new Pair<>(identifier, String.class), new Pair<>(proxy, Proxy.class)});
    }

    @Override
    @SuppressWarnings("unchecked")
    public void unbind(String identifier) throws Exception {
        class Local {};
        invoke(Local.class.getEnclosingMethod().getName(), new Pair[]{new Pair<>(identifier, String.class)});
    }

    @Override
    @SuppressWarnings("unchecked")
    public Proxy lookup(String identifier) throws Exception{
        class Local {};
        Termination ter = invoke(Local.class.getEnclosingMethod().getName(), new Pair[]{new Pair<>(identifier, String.class)});
        return (Proxy) ter.getResult();
    }
}
