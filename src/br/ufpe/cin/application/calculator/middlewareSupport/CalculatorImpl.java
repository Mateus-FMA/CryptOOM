package br.ufpe.cin.application.calculator.middlewareSupport;

import br.ufpe.cin.cryptoom.distribution.invocation.AOR;
import br.ufpe.cin.cryptoom.distribution.invocation.Base;

/**
 * Created by Guilherme on 03/07/2017.
 */
public class CalculatorImpl extends Base implements ICalculator {
    public CalculatorImpl(AOR aor) {
        super(aor);
    }

    @Override
    public String getIdentifier() {
        return "Calculator Impl";
    }

    @Override
    public Float add(Float a, Float b) {
        return a+b;
    }

    @Override
    public Float sub(Float a, Float b) { return a-b; }

    @Override
    public Float mult(Float a, Float b) {
        return a*b;
    }

    @Override
    public Float div(Float a, Float b) {
        return a/b;
    }
}
