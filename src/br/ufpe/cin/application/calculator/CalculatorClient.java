package br.ufpe.cin.application.calculator;

import br.ufpe.cin.application.calculator.middlewareSupport.CalculatorProxy;
import br.ufpe.cin.cryptoom.common.NameServiceProxy;
import br.ufpe.cin.cryptoom.distribution.invocation.Proxy;

import java.net.InetAddress;

/**
 * Created by Guilherme on 03/07/2017.
 */
public class CalculatorClient {
    public static void main(String[] args) throws Exception {
        NameServiceProxy nsp = new NameServiceProxy(InetAddress.getLocalHost(), 40000);

        Proxy calculatorProxy = nsp.lookup("calculator");

        while(true) {
            System.out.println(((CalculatorProxy)calculatorProxy).add(3,4));
            Thread.sleep(100);
        }

    }
}
