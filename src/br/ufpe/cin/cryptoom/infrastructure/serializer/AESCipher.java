package br.ufpe.cin.cryptoom.infrastructure.serializer;

import br.ufpe.cin.cryptoom.infrastructure.serializer.exceptions.UninitializedCipherException;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.security.*;

/**
 * This class wraps the AES algorithm implementation on javax.crypto and uses it to encrypt and
 * decrypt serialized messages between the distributed system's components. It uses cipher block
 * chaining (CBC) mode of operation and PKCS #7 padding mechanism (legacy declaration on
 * javax.crypto is PKCS #5, even though it cannot be applied to AES algorithm - see RFC 2315 and
 * RFC 2898 for more details).
 *
 * Created by Mateus de Freitas on 19/06/2017.
 */
public final class AESCipher {
  private static final int KEY_SIZE = 128;
  private static final String CIPHER_SETTINGS = "AES/CBC/PKCS5Padding";

  private static SecureRandom rng = new SecureRandom();
  private static IvParameterSpec iv = null;
  private static SecretKey key = null;

  // Defining constructor as private to prevent instantiation.
  private AESCipher() {

  }

  public static void init() throws NoSuchAlgorithmException {
    // Generate initialization vector.
    byte[] byteIV = new byte[AESCipher.KEY_SIZE >> 3];
    rng.nextBytes(byteIV);
    iv = new IvParameterSpec(byteIV);

    // Generate key.
    KeyGenerator keyGen = KeyGenerator.getInstance("AES");
    keyGen.init(AESCipher.KEY_SIZE);
    key = keyGen.generateKey();
  }

  public static byte[] encryptByteArray(byte[] plaintext) throws GeneralSecurityException,
          UninitializedCipherException {
    if (AESCipher.key == null || AESCipher.iv == null)
      throw new UninitializedCipherException("Need to generate key and initialization vector.");

    Cipher cipher = Cipher.getInstance(AESCipher.CIPHER_SETTINGS);
    cipher.init(Cipher.ENCRYPT_MODE, AESCipher.key, AESCipher.iv, AESCipher.rng);
    return cipher.doFinal(plaintext);
  }

  public static byte[] decryptByteArray(byte[] ciphertext) throws GeneralSecurityException,
          UninitializedCipherException {
    if (AESCipher.key == null || AESCipher.iv == null)
      throw new UninitializedCipherException("Need to generate key and initialization vector.");

    Cipher cipher = Cipher.getInstance(AESCipher.CIPHER_SETTINGS);
    cipher.init(Cipher.DECRYPT_MODE, AESCipher.key, AESCipher.iv);
    return cipher.doFinal(ciphertext);
  }
}
