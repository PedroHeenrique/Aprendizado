package org.coursera;

public  abstract class CarroDeCorrida {


  protected int velocidade;
  protected int velocidadeMaxima;
  protected String nome;

  public abstract void acelerar();
  public CarroDeCorrida(String nome, int velocidadeMaxima) {
    this.nome = nome;
    this.velocidadeMaxima = velocidadeMaxima;
    this.velocidade = 0;
  }
  
  public void frear() {
    velocidade /= 2;
  }

  public int getVelocidade() {
    
    return velocidade;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

}
