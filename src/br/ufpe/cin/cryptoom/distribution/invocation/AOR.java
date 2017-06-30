package br.ufpe.cin.cryptoom.distribution.invocation;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Objects;

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

    @Override
    public boolean equals(Object aor){
        if(aor == null || getClass() != aor.getClass()) return false;
        AOR compare = (AOR) aor;
        return this.id == compare.getId() && compare.getPort() == this.port && this.address.equals(compare.getAddress());
    }

    @Override
    public int hashCode() {
        return  Objects.hash(id,address.hashCode(), port);
    }

}
