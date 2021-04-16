package org.coursera;

public class PrincipalCorrida {

  public static void main(String[] args) {
  Corrida corridaDaAmizade = new Corrida(2000);
  
  corridaDaAmizade.adicionaCarro(new CarroSoma("Porche",10,150));
  corridaDaAmizade.adicionaCarro(new CarroSoma("Ferrari",9,140));
  corridaDaAmizade.adicionaCarro(new CarroMulti("McLaren",1.7,100));
  corridaDaAmizade.adicionaCarro(new CarroMulti("Mercedes",1.4,150));

  corridaDaAmizade.umDoisTresEJa();
  }

}
