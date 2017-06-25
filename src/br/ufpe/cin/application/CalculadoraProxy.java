package br.ufpe.cin.application;

import br.ufpe.cin.cryptoom.distribution.invocation.AOR;
import br.ufpe.cin.cryptoom.distribution.invocation.Proxy;
import br.ufpe.cin.cryptoom.distribution.requesting.Termination;
import javafx.util.Pair;

/**
 * Created by Ricardo on 25/06/2017.
 */
public class CalculadoraProxy extends Proxy {
    public CalculadoraProxy(AOR aor) {
        super(aor);
    }

    @SuppressWarnings("unchecked")
    public Integer add (Integer a, Integer b) throws Exception {
        Pair argA = new Pair<Object, Class>(a, Integer.class);
        Pair argB = new Pair<Object, Class>(b, Integer.class);
        Pair<Object, Class>[] args = new Pair[] {argA, argB};
        Termination t = invoke("add", args);
        return (Integer) t.getResult();
    }

    @Override
    public String getIdentifier() {
        return null;
    }
}
