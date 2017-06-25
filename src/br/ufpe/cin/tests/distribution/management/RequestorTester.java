package br.ufpe.cin.tests.distribution.management;

import br.ufpe.cin.application.CalculadoraProxy;
import br.ufpe.cin.cryptoom.distribution.invocation.AOR;
import br.ufpe.cin.cryptoom.distribution.invocation.Proxy;
import br.ufpe.cin.cryptoom.infrastructure.serializer.AESCipher;

import java.net.InetAddress;

/**
 * Created by Ricardo on 25/06/2017.
 */
public class RequestorTester {

    public static void main(String[] args) throws Exception {
        Proxy calculadora = new CalculadoraProxy(new AOR(123, InetAddress.getLocalHost(), 50000));
        ((CalculadoraProxy) calculadora).add(30, 40);
    }

}
