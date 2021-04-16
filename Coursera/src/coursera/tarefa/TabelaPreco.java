package coursera.tarefa;

public enum TabelaPreco {
  MENOR_PRECO(15.00), MEDIO_PRECO(20.00), MAIOR_PRECO(23.00);

  private double preco;

  TabelaPreco(Double preco) {
    this.preco = preco;

  }

  public double getPreco() {
    return preco;
  }

}
