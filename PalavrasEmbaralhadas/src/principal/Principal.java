package principal;

import fabricas.FabricaMecanicaDoJogo;
import interfacesDoJogo.MecanicaDoJogo;
import java.util.Scanner;

/*CLASSE COM O MÉTODO MAIN().CLASSE QUE É RESPONSÁVEL POR LER
A ENTRADA DO USUÁRIO E POR IMPRIMIR AS INFORMAÇÕES NO CONSOLE. NENHUMA OUTRA CLASSE PODE
IMPRIMIR OU LER DO CONSOLE.*/

public class Principal {

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    
    System.out.println("Escolha a dificuldade\nNormal = 1 Dificil = 2");
    byte modoDeJogo = entrada.nextByte();
    entrada.nextLine();
    
    MecanicaDoJogo mecanica = FabricaMecanicaDoJogo.getMecanica(modoDeJogo);
   
    do {
      System.out.println("------------------------------");
      System.out.println("Adivinhe qual e a palavra");
      System.out.printf("Pontuacao %d | Tentativas Restantes %d Faltam %d  para serem adivinhadas %n%n", mecanica.getPontucao(),mecanica.getTentativas(),mecanica.palavrasRestantesASeremAdivinhadas());
      System.out.println("DICA: "+mecanica.getdicaDaPalavraASerAdivinhada());
      System.out.println("Que Palavra e essa -> " + mecanica.getpalavraEmbaralhada());
      
      String palavraAdivinhada = entrada.nextLine();
      System.out.println("\n"+mecanica.adivinhar(palavraAdivinhada)+"\n");
     
    }while(!mecanica.jogoTerminou());
    
    System.out.println("Fim do jogo");
    System.out.println("Sua pontucao final:" + mecanica.getPontucao() + " de 100 ");
    entrada.close();
   
  }

}
