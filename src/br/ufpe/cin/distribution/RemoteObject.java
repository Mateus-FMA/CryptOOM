package br.ufpe.cin.distribution;

import br.ufpe.cin.distribution.invocation.AOR;

import java.io.Serializable;

/**
 * Created by Ricardo on 19/06/2017.
 */
public interface RemoteObject extends Serializable {
    String getId();

    AOR getAOR();
}
