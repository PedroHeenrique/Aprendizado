package mecanicas;

import interfacesDoJogo.MecanicaDoJogo;

public class NormalGame extends MecanicaDoJogo {

  public NormalGame() {
    super();
    this.tentativas = 3;
    this.pontuacao = 0;
  }

  @Override
  public boolean jogoTerminou() {
    return (this.tentativas == 0) || (pontuacao == 100) || (! haPalavrasASeremAdivinhadas()); 
  }

  @Override
  public void resgistrarPontuacao() {
    determinarPontucaoDeAcordoComAsTentaivas(); 
  }

  @Override
  public void registrarTentativas() {
    tentativas -= 1;
  }
  
  private void determinarPontucaoDeAcordoComAsTentaivas() {
      this.pontuacao += 5; 
  }
  
  

}
