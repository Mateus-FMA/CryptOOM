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
    public Float add(Float a, Float b) {
        class Local {}
        Termination t = invoke(Local.class.getEnclosingMethod().getName(), new Pair[]{ new Pair<>(a, Float.class), new Pair<>(b, Float.class)});
        return (Float) t.getResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Float sub(Float a, Float b) {
        class Local {}
        Termination t = invoke(Local.class.getEnclosingMethod().getName(), new Pair[]{ new Pair<>(a, Float.class), new Pair<>(b, Float.class)});
        return (Float) t.getResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Float mult(Float a, Float b) {
        class Local {}
        Termination t = invoke(Local.class.getEnclosingMethod().getName(), new Pair[]{ new Pair<>(a, Float.class), new Pair<>(b, Float.class)});
        return (Float) t.getResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Float div(Float a, Float b) {
        class Local {}
        Termination t = invoke(Local.class.getEnclosingMethod().getName(), new Pair[]{ new Pair<>(a, Float.class), new Pair<>(b, Float.class)});
        return (Float) t.getResult();
    }
}
