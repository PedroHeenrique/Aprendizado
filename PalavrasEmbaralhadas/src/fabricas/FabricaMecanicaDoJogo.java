package fabricas;

import interfacesDoJogo.MecanicaDoJogo;
import mecanicas.HardGame;
import mecanicas.NormalGame;

/*RETORNA A MECANICADOJOGO QUE DEVE SER UTILIZADA*/
public class FabricaMecanicaDoJogo {

  private FabricaMecanicaDoJogo() {}
    
    public static MecanicaDoJogo getMecanica(int dificuldade) {
      if(dificuldade == 1) 
        return new NormalGame();
      if(dificuldade == 2)
        return new HardGame();
    return null; 
  }

}
