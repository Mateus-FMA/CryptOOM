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
        AOR namingService = null;
        try {
            namingService = new AOR(0, InetAddress.getLocalHost(), 49000);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            NAMING_SERVICE_AOR = namingService;
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
