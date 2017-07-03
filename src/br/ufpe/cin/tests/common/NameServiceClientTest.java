package br.ufpe.cin.tests.common;


import br.ufpe.cin.cryptoom.common.NameService;
import br.ufpe.cin.cryptoom.common.NameServiceProxy;
import br.ufpe.cin.cryptoom.distribution.invocation.Proxy;
import br.ufpe.cin.tests.distribution.management.CalcProxy;
import br.ufpe.cin.tests.distribution.management.InvokerTest;

import java.net.InetAddress;

public class NameServiceClientTest {
    public static void main(String[] args) throws Exception {
        NameServiceProxy nsp = new NameServiceProxy(InetAddress.getLocalHost(), 40000);

        //server part, just testing
        CalcProxy c = new CalcProxy(InvokerTest.CALCULATOR_AOR);
        System.out.println("binding...");
        nsp.bind("calculator", c);
        //client part

        System.out.println("getting");
        Proxy p = nsp.lookup("calculator");
        System.out.println(p.getAOR().getPort());
        System.out.println(p.getAOR().getId());
//        Proxy p = nsp.lookup("calculator");



    }
}
