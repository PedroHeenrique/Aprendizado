package org.coursera;

import java.util.Formatter;

public class Paciente {
    private double peso;
    private double altura;
    
    public Paciente(double peso, double altura) {
      this.peso = peso;
      this.altura = altura;
      
    }
    
    public String obterdiagnostico() {
      double indiceDeMassaCorporal = this.calcularIMC();
    
     try ( Formatter formatoIndiceDeMassaCorporal = new Formatter()){
      formatoIndiceDeMassaCorporal.format("%6.3f", indiceDeMassaCorporal);
      
      return "IMC: " + formatoIndiceDeMassaCorporal.toString() + 
             "\nDiagnostico: " + TiposDiagnosticos.realizarDiagnostico(indiceDeMassaCorporal) + "\n";
    
     }
     
    }
    
    public double calcularIMC() {
      return this.peso / (this.altura * this.altura);
      
    }
    
  

}
