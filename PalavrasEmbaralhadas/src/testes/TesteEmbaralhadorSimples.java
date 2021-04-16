package testes;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import embaralhadores.EmbaralhadorSimples;
import interfacesDoJogo.Embaralhador;

class TesteEmbaralhadorSimples {

  @Test
  void testaEmbaralhamentoSimples() {
    Embaralhador embaralhamentoSimples = new EmbaralhadorSimples();
    String palavraASerEmbaralhada = embaralhamentoSimples.getPalavra();
    String palavraEmbaralhada = embaralhamentoSimples.embaralhar();
    assertEquals(false,palavraASerEmbaralhada.equals(palavraEmbaralhada));
  }
}
