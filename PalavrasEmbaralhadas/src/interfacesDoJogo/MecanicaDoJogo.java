package interfacesDoJogo;

import fabricas.FabricaEmbaralhador;

/*INTERFACE QUE REPRESENTA O ANDAMENTO E A LÓGICA DO JOGO. É RESPONSÁVEL
POR DITAR O ANDAMENTO DO JOGO. ELA QUE VAI DIZER SE O JOGO ACABOU OU NÃO, SE O USUÁRIO ACERTOU A
PALAVRA OU NÃO, SE O USUÁRIO PODE TENTAR ACERTAR A PALAVRA NOVAMENTE E QUAL FOI A PONTUAÇÃO FINAL
DO JOGADOR. PELO MENOS DUAS IMPLEMENTAÇÕES DESSA INTERFACE DEVEM SER CRIADAS.*/

public abstract class MecanicaDoJogo {

  protected int tentativas;
  protected int pontuacao;
  private boolean haPalavrasASeremAdivinhadas;
  private String palavraEmbaralhada;
  private Embaralhador embaralhador;

  public abstract boolean jogoTerminou();

  public abstract void resgistrarPontuacao();

  public abstract void registrarTentativas();

  public MecanicaDoJogo() {
    embaralhador = FabricaEmbaralhador.criarEmbaralhador();
    palavraEmbaralhada = embaralhador.embaralhar();
  }

  public String getpalavraEmbaralhada() {
    return palavraEmbaralhada;
  }

  public String adivinhar(String palavra) {
    return registrarAndamentoDoJogo(acertou(palavra));
  }

  private String registrarAndamentoDoJogo(boolean palavraInformadaCorretamente) {
    String palavraCorreta = getpalavraASerAdivinhada();
    if (palavraInformadaCorretamente) {
      resgistrarPontuacao();
      selecionarProximaPalavra();
      return "ACERTOU = " + palavraCorreta;
    }
    registrarTentativas();
    selecionarProximaPalavra();
    return "Errou a palavra correta e : " + palavraCorreta;
  }

  private boolean acertou(String palavra) {
    return palavra.stripLeading().equalsIgnoreCase(getpalavraASerAdivinhada());
  }

  private void selecionarProximaPalavra() {
    embaralhador.removerPalavraSorteadaDaListaDepalavras();
    haPalavrasASeremAdivinhadas = temProximaPalavra();
  }

  private boolean temProximaPalavra() {
    if (embaralhador.obterProximaPalavra()) {
      embaralharNovaPalavra();
      getpalavraASerAdivinhada();
      getdicaDaPalavraASerAdivinhada();
      return true;
    }
    return false;
  }

  private void embaralharNovaPalavra() {
    palavraEmbaralhada = embaralhador.embaralhar();
  }

  private String getpalavraASerAdivinhada() {
    return embaralhador.palavraASerEmbaralhada;
  }

  public String getdicaDaPalavraASerAdivinhada() {
    return embaralhador.dicaDaPalavraEmbaralhada;
  }

  public boolean haPalavrasASeremAdivinhadas() {
    return haPalavrasASeremAdivinhadas;
  }

  public int getPontucao() {
    return pontuacao;
  }

  public int palavrasRestantesASeremAdivinhadas() {
    return embaralhador.getPalavrasRestantes();
  }

  public int getTentativas() {
    return tentativas;
  }

}
