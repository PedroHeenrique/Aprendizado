/*CLASSE QUE POSSUI UM MÉTODO QUE RETORNA UMA PALAVRA RETIRADA
ALEATÓRIAMENTE DE UMA LISTA DE PALAVRAS LIDA A PARTIR DE UM ARQUIVO.
• EMBARALHADOR: INTERFACE QUE REPRESENTA CLASSES REPONSÁVEIS POR RECEBER UMA PALAVRA E
RETORNAR ELA EMBARALHADA. PELO MENOS DUAS IMPLEMENTAÇÕES DEVERÃO SER FEITAS.*/

package banco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class BancoDePalavras {
  
  private static List<String> listaDePalavras = new ArrayList<>();
  private static String caminhoDoArquivo;
  private static BufferedReader conteudoArquivo;
  private static String palavraAleatoria;
  private static String dicaDaPalavraAleatoria;

  static {
    lerArquivoEArmazenarPalavrasNaLista();  
  }

  private BancoDePalavras (){}
  
  public static List<String> getListaDePalavras(){
    return Collections.unmodifiableList(listaDePalavras);
  }
  
  public static  String getPalavraAleatoria() {
    return palavraAleatoria;
  }
  
  public static String getDicaPalavraAleatoria() {
    return dicaDaPalavraAleatoria;
  }
  
  public static String obterPalavra() {
    separarPalavraDaDica();
    return  palavraAleatoria;
  }
  
  public static String obterDica() {
    if(palavraAleatoria == null) {
      return " ";
    }
    return dicaDaPalavraAleatoria;
  }
  
  public static void removerPalavraDoBanco() {  
    listaDePalavras.remove(palavraAleatoria + "-" + dicaDaPalavraAleatoria);
  }
  
  public static boolean existemPalavrasASeremSorteadas() {
    return !listaDePalavras.isEmpty();
  }
  
  private static void separarPalavraDaDica() {
    String palavraEDica = aleatorizarPalavras();
    palavraAleatoria = palavraEDica.substring(0, palavraEDica.indexOf("-"));
    dicaDaPalavraAleatoria = palavraEDica.substring(palavraEDica.indexOf('-') + 1, palavraEDica.length());
  }
  
  private static String aleatorizarPalavras() {
    Collections.shuffle(listaDePalavras); // MUDA A ORDEM DAS PALAVRAS NA LISTA
    return listaDePalavras.get(0);
  }

  private static void lerArquivoEArmazenarPalavrasNaLista() {
    prepararArquivoParaLeitura();
    String linha = null;
    try {
      while ((linha = conteudoArquivo.readLine()) != null) {
        listaDePalavras.add(linha);
      }
    } catch (IOException erro) {
      System.out.println(erro.getMessage());
    } finally {
      fechaBuffer();
    }
  }

  private static void prepararArquivoParaLeitura() {
    obterCaminhoDoArquivo();
    carregarArquivo();
  }
 
  public static int palavrasRestantes() {
   return listaDePalavras.size();
  }
  private static void obterCaminhoDoArquivo() {
    caminhoDoArquivo = Paths.get("palavras.txt").toAbsolutePath().toString();
  }

  private static void carregarArquivo() {
    try {
      conteudoArquivo = new BufferedReader(new FileReader(caminhoDoArquivo));
    } catch (IOException erro) {
      System.err.println(erro.getMessage());
    }
  }

  private static void fechaBuffer() {
    try {
      conteudoArquivo.close();
    } catch (IOException erro) {
      erro.getMessage();
    }
  }
  
  public static void  apagarPalavraEDicaEscolhida() {
    palavraAleatoria = null;
    dicaDaPalavraAleatoria = null;
  }

}
