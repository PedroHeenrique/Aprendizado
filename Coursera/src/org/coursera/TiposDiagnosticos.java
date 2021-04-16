package org.coursera;

public enum TiposDiagnosticos {

  BAIXO_PESO_MUITO_GRAVE("Baixo peso muito grave"), 
  BAIXO_PESO_GRAVE("Baixo peso grave"), 
  BAIXO_PESO("Baixo peso"),
  PESO_NORMAL("Peso Normal"), 
  SOBREPESO("Sobrepeso"),
  OBESIDADE_GRAU_I("Obesidade grau I"),
  OBESIDADE_GRAU_II("Obesidade grau II"), 
  OBESIDADE_GRAU_III("Obesidade grau III(Obesidade mórbida)");

  private String descricaoDoIndiceDeMassaCorporal;

  TiposDiagnosticos(String descricao) {
    descricaoDoIndiceDeMassaCorporal = descricao;

  }

  public static final String realizarDiagnostico(double indiceDeMassaCorporal) {
    
    if(indiceDeMassaCorporal < 16)
      return BAIXO_PESO_MUITO_GRAVE.obterDescricadoDoIndiceDeMassaCorporal();
    
    if(indiceDeMassaCorporal >= 16 && indiceDeMassaCorporal < 17)
      return BAIXO_PESO_GRAVE.obterDescricadoDoIndiceDeMassaCorporal();
    
    if (indiceDeMassaCorporal >= 17 && indiceDeMassaCorporal < 18.50)
      return BAIXO_PESO.obterDescricadoDoIndiceDeMassaCorporal();
    
    if(indiceDeMassaCorporal >= 18.50 && indiceDeMassaCorporal < 25)
      return PESO_NORMAL.obterDescricadoDoIndiceDeMassaCorporal();
    
    if(indiceDeMassaCorporal >= 25 && indiceDeMassaCorporal < 30)
      return SOBREPESO.obterDescricadoDoIndiceDeMassaCorporal();
    
    if(indiceDeMassaCorporal >= 30 && indiceDeMassaCorporal < 35)
      return OBESIDADE_GRAU_I.obterDescricadoDoIndiceDeMassaCorporal();
    
    if(indiceDeMassaCorporal >= 35 && indiceDeMassaCorporal < 40)
      return OBESIDADE_GRAU_II.obterDescricadoDoIndiceDeMassaCorporal();
    
    if(indiceDeMassaCorporal >= 40)
      return OBESIDADE_GRAU_III.obterDescricadoDoIndiceDeMassaCorporal();
    
   return "";
  }

  private final String obterDescricadoDoIndiceDeMassaCorporal() {
    return this.descricaoDoIndiceDeMassaCorporal;
  }

}
