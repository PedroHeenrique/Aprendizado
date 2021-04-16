package embaralhadores;

import interfacesDoJogo.Embaralhador;
import banco.BancoDePalavras;

public class EmbaralhadorSimples extends Embaralhador {
  
  public EmbaralhadorSimples() {
    super();
  }
  
  @Override
  public String embaralhar() {
    char [] palavraEmbaralhada  = palavraASerEmbaralhada.toCharArray();
    palavraEmbaralhada[0] = palavraASerEmbaralhada.charAt(1);
    palavraEmbaralhada[1] = palavraASerEmbaralhada.charAt(0);
    return new String (palavraEmbaralhada);
  }
  
  @Override
  public String toString() {
    return "Embaralhador Simples";
  }
  

}
