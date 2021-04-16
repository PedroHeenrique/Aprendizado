package embaralhadores;

import interfacesDoJogo.Embaralhador;

public class EmbaralhadorComplexo extends Embaralhador {
  
  public EmbaralhadorComplexo() {
    super();
  }
 
  public String embaralhar() {
    StringBuilder construirPalavra = new StringBuilder(palavraASerEmbaralhada);
    construirPalavra = construirPalavra.reverse();
    String dificultar = construirPalavra.toString();
    char [] segundoEmbaralhamento = dificultar.toCharArray();
        
    segundoEmbaralhamento[0] = dificultar.charAt(1);
    segundoEmbaralhamento[1] = dificultar.charAt(0);
    segundoEmbaralhamento[2] = dificultar.charAt(3);
    segundoEmbaralhamento[3] = dificultar.charAt(2);
        
    return new String(segundoEmbaralhamento);
  } 
  
  @Override
  public String toString() {
    return "Embaralhador Complexo";
  }
}
