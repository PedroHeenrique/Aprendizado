package design;

public class PizzariaSP extends Pizzaria {

  public PizzariaSP(PizzaFactory fabrica) {
   super(fabrica);
   
  }

  @Override
  public Pizza criar(String tipo) {
    return new Pizza();
  }

}
