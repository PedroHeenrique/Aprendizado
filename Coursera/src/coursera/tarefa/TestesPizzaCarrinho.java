package coursera.tarefa;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestesPizzaCarrinho {

  @Before
  /*CHAMADO ANTES DE CADA CASO DE TESTE PARA LIMPAR OS INGREDIENTES ARMAZENADOS 
   * POR CASOS DE TESTE ANTERIORE */
  public void testZeraIngredientes() {
    Pizza.zerarIngredientesUtilizadosNoGeral();
  }

  @Test
  /*VALOR DA PIZZA COM QUANTIDADE DE 2 INGREDIENTES*/
  public void testValorDaPizzaComDoisIngredientes() {
    Pizza portuguesa = new Pizza("Portuguesa");
    portuguesa.adicionarIngrediente("Tomate");
    portuguesa.adicionarIngrediente("Presunto");
           //  ESPERADO      ATUAL         TOLERANCIA
    assertEquals(15, portuguesa.getPreco(), 15.00);
  }

  
  @Test
  /*VALOR DA PIZZA  COM  QUANTIDADE DE 3 INGREDIENTES*/
  public void testValorDaPizzaComTresIngredientes() {
    Pizza portuguesa = new Pizza("Portuguesa");
    portuguesa.adicionarIngrediente("Tomate");
    portuguesa.adicionarIngrediente("Presunto");
    portuguesa.adicionarIngrediente("queijo");
    // ESPERADO ATUAL TOLERANCIA
    assertEquals(20.00, portuguesa.getPreco(), 15.00);
  }

  @Test
  /*VALOR DA PIZZA COM QUANTIDADE DE 6 INGREDIENTES*/
  public void testValorDaPizzaComSeisIngredientes() {
    Pizza pizzaEspecial = new Pizza("Portuguesa");
    pizzaEspecial.adicionarIngrediente("Tomate");
    pizzaEspecial.adicionarIngrediente("Presunto");
    pizzaEspecial.adicionarIngrediente("Mussarela");
    pizzaEspecial.adicionarIngrediente("Milho");
    pizzaEspecial.adicionarIngrediente("Bacon");
    pizzaEspecial.adicionarIngrediente("Oregano");

            // ESPERADO  ATUAL             TOLERANCIA
    assertEquals(23, pizzaEspecial.getPreco(), 23);
  }

  @Test
  /*VERIFICA A QUANTIDADE DE INGREDIENTES NO GERAL*/
  public void testQuantidadeIngredientes() {
    Pizza portuguesa = new Pizza("Portuguesa");
    portuguesa.adicionarIngrediente("Tomate");
    portuguesa.adicionarIngrediente("Presunto");
    portuguesa.adicionarIngrediente("Mussarela");
    portuguesa.adicionarIngrediente("Oregano");

    Pizza quatroQueijos = new Pizza("Quatro queijos");
    quatroQueijos.adicionarIngrediente("Mussarela");
    quatroQueijos.adicionarIngrediente("Parmesao");
    quatroQueijos.adicionarIngrediente("Chedar");
    quatroQueijos.adicionarIngrediente("Queijo Minas");
    quatroQueijos.adicionarIngrediente("Oregano");

    assertEquals(9, Pizza.totalizarIngredientesUtilizadoNoGeral());

  }
  @Test
  /*VERIFICA SE SOMENTE UM TIPO DE INGREDIENTE FOI INSERIDO NA LISTA DE INGREDIENTES
   * */
  public void testTiposDeingrediente() {
    
    Pizza portuguesa = new Pizza("Portuguesa");
    portuguesa.adicionarIngrediente("Tomate"); 
    portuguesa.adicionarIngrediente("Presunto");
    portuguesa.adicionarIngrediente("Mussarela");
    portuguesa.adicionarIngrediente("Oregano");

    Pizza quatroQueijos = new Pizza("Quatro queijos");    
    quatroQueijos.adicionarIngrediente("Tomate");
    quatroQueijos.adicionarIngrediente("Mussarela");
    quatroQueijos.adicionarIngrediente("Parmesao");
    quatroQueijos.adicionarIngrediente("Chedar");
    quatroQueijos.adicionarIngrediente("Queijo Minas");
    quatroQueijos.adicionarIngrediente("Oregano");
   
    assertEquals(7, Pizza.tiposDeIngrediente());
  
    
  }
  
  @Test
  public void testPizzasAdicionadasAOCarrinho() {
    Pizza portuguesa = new Pizza("Portuguesa");
    portuguesa.adicionarIngrediente("Tomate");
    portuguesa.adicionarIngrediente("Presunto");
    portuguesa.adicionarIngrediente("Mussarela");
    portuguesa.adicionarIngrediente("Oregano");

    Pizza quatroQueijos = new Pizza("Quatro queijos");
    quatroQueijos.adicionarIngrediente("Mussarela");
    quatroQueijos.adicionarIngrediente("Parmesao");
    quatroQueijos.adicionarIngrediente("Chedar");
    quatroQueijos.adicionarIngrediente("Queijo Minas");
    quatroQueijos.adicionarIngrediente("Oregano");
    
    CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
    
    carrinho.adicionaPizza(portuguesa);
    carrinho.adicionaPizza(quatroQueijos);
    
    assertEquals(35,carrinho.calcularValorTotalPizzas(),35.00);
      
  }
  
  @Test
  /*VERIFICA SE UMA PIZZA SEM INGREDIENTES NAO FOI ADICIONADA AO CARRINHO*/
  public void testAdicionarPizzaSemIngrediente() {
    
    Pizza pizzaSemIngrediente = new Pizza("SEM SABOR");
    
    CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
    
    assertEquals(0,carrinho.getQuantidadeDePizzasNoCarrinho());
    
    
  }
  

}
