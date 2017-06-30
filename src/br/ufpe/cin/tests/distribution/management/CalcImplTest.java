package br.ufpe.cin.tests.distribution.management;


import br.ufpe.cin.cryptoom.distribution.invocation.AOR;
import br.ufpe.cin.cryptoom.distribution.invocation.Base;
import br.ufpe.cin.cryptoom.distribution.requesting.Invocation;
import br.ufpe.cin.cryptoom.distribution.requesting.Termination;
import javafx.util.Pair;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Guilherme on 20/06/2017.
 */
public class CalcImplTest extends Base {
    public CalcImplTest(AOR aor) {
        super(aor);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws UnknownHostException {
        CalcImplTest c = new CalcImplTest(new AOR(1, InetAddress.getLocalHost(), 20));
        Invocation inv = new Invocation("add", new Pair[]{new Pair(1, Integer.class), new Pair(7, Integer.class)}, new AOR(2, InetAddress.getLocalHost(), 4000));
        Termination t = c.processAndRunRemoteInvocation(inv);
        System.out.println(t.getResult());
    }

    public Integer add(Integer a, Integer b) {
        return a + b;
    }

    @Override
    protected String getIdentifier() {
        return "Calc";
    }
}
