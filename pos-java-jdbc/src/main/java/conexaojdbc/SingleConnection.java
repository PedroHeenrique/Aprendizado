package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

	   private static String urlBanco = "jdbc:postgresql://localhost:5432/posjava";
	   private static String usuario = "postgres";
	   private static String senha = "110892";
	   
	   private static Connection conexao = null;
	   
	   static {
		   
		   conectar();
	   }
	   
	   public SingleConnection(){
		   
		   conectar();
	   }
	   
	   private static void conectar() {
		   try
		   {
			 if(conexao == null) {
				 Class.forName("org.postgresql.Driver");
				 conexao = DriverManager.getConnection(urlBanco, usuario, senha);
				 conexao.setAutoCommit(false);//para não salvar automaticamente.
				 System.out.println("Conectou com sucesso");
				 
			 }
			 
		   }catch(Exception e) {
			   e.printStackTrace();
			   
		   }
	   }
	   
	   public static Connection getConexao() {
		   return conexao;
	   }
}
