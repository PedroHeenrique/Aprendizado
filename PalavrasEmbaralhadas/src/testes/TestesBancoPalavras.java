package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import banco.BancoDePalavras;

class TestesBancoPalavras {
 
   @BeforeEach
  public void limpaDadosAntesDeCadaTeste() {
    BancoDePalavras.apagarPalavraEDicaEscolhida();
  }
  
   @Test
  public void testaAleatoriedade() {
     String primeiraPalavraRetornada = BancoDePalavras.obterPalavra();
     BancoDePalavras.apagarPalavraEDicaEscolhida();
     String segundaPalavraRetornada = BancoDePalavras.obterPalavra();
     assertEquals(false, primeiraPalavraRetornada.equals(segundaPalavraRetornada));
  }
  
  @Test
  public void testaVerificaDicaCorreta() {
    String palavra = BancoDePalavras.obterPalavra();
    String dica = BancoDePalavras.obterDica();
   
  }
  
  @Test
  public void verificaDicaParaPalavrasQueNaoForamObtidas() {
    assertEquals(" ", BancoDePalavras.obterDica());
  }
   
  
  @Test
  public void testaRemocaoDaPalavraDoBanco() {
  BancoDePalavras.obterPalavra();
  String palavraSorteada = BancoDePalavras.getPalavraAleatoria();
  String dicaSorteada = BancoDePalavras.getDicaPalavraAleatoria();
  
  BancoDePalavras.removerPalavraDoBanco();
  String palavraASerBuscada = palavraSorteada+"-"+dicaSorteada;
  assertEquals(false, BancoDePalavras.getListaDePalavras().contains(palavraASerBuscada));
}
  

}
