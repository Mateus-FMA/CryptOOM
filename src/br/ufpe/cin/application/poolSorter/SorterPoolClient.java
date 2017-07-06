package br.ufpe.cin.application.poolSorter;

import br.ufpe.cin.application.poolSorter.middlewareSupport.SorterPoolProxy;
import br.ufpe.cin.cryptoom.common.NameServiceProxy;
import br.ufpe.cin.cryptoom.distribution.invocation.Proxy;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ricardo on 06/07/2017.
 */
public class SorterPoolClient {
    public static void main(String[] args) throws Exception {
        NameServiceProxy nsp = new NameServiceProxy(InetAddress.getLocalHost(), 40000);

        Proxy sorterProxy = nsp.lookup("sorter_pool");
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> sortedList = new ArrayList<Integer>();
        Random r = new Random();
        while(true) {
            list.clear();
            sortedList.clear();
            for(int i = 0; i < 10; i++) {
                list.add(r.nextInt(10));
            }
            sortedList = ((SorterPoolProxy)sorterProxy).sort(list);

            for(int i = 0; i < sortedList.size(); i++) {
                System.out.print(sortedList.get(i) + " ");
            }
            System.out.println("");
        }
    }
}
