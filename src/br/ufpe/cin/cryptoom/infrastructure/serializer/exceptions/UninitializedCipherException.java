package br.ufpe.cin.cryptoom.infrastructure.serializer.exceptions;

/**
 * Exception thrown when AESCipher was not properly initialized.
 *
 * Created by Mateus de Freitas on 20/06/2017.
 */
public class UninitializedCipherException extends Exception {

  public UninitializedCipherException(String message) {
    super(message);
  }
}
