package br.ufpe.cin.distribution.invocation;

import java.io.Serializable;
import java.net.InetAddress;

public class AOR implements Serializable {

    private int id;
    private InetAddress address;
    private int port;

    public AOR(int id, InetAddress address, int port) {
        this.id = id;
        this.address = address;
        this.port = port;
    }

    public int getId(){
        return this.id;
    }

    public InetAddress getAddress(){
        return this.address;
    }

    public int getPort(){
        return this.port;
    }

}
