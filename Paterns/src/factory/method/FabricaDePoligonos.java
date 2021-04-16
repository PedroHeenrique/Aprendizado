package factory.method;

public class FabricaDePoligonos {

  public static Poligono criarPoligono(int numerOfSides) {
    if (numerOfSides == 3) {

      return new Triangulo();

    } else if (numerOfSides == 4) {
      return new Quadrado();
    } else if(numerOfSides == 5 ) {
      return new Pentagono();
    }

    return null;
  }

}
