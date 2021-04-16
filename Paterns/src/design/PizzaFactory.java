package design;

public class PizzaFactory {
       
  public Pizza criar(String tipo) {
    
    if ("Queijo".equalsIgnoreCase(tipo)) 
        return new PizzaQueijo();
    
    if("Presunto".equalsIgnoreCase(tipo)) 
      return new PizzaPresunto();
    
    return new PizzaQueijo();
    
    
  }

}
