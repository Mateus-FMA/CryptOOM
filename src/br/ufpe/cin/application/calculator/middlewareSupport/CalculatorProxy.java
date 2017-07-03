package br.ufpe.cin.application.calculator.middlewareSupport;

import br.ufpe.cin.cryptoom.distribution.invocation.AOR;
import br.ufpe.cin.cryptoom.distribution.invocation.Proxy;
import br.ufpe.cin.cryptoom.distribution.requesting.Termination;
import javafx.util.Pair;

/**
 * Created by Guilherme on 03/07/2017.
 */
public class CalculatorProxy extends Proxy implements ICalculator {
    public CalculatorProxy(AOR aor) {
        super(aor);
    }

    @Override
    public String getIdentifier() {
        return "Calculator Proxy";
    }

    @Override
    @SuppressWarnings("unchecked")
    public Integer add(Integer a, Integer b) {
        class Local {};
        Termination t = invoke(Local.class.getEnclosingMethod().getName(), new Pair[]{ new Pair<>(a, Integer.class), new Pair<>(b, Integer.class)});
        return (Integer) t.getResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Integer sub(Integer a, Integer b) {
        class Local {};
        Termination t = invoke(Local.class.getEnclosingMethod().getName(), new Pair[]{ new Pair<>(a, Integer.class), new Pair<>(b, Integer.class)});
        return (Integer) t.getResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Integer mult(Integer a, Integer b) {
        class Local {};
        Termination t = invoke(Local.class.getEnclosingMethod().getName(), new Pair[]{ new Pair<>(a, Integer.class), new Pair<>(b, Integer.class)});
        return (Integer) t.getResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Integer div(Integer a, Integer b) {
        class Local {};
        Termination t = invoke(Local.class.getEnclosingMethod().getName(), new Pair[]{ new Pair<>(a, Integer.class), new Pair<>(b, Integer.class)});
        return (Integer) t.getResult();
    }
}
