package fabricas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import embaralhadores.EmbaralhadorComplexo;
import embaralhadores.EmbaralhadorSimples;
import interfacesDoJogo.Embaralhador;

/*POSSUI UM MÉTODO QUE RETORNA UM EMBARALHADOR
ALEATÓRIAMENTE.*/

public class FabricaEmbaralhador {
  private static int numeroDoEmBaralhadorSorteadoAnteriormente;

  private FabricaEmbaralhador() {}

  public static Embaralhador criarEmbaralhador() {
    Embaralhador embaralhador = null;
    switch (sortearNumeroDoEmbaralhador()) {
      case 0:
        embaralhador = new EmbaralhadorSimples();
        break;
      case 1:
        embaralhador = new EmbaralhadorComplexo();
        break;
      default:
        System.out.println("EmbaralhadornaoEncontrato ");
    }

    return embaralhador;
  }

  private static int sortearNumeroDoEmbaralhador() {
    List<Integer> numeroDosEmbaralhadores = Arrays.asList(0, 1);
    Collections.shuffle(numeroDosEmbaralhadores);
    if (numeroDoEmBaralhadorSorteadoAnteriormente == numeroDosEmbaralhadores.get(0))
      sortearNumeroDoEmbaralhador();
    return numeroDosEmbaralhadores.get(0);
  }

}
