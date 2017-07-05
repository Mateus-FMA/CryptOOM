package br.ufpe.cin.application.poolCalculator.middlewareSupport;

/**
 * Created by Mateus de Freitas on 04/07/2017.
 */
public interface ICalculatorPool {
  Float add(Float a, Float b) throws Exception;
  Float sub(Float a, Float b) throws Exception;
  Float mult(Float a, Float b) throws Exception;
  Float div(Float a, Float b) throws Exception;
}
