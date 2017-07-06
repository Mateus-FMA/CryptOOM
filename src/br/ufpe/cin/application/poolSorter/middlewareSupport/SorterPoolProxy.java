package br.ufpe.cin.application.poolSorter.middlewareSupport;

import br.ufpe.cin.cryptoom.distribution.invocation.AOR;
import br.ufpe.cin.cryptoom.distribution.invocation.Proxy;
import br.ufpe.cin.cryptoom.distribution.requesting.Termination;
import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Created by Ricardo on 06/07/2017.
 */
public class SorterPoolProxy extends Proxy implements ISorterPool {

    public SorterPoolProxy(AOR aor) { super(aor); }

    @Override
    public String getIdentifier() {
        return "Sorter Pool Proxy";
    }

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> list) {
        class Local {}
        Termination t = invoke(Local.class.getEnclosingMethod().getName(), new Pair[]{new Pair<>(list, ArrayList.class)});
        return (ArrayList<Integer>) t.getResult();
    }

}
