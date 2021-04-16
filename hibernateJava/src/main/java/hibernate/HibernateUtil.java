package hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	
	public static EntityManagerFactory fabrica = null;
	
	static {
		iniciar();
	}
	
	private static void iniciar() {
		
		try {
			
			if(fabrica == null) {
				
				fabrica = Persistence.createEntityManagerFactory("hibernateJava");
			}

		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static EntityManager getGerenciadorEntidade() {
		return fabrica.createEntityManager();
	}
	
	public static Object getChavePrimaria(Object entidade) {
		return fabrica.getPersistenceUnitUtil().getIdentifier(entidade);
	}
	
	public static void getTableName() {
		
		fabrica.getClass();
	}

}
