package coursera.tarefa;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;


public class Pizza { 
  private static HashMap<String, Integer> ingredientesEQuantidadesUtilizadas = new HashMap<>();
  private static Set<Map.Entry<String, Integer>> itensContidosNoMapa = ingredientesEQuantidadesUtilizadas.entrySet();
  private int quantidadeDeIngredientesUtilizados;
  private double preco;
  private String sabor;

  Pizza(String sabor) {
    this.sabor = sabor;

  }

  public void adicionarIngrediente(String ingrediente) {
    quantidadeDeIngredientesUtilizados++;
    contabilizaIngredientes(ingrediente);
  }

  private static void contabilizaIngredientes(String ingrediente) {
    int acrescenta = 1;
    if (ingredientesEQuantidadesUtilizadas.containsKey(ingrediente))
      ingredientesEQuantidadesUtilizadas.put(ingrediente,
          ingredientesEQuantidadesUtilizadas.get(ingrediente) + acrescenta);
    else
      ingredientesEQuantidadesUtilizadas.put(ingrediente, acrescenta);
  }

  public double getPreco() {
    estipularPreco();
    return preco;

  }

  public String getSabor() {
    return sabor;
  }

  private void estipularPreco() {
      int nao_possui_ingredientes = 0;
      int quantidade_minima_ingrediente = 2;
      int quantidade_media_ingrediente = 3;
      int quantidade_maior_ingrediente = 5;

    if (quantidadeDeIngredientesUtilizados > nao_possui_ingredientes
        && quantidadeDeIngredientesUtilizados <= quantidade_minima_ingrediente) {
      preco = TabelaPreco.MENOR_PRECO.getPreco();
      return;
    }

    if (quantidadeDeIngredientesUtilizados >= quantidade_media_ingrediente
        && quantidadeDeIngredientesUtilizados <= quantidade_maior_ingrediente) {

      preco = TabelaPreco.MEDIO_PRECO.getPreco();

      return;
    }

    if (quantidadeDeIngredientesUtilizados > quantidade_maior_ingrediente) {
      preco = TabelaPreco.MAIOR_PRECO.getPreco();
      return;
    }

    preco = 0;

  }

  public static int tiposDeIngrediente() {
    int quantidadeDetiposDeIngrediente = 0;
    for (Map.Entry<String, Integer> item : itensContidosNoMapa) {
      quantidadeDetiposDeIngrediente++;
    }

    return quantidadeDetiposDeIngrediente;
  }

  public static int totalizarIngredientesUtilizadoNoGeral() {
    int quantidadeTotalDeIngredientesUtilizados = 0;
    for (Map.Entry<String, Integer> item : itensContidosNoMapa) {
      quantidadeTotalDeIngredientesUtilizados += item.getValue();
    }

    return quantidadeTotalDeIngredientesUtilizados;
  }

  public static void exibirIngredientesUtilizadosNoGeral() {
    System.out.println(" Ingrediente   Quantidade Utilizada");

    for (Map.Entry<String, Integer> item : itensContidosNoMapa) {
      System.out.printf("%12s%4d%n", item.getKey(), item.getValue());
    }

  }

  public static void zerarIngredientesUtilizadosNoGeral() {
    ingredientesEQuantidadesUtilizadas.clear();
  }
}
