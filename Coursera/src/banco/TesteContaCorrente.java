package banco;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TesteContaCorrente {
  
  ContaCorrente conta;
 
  @Before
  public void inicializaConta() {
    conta = new ContaCorrente();
    conta.depositar(200);
  }

  @Test
  public void testDeposito() {
    assertEquals(200, conta.saldo);
  }

  @Test
  public void testSaque() { 
    int valorSacado = conta.sacar(50);
    assertEquals(conta.saldo, 150);
    assertEquals(valorSacado, 50);

  }

  @Test
  public void testSaqueMaiorQueSaldo() {
    int valorSaque = conta.sacar(250);
    assertEquals(conta.saldo,200);
    assertEquals(valorSaque,0);
  }
  
  
  
}
