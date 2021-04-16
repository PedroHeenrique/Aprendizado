package factory.method;

public class MainTeste {

  public static void main(String[] args) {
    
    Poligono  poligono = FabricaDePoligonos.criarPoligono(3);
    System.out.println(poligono.getDescricao());
    
    
    poligono = FabricaDePoligonos.criarPoligono(4);
    System.out.println(poligono.getDescricao());
    
    
    poligono = FabricaDePoligonos.criarPoligono(5);
    System.out.println(poligono.getDescricao());
    
    
  }

}
