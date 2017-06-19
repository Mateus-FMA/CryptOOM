package br.ufpe.cin.distribution.invocation;

public abstract class Proxy {
    private AOR aor;

    public Proxy(AOR aor) {
        this.aor = aor;
    }

    abstract String getIdentifier();
    abstract  AOR getAOR();
}
