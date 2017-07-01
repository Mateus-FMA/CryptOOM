package br.ufpe.cin.cryptoom.common;

import br.ufpe.cin.cryptoom.distribution.invocation.AOR;
import br.ufpe.cin.cryptoom.distribution.invocation.Base;
import br.ufpe.cin.cryptoom.distribution.invocation.Proxy;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Implements the local name service. Client and server sides of a distributed system must call
 * these functions from a Proxy.
 *
 * Created by Mateus de Freitas on 01/07/2017.
 */
public class ObjectNameService implements Registry {
  private Map<String, Proxy> registry;

  public ObjectNameService() {
    this.registry = new ConcurrentHashMap<>();
  }

  @Override
  public void bind(Proxy remoteObjProxy) {
    Objects.requireNonNull(remoteObjProxy, "Cannot bind a null Proxy.");
    this.registry.put(remoteObjProxy.getIdentifier(), remoteObjProxy);
  }

  @Override
  public void rebind(String identifier, Proxy remoteObjProxy) {
    Objects.requireNonNull(remoteObjProxy, "Cannot rebind a null Proxy.");
    this.registry.remove(identifier);
    this.registry.put(remoteObjProxy.getIdentifier(), remoteObjProxy);
  }

  @Override
  public void unbind(String identifier) {
    this.registry.remove(identifier);
  }

  @Override
  public Proxy lookup(String identifier) {
    return this.registry.get(identifier);
  }

  @Override
  public ArrayList<String> listServices() {
    return new ArrayList<>(this.registry.keySet());
  }
}
