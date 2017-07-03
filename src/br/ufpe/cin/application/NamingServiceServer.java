package br.ufpe.cin.application;

import br.ufpe.cin.cryptoom.common.NameService;
import br.ufpe.cin.cryptoom.distribution.invocation.AOR;
import br.ufpe.cin.cryptoom.distribution.invocation.Base;
import br.ufpe.cin.cryptoom.distribution.management.Invoker;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by Guilherme on 03/07/2017.
 */
public class NamingServiceServer {
    static AOR NAMING_SERVICE_AOR;

    static {
        try {
            NAMING_SERVICE_AOR = new AOR(0, InetAddress.getLocalHost(), 40000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Creating the naming service Implementation...");
        Base nameServiceImpl = new NameService(NAMING_SERVICE_AOR);
        Invoker instance = Invoker.getInstance();
        System.out.println("Now biding in its invoker");
        instance.bindService(nameServiceImpl);
        System.out.println("Intializing name service...");
        instance.start();
        System.out.println("Name service is running");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
