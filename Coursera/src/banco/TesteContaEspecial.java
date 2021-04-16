package banco;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
/*PODEMOS FAZER A HERANCA DE OUTRA CLASSE DE TESTES, O TESTE DEFINIDOS 
 * NA SUPER CLASSE DE TESTE SERA EXECUTADO PELA SUBCLASSE QUANDO EXECUTADO
 * */
public class TesteContaEspecial extends TesteContaCorrente {

  @Before
  public void inicializaConta() {
    conta = new ContaEspecial(100);
    conta.depositar(200);
  }
  
  @Test
  public void saqueMaiorQueSaldo() {
    int valorSacado = conta.sacar(300);
    assertEquals(conta.saldo,200);
    assertEquals(valorSacado,0);
    
  }
  
  @Test
  public void testSaqueMaiorQueSaldoDentroDoLimite() {
    int valorSacado = conta.sacar(250);
    assertEquals(conta.saldo,-50);
    assertEquals(valorSacado,250);
  }
 
  
}
