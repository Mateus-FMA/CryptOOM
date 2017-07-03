package br.ufpe.cin.cryptoom.common;

import br.ufpe.cin.cryptoom.distribution.invocation.AOR;
import br.ufpe.cin.cryptoom.distribution.invocation.Base;
import br.ufpe.cin.cryptoom.distribution.invocation.Proxy;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Implements the local name service. CalculatorClient and server sides of a distributed system must call
 * these functions from a Proxy.
 *
 * Created by Mateus de Freitas on 01/07/2017.
 */
public class NameService extends Base implements INameService {
  private Map<String, Proxy> registry;

  public NameService(AOR aor) {
    super(aor);
    this.registry = new ConcurrentHashMap<>();
  }

  @Override
  public String getIdentifier() {
    return "Name Service Implementation";
  }

  @Override
  public void bind(String identifier, Proxy proxy) {
    this.registry.put(identifier, proxy);
  }

  @Override
  public void unbind(String identifier) {
    this.registry.remove(identifier);
  }

  @Override
  public Proxy lookup(String identifier) {
    return this.registry.get(identifier);
  }

}
