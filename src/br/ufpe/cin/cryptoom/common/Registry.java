package br.ufpe.cin.cryptoom.common;

import br.ufpe.cin.cryptoom.distribution.invocation.Proxy;

import java.util.ArrayList;

public interface Registry {
  void bind(Proxy remoteObjProxy);
  void rebind(String identifier, Proxy remoteObjProxy);
  void unbind(String identifier);
  Proxy lookup(String identifier);
  ArrayList<String> listServices();
}
