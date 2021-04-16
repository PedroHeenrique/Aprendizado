package interfacesDoJogo;

import banco.BancoDePalavras;

/*INTERFACE QUE REPRESENTA CLASSES REPONSÁVEIS POR RECEBER UMA PALAVRA E
RETORNAR ELA EMBARALHADA. PELO MENOS DUAS IMPLEMENTAÇÕES DEVERÃO SER FEITAS.*/

public abstract class Embaralhador {
  protected String palavraASerEmbaralhada;
  protected String dicaDaPalavraEmbaralhada;

  public Embaralhador() {
    obterPalavraASerEmbaralhada();
    obterDicaDaPalavraEmbaralhada();
  }

  public abstract String embaralhar();

  public String getPalavra() {
    return palavraASerEmbaralhada;
  }
  
  public int getPalavrasRestantes() {
    return BancoDePalavras.palavrasRestantes();
  }

  public String getDica() {
    return dicaDaPalavraEmbaralhada;
  }

  public boolean obterProximaPalavra() {
    if (BancoDePalavras.existemPalavrasASeremSorteadas()) {
        obterPalavraASerEmbaralhada();
        obterDicaDaPalavraEmbaralhada();
        return true;
    } 
    return false;
  }

  public void removerPalavraSorteadaDaListaDepalavras() {
    BancoDePalavras.removerPalavraDoBanco();
  }

  private String obterPalavraASerEmbaralhada() {
    palavraASerEmbaralhada = BancoDePalavras.obterPalavra();
    return palavraASerEmbaralhada;
  }

  private String obterDicaDaPalavraEmbaralhada() {
    dicaDaPalavraEmbaralhada = BancoDePalavras.obterDica();
    return dicaDaPalavraEmbaralhada;
  }

}
