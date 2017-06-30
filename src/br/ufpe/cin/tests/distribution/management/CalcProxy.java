package br.ufpe.cin.tests.distribution.management;

import br.ufpe.cin.cryptoom.distribution.invocation.AOR;
import br.ufpe.cin.cryptoom.distribution.invocation.Proxy;
import br.ufpe.cin.cryptoom.distribution.requesting.Termination;
import javafx.util.Pair;

/**
 * Created by Guilherme on 29/06/2017.
 */
public class CalcProxy extends Proxy {
    public CalcProxy(AOR aor) {
        super(aor);
    }

    @SuppressWarnings("unchecked")
    public Integer add (Integer a, Integer b) throws Exception {
        Termination t = invoke("add", new Pair[]{ new Pair<>(a, Integer.class), new Pair<>(b, Integer.class)});
        return (Integer) t.getResult();
    }

    @Override
    protected String getIdentifier() {
        return "Calculator Proxy";
    }
}
