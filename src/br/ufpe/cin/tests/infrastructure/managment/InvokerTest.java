package br.ufpe.cin.tests.infrastructure.managment;

import br.ufpe.cin.cryptoom.distribution.invocation.AOR;
import br.ufpe.cin.cryptoom.distribution.invocation.Base;
import br.ufpe.cin.cryptoom.distribution.management.Invoker;

import java.net.InetAddress;

/**
 * Created by Guilherme on 29/06/2017.
 */
public class InvokerTest {
    static AOR CALCULATOR_AOR;

    static {
        AOR calculatorAor = null;
        try {
            calculatorAor = new AOR(1, InetAddress.getLocalHost(), 50000);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            CALCULATOR_AOR = calculatorAor;
        }
    }

    public static void main(String[] args) throws Exception {

        Base calculatorImpl = new CalcImplTest(CALCULATOR_AOR);
        Invoker instance = Invoker.getInstance();
        instance.bindService(calculatorImpl);
        instance.start();

        System.out.println("forcewaiting");
        System.in.read();
    }
}
