package mecanicas;

import interfacesDoJogo.MecanicaDoJogo;

public class HardGame extends MecanicaDoJogo {

  public HardGame() {
    super();
    this.tentativas = 1;
    this.pontuacao = 0;
  }

  @Override
  public boolean jogoTerminou() {
    return (this.tentativas == 0) || (pontuacao == 100) || (!haPalavrasASeremAdivinhadas());
  }

  @Override
  public void resgistrarPontuacao() {
    this.pontuacao += 5;
  }

  @Override
  public void registrarTentativas() {
    this.tentativas -= 1;

  }

}
