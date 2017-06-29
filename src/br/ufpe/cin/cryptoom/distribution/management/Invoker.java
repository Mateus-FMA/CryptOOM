package br.ufpe.cin.cryptoom.distribution.management;

import br.ufpe.cin.cryptoom.distribution.invocation.AOR;
import br.ufpe.cin.cryptoom.distribution.invocation.Base;
import br.ufpe.cin.cryptoom.distribution.management.exceptions.InvokerNotHaltedException;
import br.ufpe.cin.cryptoom.distribution.management.exceptions.InvokerNotRunningException;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class Invoker {
  private static Invoker instance;

  private Map<AOR, Base> boundServices;
  private AtomicBoolean isRunning;

  private Invoker() {
    this.boundServices = new ConcurrentHashMap<>();
    this.isRunning = new AtomicBoolean(false);
  }

  public static Invoker getInstance() {
    return Invoker.instance == null ? new Invoker() : Invoker.instance;
  }

  public void bind(Base remoteObj) throws InvokerNotRunningException {
    Objects.requireNonNull(remoteObj, "Cannot bind a null remote object.");
    if (!Invoker.instance.isRunning.get()) {
      throw new InvokerNotRunningException("The invoker hasn't been initialized yet.");
    }

    this.boundServices.put(remoteObj.getAOR(), remoteObj);
  }

  public void unbind(Base remoteObj) throws InvokerNotHaltedException {
    Objects.requireNonNull(remoteObj, "Cannot unbind a null remote object");
    if (Invoker.instance.isRunning.get()) {
      throw new InvokerNotHaltedException("Cannot unbind remote objects while this Invoker is running.");
    }

    this.boundServices.remove(remoteObj.getAOR());
  }

  public void start() throws InvokerNotHaltedException {
    if (Invoker.instance.isRunning.get()) {
      throw new InvokerNotHaltedException("Invoker is already running.");
    }

    this.isRunning.set(true);
  }

  public void stop() throws InvokerNotRunningException {
    if (!Invoker.instance.isRunning.get()) {
      throw new InvokerNotRunningException("Invoker is not currently running.");
    }

    this.isRunning.set(false);
  }
}
