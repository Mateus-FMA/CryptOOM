package br.ufpe.cin.cryptoom.infrastructure.serializer;

import br.ufpe.cin.cryptoom.infrastructure.serializer.exceptions.UninitializedCipherException;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
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
public final class AESCipher implements Serializable {
  // TODO (Mateus): check for safer implementation with the previous settings.
  private static final String CIPHER_SETTINGS = "AES";
  private static SecretKey key = new SecretKeySpec("AwesomeSecretKey".getBytes(), "AES");

  // Hide default constructor.
  private AESCipher() {

  }

  public static byte[] encryptByteArray(byte[] plaintext) throws GeneralSecurityException {
    Cipher cipher = Cipher.getInstance(AESCipher.CIPHER_SETTINGS);
    cipher.init(Cipher.ENCRYPT_MODE, AESCipher.key);
    return cipher.doFinal(plaintext);
  }

  public static byte[] decryptByteArray(byte[] ciphertext) throws GeneralSecurityException {
    Cipher cipher = Cipher.getInstance(AESCipher.CIPHER_SETTINGS);
    cipher.init(Cipher.DECRYPT_MODE, key);
    return cipher.doFinal(ciphertext);
  }

//  private static final int KEY_SIZE = 128;
//  private static final String CIPHER_SETTINGS = "AES/CBC/PKCS5Padding";
//
//  private SecureRandom rng;
//  private IvParameterSpec iv;
//  private SecretKey key;

//  public AESCipher() throws NoSuchAlgorithmException {
//    rng = new SecureRandom();
//
//    // Generate initialization vector.
//    byte[] byteIV = new byte[AESCipher.KEY_SIZE >> 3];
//    rng.nextBytes(byteIV);
//    iv = new IvParameterSpec(byteIV);
//
//    // Generate key.
//    KeyGenerator keyGen = KeyGenerator.getInstance("AES");
//    keyGen.init(AESCipher.KEY_SIZE);
//    key = keyGen.generateKey();
//  }
//
//  public byte[] encryptByteArray(byte[] plaintext) throws GeneralSecurityException,
//          UninitializedCipherException {
//    if (key == null || iv == null)
//      throw new UninitializedCipherException("Need to generate key and initialization vector.");
//
//    Cipher cipher = Cipher.getInstance(AESCipher.CIPHER_SETTINGS);
//    cipher.init(Cipher.ENCRYPT_MODE, key, iv, rng);
//    return cipher.doFinal(plaintext);
//  }
//
//  public byte[] decryptByteArray(byte[] ciphertext) throws GeneralSecurityException,
//          UninitializedCipherException {
//    if (key == null || iv == null)
//      throw new UninitializedCipherException("Need to generate key and initialization vector.");
//
//    Cipher cipher = Cipher.getInstance(AESCipher.CIPHER_SETTINGS);
//    cipher.init(Cipher.DECRYPT_MODE, key, iv);
//    return cipher.doFinal(ciphertext);
//  }
}
