package design;

public abstract  class Pizzaria {
  
  PizzaFactory fabrica = new PizzaFactory();
  
  public Pizzaria (PizzaFactory fabrica) {
    this.fabrica = fabrica;
  }
  
  Pizza pizza;
  public void escolher(String tipo) {
    pizza = fabrica.criar(tipo);
    pizza.preparar();
    pizza.assar();
  }
  
  public abstract Pizza criar(String tipo);

}
