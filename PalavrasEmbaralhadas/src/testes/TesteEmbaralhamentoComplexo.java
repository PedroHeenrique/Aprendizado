package testes;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import embaralhadores.EmbaralhadorComplexo;
import embaralhadores.EmbaralhadorSimples;
import interfacesDoJogo.Embaralhador;

class TesteEmbaralhamentoComplexo {

  @Test
  void testEmbaralhamentoComplexo() {
   Embaralhador embaralhamentoComplexo = new EmbaralhadorComplexo();
   String palavraASerEmbaralhada = embaralhamentoComplexo.getPalavra();
   String palavraEmbaralhada = embaralhamentoComplexo.embaralhar();
   assertEquals(false,palavraASerEmbaralhada.equals(palavraEmbaralhada));
   
  }

}
