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
    public Float add (Float a, Float b) throws Exception {
        class Local {}
        Termination t = invoke(Local.class.getEnclosingMethod().getName(), new Pair[]{ new Pair<>(a, Float.class), new Pair<>(b, Float.class)});
        return (Float) t.getResult();
    }

    @Override
     public String getIdentifier() {
        return "Calculator Proxy";
    }
}
