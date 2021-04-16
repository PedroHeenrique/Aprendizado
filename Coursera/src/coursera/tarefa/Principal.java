package coursera.tarefa;

public class Principal {

  public static void main(String[] args) {
    
   
    Pizza portuguesa = new Pizza("Portuguesa");
    portuguesa.adicionarIngrediente("Tomate");
    portuguesa.adicionarIngrediente("Mussarela");
    portuguesa.adicionarIngrediente("Presunto");
    portuguesa.adicionarIngrediente("Molho");
    portuguesa.adicionarIngrediente("Oregano");
    portuguesa.adicionarIngrediente("Catupiry");
    
    Pizza quatroQueijos = new Pizza("Quatro queijos");
    quatroQueijos.adicionarIngrediente("Mussarela");
    quatroQueijos.adicionarIngrediente("Quejo prato");
    quatroQueijos.adicionarIngrediente("Provolone");
    quatroQueijos.adicionarIngrediente("Queijo minas");
    quatroQueijos.adicionarIngrediente("Oregano");
    
    Pizza calabresa = new Pizza("Calabresa");
    calabresa.adicionarIngrediente("Calabresa");
    calabresa.adicionarIngrediente("Cebola");
 
    CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
    carrinho.adicionaPizza(portuguesa);
    carrinho.adicionaPizza(quatroQueijos);
    carrinho.adicionaPizza(calabresa);
    carrinho.pizzasAdicionadasAoCarrinho();
    System.out.println("-------------------------");
    System.out.printf("Total Carrinho = R$ %.2f%n",carrinho.calcularValorTotalPizzas());
    
    Pizza.exibirIngredientesUtilizadosNoGeral();
    
  }

}
