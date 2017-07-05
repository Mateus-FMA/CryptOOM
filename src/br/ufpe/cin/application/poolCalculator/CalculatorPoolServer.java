package br.ufpe.cin.application.poolCalculator;

import br.ufpe.cin.application.poolCalculator.middlewareSupport.CalculatorPoolProxy;
import br.ufpe.cin.application.poolCalculator.middlewareSupport.CalculatorPoolImpl;
import br.ufpe.cin.cryptoom.common.NameServiceProxy;
import br.ufpe.cin.cryptoom.distribution.invocation.AOR;
import br.ufpe.cin.cryptoom.distribution.invocation.Base;
import br.ufpe.cin.cryptoom.distribution.management.Invoker;

import java.net.InetAddress;

/**
 * Created by Guilherme on 03/07/2017.
 */
public class CalculatorPoolServer {
  public static AOR CALCULATOR_AOR;

  static {
    try {
      CALCULATOR_AOR = new AOR(1, InetAddress.getLocalHost(), 50001);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws  Exception{
    System.out.println("Creating Calculator Implementation instance");
    Base calculatorImpl = new CalculatorPoolImpl(CALCULATOR_AOR);
    Invoker instance = Invoker.getInstance();
    System.out.println("Now binding in its invoker");
    instance.bindService(calculatorImpl);
    instance.start();
    System.out.println("Now Calculator is ready to get requests");

    //creating proxy in Naming Service
    NameServiceProxy nsp = new NameServiceProxy(InetAddress.getLocalHost(), 40000);

    //server part, just testing
    CalculatorPoolProxy calculatorProxy = new CalculatorPoolProxy(CALCULATOR_AOR);
    System.out.println("binding calculator proxy in naming service...");
    nsp.bind("calculator", calculatorProxy);
    System.out.println("Proxy binded");

    //force the program waiting
    System.in.read();


  }
}
