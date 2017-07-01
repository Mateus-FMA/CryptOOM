package br.ufpe.cin.cryptoom.distribution.invocation;

import br.ufpe.cin.cryptoom.distribution.requesting.Termination;
import br.ufpe.cin.cryptoom.distribution.requesting.Invocation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Base {
    private AOR aor;

    public Base(AOR aor) {
        this.aor = aor;
    }

    public Termination processAndRunRemoteInvocation(Invocation invocation) {
        Object[] arguments = new Object[invocation.getArguments().length];
        Class[] argumentsTypes = new Class[invocation.getArguments().length];

        for(int i = 0 ; i < arguments.length; i++) {
            arguments[i] = invocation.getArguments()[i].getKey();
            argumentsTypes[i] = invocation.getArguments()[i].getValue();
        }

        try {
            Method method = getClass().getMethod(invocation.getMethodName(),argumentsTypes);
            return new Termination(method.invoke(this, arguments));
        //TODO change exception processing
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Method with name and signature provided does not exist");
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException("Illegal access management or TargetException");
        }

    }

    public AOR getAOR() {
        return aor;
    }

    public abstract String getIdentifier();
}
