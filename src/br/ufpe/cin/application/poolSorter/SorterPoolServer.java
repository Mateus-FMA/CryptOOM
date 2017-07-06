package br.ufpe.cin.application.poolSorter;

import br.ufpe.cin.application.poolSorter.middlewareSupport.SorterPoolImpl;
import br.ufpe.cin.application.poolSorter.middlewareSupport.SorterPoolProxy;
import br.ufpe.cin.cryptoom.common.NameServiceProxy;
import br.ufpe.cin.cryptoom.distribution.invocation.AOR;
import br.ufpe.cin.cryptoom.distribution.invocation.Base;
import br.ufpe.cin.cryptoom.distribution.management.Invoker;

import java.net.InetAddress;

/**
 * Created by Ricardo on 06/07/2017.
 */
public class SorterPoolServer {
    public static AOR POOL_SORTER_AOR;

    static {
        try {
            POOL_SORTER_AOR = new AOR(1, InetAddress.getLocalHost(), 50001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Creating Sorter Implementation instance");
        Base sorterImpl;
        sorterImpl = new SorterPoolImpl(POOL_SORTER_AOR);
        Invoker instance = Invoker.getInstance();
        System.out.println("Now binding in its invoker");
        instance.bindService(sorterImpl);
        instance.start();
        System.out.println("Now Sorter is ready to get requests");

        //creating proxy in Naming Service
        NameServiceProxy nsp = new NameServiceProxy(InetAddress.getLocalHost(), 40000);

        //server part, just testing
        SorterPoolProxy sorterProxy = new SorterPoolProxy(POOL_SORTER_AOR);
        System.out.println("binding sorter proxy in naming service...");
        nsp.bind("sorter_pool", sorterProxy);
        System.out.println("Proxy binded");

        //force the program waiting
        System.in.read();
    }
}
