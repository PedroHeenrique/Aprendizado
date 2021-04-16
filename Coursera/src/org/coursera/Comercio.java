package org.coursera;

public class Comercio {
    int valorTotal;
    int parcelas;
    
    public Comercio(int valor){
      valorTotal = valor;
      parcelas = 1;
      
    }
    
    public Comercio(int quantidadeParcelas, int valorParcelado) {
      parcelas = quantidadeParcelas;
      valorTotal = valorParcelado *= quantidadeParcelas;
      
    }
    public int getNumeroParcelas() {
      
      return parcelas;
    }
    
    public int getValorTotal() {
      
      return valorTotal;
    }
    
    public int getValorParcela() {
      
      return valorTotal / parcelas;
    }
}
