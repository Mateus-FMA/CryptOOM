package br.ufpe.cin.cryptoom.distribution.invocation;

import br.ufpe.cin.cryptoom.distribution.management.Requestor;
import br.ufpe.cin.cryptoom.distribution.requesting.Invocation;
import br.ufpe.cin.cryptoom.distribution.requesting.Termination;
import javafx.util.Pair;

import java.io.Serializable;

public abstract class Proxy implements Serializable {
    private AOR aor;

    public Proxy(AOR aor) {
        this.aor = aor;
    }

    protected Termination invoke(String methodName, Pair<Object, Class>[] arguments) {
        Invocation invocation = new Invocation(methodName, arguments, aor);
        Termination termination = null;
        try {
            termination = new Requestor().remoteMethodInvocation(invocation);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return termination;
    }

    public AOR getAOR() {
        return this.aor;
    }
    public abstract String getIdentifier();
}
