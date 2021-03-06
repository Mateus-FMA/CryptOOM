package br.ufpe.cin.tests.common;

import br.ufpe.cin.cryptoom.common.NameService;
import br.ufpe.cin.cryptoom.distribution.invocation.AOR;
import br.ufpe.cin.cryptoom.distribution.invocation.Base;
import br.ufpe.cin.cryptoom.distribution.management.Invoker;

import java.io.IOException;
import java.net.InetAddress;

public class NameServiceInvokerTest {
    static AOR NAMING_SERVICE_AOR;

    static {
        try {
            NAMING_SERVICE_AOR = new AOR(0, InetAddress.getLocalHost(), 40000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Base nameServiceImpl = new NameService(NAMING_SERVICE_AOR);
        Invoker instance = Invoker.getInstance();
        instance.bindService(nameServiceImpl);
        instance.start();

        System.out.println("name Service Force Waiting");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
