package br.ufpe.cin.application.calculator;

import br.ufpe.cin.application.calculator.middlewareSupport.CalculatorImpl;
import br.ufpe.cin.application.calculator.middlewareSupport.CalculatorProxy;
import br.ufpe.cin.cryptoom.common.NameServiceProxy;
import br.ufpe.cin.cryptoom.distribution.invocation.AOR;
import br.ufpe.cin.cryptoom.distribution.invocation.Base;
import br.ufpe.cin.cryptoom.distribution.management.Invoker;

import java.net.InetAddress;

/**
 * Created by Guilherme on 03/07/2017.
 */
public class CalculatorServer {
    public static AOR CALCULATOR_AOR;

    static {
        try {
            CALCULATOR_AOR = new AOR(1, InetAddress.getLocalHost(), 50000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws  Exception{
        System.out.println("Creating Calculator Implementation instance");
        Base calculatorImpl = new CalculatorImpl(CALCULATOR_AOR);
        Invoker instance = Invoker.getInstance();
        System.out.println("Now binding in its invoker");
        instance.bindService(calculatorImpl);
        instance.start();
        System.out.println("Now Calculator is ready to get requests");

        //creating proxy in Naming Service
        NameServiceProxy nsp = new NameServiceProxy(InetAddress.getLocalHost(), 40000);

        //server part, just testing
        CalculatorProxy calculatorProxy = new CalculatorProxy(CALCULATOR_AOR);
        System.out.println("binding calculator proxy in naming service...");
        nsp.bind("calculator", calculatorProxy);
        System.out.println("Proxy binded");

        //force the program waiting
        System.in.read();


    }
}
