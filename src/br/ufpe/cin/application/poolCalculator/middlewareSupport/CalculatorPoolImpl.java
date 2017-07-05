package br.ufpe.cin.application.poolCalculator.middlewareSupport;

import br.ufpe.cin.cryptoom.distribution.invocation.AOR;
import br.ufpe.cin.cryptoom.distribution.invocation.Base;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Mateus de Freitas on 04/07/2017.
 */
public class CalculatorPoolImpl extends Base implements ICalculatorPool {
  private List<Calculator> pool;

  private class Calculator {
    ReentrantLock lock;

    Calculator() {
      lock = new ReentrantLock();
    }

    float add(float a, float b) {
      lock.lock();
      float result = a + b;
      lock.unlock();

      return result;
    }

    float sub(float a, float b) {
      lock.lock();
      float result = a - b;
      lock.unlock();

      return result;
    }

    float mult(float a, float b) {
      lock.lock();
      float result = a * b;
      lock.unlock();

      return result;
    }

    float div(float a, float b) {
      lock.lock();
      float result = a / b;
      lock.unlock();

      return result;
    }
  }

  public CalculatorPoolImpl(AOR aor) {
    super(aor);
    pool = IntStream.range(0, 10).mapToObj(index -> new Calculator()).collect(Collectors.toList());
  }

  @Override
  public String getIdentifier() {
    return "CalculatorPool";
  }

  @Override
  public Float add(Float a, Float b) throws Exception {
    Calculator c = pool.stream()
            .filter(calc -> calc.lock.tryLock())
            .findFirst()
            .orElseThrow(() -> new Exception("Cannot find a Calculator."));

    return c.add(a, b);
  }

  @Override
  public Float sub(Float a, Float b) throws Exception {
    Calculator c = pool.stream()
            .filter(calc -> calc.lock.tryLock())
            .findFirst()
            .orElseThrow(() -> new Exception("Cannot find a Calculator."));

    return c.sub(a, b);
  }

  @Override
  public Float mult(Float a, Float b) throws Exception {
    Calculator c = pool.stream()
            .filter(calc -> calc.lock.tryLock())
            .findFirst()
            .orElseThrow(() -> new Exception("Cannot find a Calculator."));

    return c.mult(a, b);
  }

  @Override
  public Float div(Float a, Float b) throws Exception {
    Calculator c = pool.stream()
            .filter(calc -> calc.lock.tryLock())
            .findFirst()
            .orElseThrow(() -> new Exception("Cannot find a Calculator."));

    return c.div(a, b);
  }
}
