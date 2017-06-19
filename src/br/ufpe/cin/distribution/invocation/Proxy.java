package br.ufpe.cin.distribution.invocation;

import br.ufpe.cin.distribution.management.Requestor;
import br.ufpe.cin.distribution.requesting.Invocation;
import br.ufpe.cin.distribution.requesting.Termination;
import javafx.util.Pair;

import java.io.Serializable;

public abstract class Proxy implements Serializable {
    private AOR aor;

    public Proxy(AOR aor) {
        this.aor = aor;
    }

    protected Termination invoke(String methodName, Pair<Object, Class>[] arguments) {
        Invocation invocation = new Invocation(methodName, arguments, aor);
        //TODO incomplete requestor
        Termination termination = new Requestor().remoteMethodInvocation(invocation);
        // in Proxy Impl call .getResult
        return termination;
    }

    public AOR getAOR() {
        return this.aor;
    }
    abstract String getIdentifier();
}
