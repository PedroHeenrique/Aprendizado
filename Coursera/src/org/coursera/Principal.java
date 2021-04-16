package org.coursera;

public class Principal {

  public static void main(String[] args) {
 
    Paciente pacienteUm = new Paciente(60, 1.70);
    Paciente pacienteDois = new Paciente(120, 1.70);
    Paciente pacienteTres = new Paciente (40,1.30);

    System.out.println(pacienteUm.obterdiagnostico());
    System.out.println(pacienteDois.obterdiagnostico());
    System.out.println(pacienteTres.obterdiagnostico());
  }

}
