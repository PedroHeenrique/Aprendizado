package coursera.tarefa;

import java.util.ArrayList;

public class CarrinhoDeCompras {
   private ArrayList<Pizza> itensDoCarrinho = new ArrayList<>();
  
   public void adicionaPizza(Pizza pizza) {
     if (pizza.getPreco() > 0)
       itensDoCarrinho.add(pizza);
   }
   
   public double  calcularValorTotalPizzas() {
     double totalizacao = 0;
     for(Pizza pizza : itensDoCarrinho) {
        totalizacao += pizza.getPreco();
     }
     
     return totalizacao;
     
   }
   public int getQuantidadeDePizzasNoCarrinho() {
     return itensDoCarrinho.size();
   }
   
   public void pizzasAdicionadasAoCarrinho() {
     System.out.println("  Adicionadas ao carrinho");
     System.out.printf("%14s%10s%n","Pizza","Valor");
     for (Pizza pizza : itensDoCarrinho) {
         System.out.printf("%16s: % .2f %n",pizza.getSabor(), pizza.getPreco());
      
    }
    
     
   }

}
