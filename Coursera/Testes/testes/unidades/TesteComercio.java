package testes.unidades;

import static org.junit.Assert.*;

import org.coursera.Comercio;
import org.junit.Test;

public class TesteComercio {

  @Test
  public void test() {
    Comercio comercio = new Comercio(500);
    assertEquals(1,comercio.getNumeroParcelas());
    
    assertEquals(500, comercio.getValorTotal());
    assertEquals(500, comercio.getValorParcela());
    
   
  }
  @Test
  public void testeCompraPrazo() {
    
    Comercio comercio = new Comercio(2,250);
    
    assertEquals(2,comercio.getNumeroParcelas());
    assertEquals(500,comercio.getValorTotal());
    assertEquals(250,comercio.getValorParcela());
  }



}
