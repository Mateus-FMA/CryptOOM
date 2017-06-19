package br.ufpe.cin.distribution.requesting;

import java.io.Serializable;

public class Termination implements Serializable {

    private Object result;

    public Termination(Object result) {
        this.result = result;
    }

    public Object getResult() {
        return result;
    }
}
