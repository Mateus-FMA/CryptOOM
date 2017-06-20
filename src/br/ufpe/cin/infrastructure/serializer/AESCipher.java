package br.ufpe.cin.infrastructure.serializer;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

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
  private static SecretKey key = null;

  // Defining constructor as private to prevent instantiation.
  private AESCipher() {

  }

  public static void init() throws NoSuchAlgorithmException {
    KeyGenerator keyGen = KeyGenerator.getInstance("AES");
    keyGen.init(AESCipher.KEY_SIZE);
    key = keyGen.generateKey();
  }

  public static byte[] encryptByteArray(byte[] plaintext) throws NoSuchPaddingException,
          NoSuchAlgorithmException, InvalidKeyException, BadPaddingException,
          IllegalBlockSizeException {
    if (AESCipher.key == null) {
      // TODO: throw exception here.
      return null;
    }

    Cipher cipher = Cipher.getInstance(AESCipher.CIPHER_SETTINGS);
    cipher.init(Cipher.ENCRYPT_MODE, AESCipher.key);
    return cipher.doFinal(plaintext);
  }

  public static byte[] decryptByteArray(byte[] ciphertext) throws NoSuchPaddingException,
          NoSuchAlgorithmException, InvalidKeyException, BadPaddingException,
          IllegalBlockSizeException {
    if (AESCipher.key == null) {
      // TODO: throw exception here.
      return null;
    }

    Cipher cipher = Cipher.getInstance(AESCipher.CIPHER_SETTINGS);
    cipher.init(Cipher.DECRYPT_MODE, AESCipher.key);
    return cipher.doFinal(ciphertext);
  }
}
