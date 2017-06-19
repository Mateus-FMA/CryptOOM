package br.ufpe.cin.distribution.requesting;

import br.ufpe.cin.distribution.invocation.AOR;
import javafx.util.Pair;

import java.io.Serializable;

public class Invocation implements Serializable{

    private String methodName;
    private Pair<Object, Class>[] arguments;
    private AOR aor;

    public Invocation(String methodName, Pair<Object, Class>[] arguments, AOR aor) {
        this.methodName = methodName;
        this.arguments = arguments;
        this.aor = aor;
    }

    public String getMethodName() {
        return methodName;
    }

    public Pair<Object, Class>[] getArguments() {
        return arguments;
    }

    public AOR getAOR() {
        return aor;
    }
}
