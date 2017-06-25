package br.ufpe.cin.cryptoom.distribution.requesting;

import java.io.Serializable;

public class Message implements Serializable{

    private Object body;

    public Message(Object body) {
        this.body = body;
    }

    public Object getBody() {
        return body;
    }
}
