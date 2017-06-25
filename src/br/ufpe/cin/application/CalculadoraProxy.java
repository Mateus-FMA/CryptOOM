package br.ufpe.cin.application;

import br.ufpe.cin.cryptoom.distribution.invocation.AOR;
import br.ufpe.cin.cryptoom.distribution.invocation.Proxy;
import javafx.util.Pair;

/**
 * Created by Ricardo on 25/06/2017.
 */
public class CalculadoraProxy extends Proxy {
    public CalculadoraProxy(AOR aor) {
        super(aor);
    }

    @SuppressWarnings("unchecked")
    public void add (Integer a, Integer b) throws Exception {
        Pair argA = new Pair<Object, Class>(a, Integer.class);
        Pair argB = new Pair<Object, Class>(b, Integer.class);
        Pair<Object, Class>[] args = new Pair[] {argA, argB};
        invoke("add", args);
    }

    @Override
    public String getIdentifier() {
        return null;
    }
}
