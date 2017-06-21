package br.ufpe.cin.tests.infrastructure.serializer;

import br.ufpe.cin.cryptoom.infrastructure.serializer.AESCipher;
import br.ufpe.cin.cryptoom.infrastructure.serializer.Marshaller;
import br.ufpe.cin.tests.TestClass;

import java.util.Arrays;

/**
 * Used to test the Marshaller and the AESCipher classes.
 *
 * Created by Mateus de Freitas on 20/06/2017.
 */
public class SerializerTest {
  public static void main(String[] args) throws Exception {
    TestClass test = new TestClass(42, "Awesome test string. :D");
    System.out.println(test.toString());
    AESCipher.init();

    byte[] marshaledTest = Marshaller.marshal(test);
    System.out.println(Arrays.toString(marshaledTest));
    byte[] ciphertext = AESCipher.encryptByteArray(marshaledTest);
    System.out.println(Arrays.toString(ciphertext));
    byte[] plaintext = AESCipher.decryptByteArray(ciphertext);
    System.out.println(Arrays.toString(plaintext));
    TestClass unmarshaledTest = (TestClass) Marshaller.unmarshal(plaintext);
    System.out.println(unmarshaledTest.toString());
  }
}
