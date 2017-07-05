package br.ufpe.cin.application.poolCalculator;

import br.ufpe.cin.application.poolCalculator.middlewareSupport.CalculatorPoolProxy;
import br.ufpe.cin.cryptoom.common.NameServiceProxy;
import br.ufpe.cin.cryptoom.distribution.invocation.Proxy;

import java.net.InetAddress;

/**
 * Created by Mateus de Freitas on 04/07/2017.
 */
public class CalculatorPoolClient {
  public static void main(String[] args) throws Exception {
    NameServiceProxy nsp = new NameServiceProxy(InetAddress.getLocalHost(), 40000);

    Proxy calculatorProxy = nsp.lookup("calculator");
    float a=0,b=0;
    while(true) {
      System.out.println(((CalculatorPoolProxy)calculatorProxy).add(a++, b++));
      //Thread.sleep(100);
    }

  }
}
