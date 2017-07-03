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
    public Integer add(Integer a, Integer b) {
        return a+b;
    }

    @Override
    public Integer sub(Integer a, Integer b) {
        return a-b;
    }

    @Override
    public Integer mult(Integer a, Integer b) {
        return a*b;
    }

    @Override
    public Integer div(Integer a, Integer b) {
        return a/b;
    }
}
