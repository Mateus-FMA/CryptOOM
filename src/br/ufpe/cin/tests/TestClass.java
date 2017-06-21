package br.ufpe.cin.tests;

import java.io.Serializable;

/**
 * Class used for testing the middleware requirements.
 *
 * Created by Mateus de Freitas on 20/06/2017.
 */
public class TestClass implements Serializable {
  private int id;
  private String description;

  public TestClass(int id, String description) {
    this.id = id;
    this.description = description;
  }

  public String toString() {
    return "ID: " + this.id + "\nDescription: " + this.description;
  }
}
