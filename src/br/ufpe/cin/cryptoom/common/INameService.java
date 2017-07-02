package br.ufpe.cin.cryptoom.common;

import br.ufpe.cin.cryptoom.distribution.invocation.Proxy;

import java.util.ArrayList;

public interface INameService {
    void bind(String identifier, Proxy proxy) throws Exception;

    void unbind(String identifier) throws Exception;

    Proxy lookup(String identifier) throws Exception;
}
