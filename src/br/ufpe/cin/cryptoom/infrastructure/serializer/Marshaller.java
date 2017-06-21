package br.ufpe.cin.cryptoom.infrastructure.serializer;

import java.io.*;

/**
 * This class implements the serialization of messages between components of a distributed system
 * using this middleware.
 *
 * Created by Mateus de Freitas on 17/06/2017.
 */
public final class Marshaller {
  // Since we don't want instances of this class and it is final (cannot declare it as abstract),
  // we define a private constructor to prevent instantiation.
  private Marshaller() {

  }

  public static byte[] marshal(Object toMarshal) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(toMarshal);

    return baos.toByteArray();
  }

  public static Object unmarshal(byte[] toUnmarshal) throws IOException, ClassNotFoundException {
     return new ObjectInputStream(new ByteArrayInputStream(toUnmarshal)).readObject();
  }
}
