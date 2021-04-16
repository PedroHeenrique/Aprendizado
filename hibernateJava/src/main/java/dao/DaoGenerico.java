package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import hibernate.HibernateUtil;

public class DaoGenerico<E> {

	private EntityManager gerenciadorEntidade = HibernateUtil.getGerenciadorEntidade();

	public void salvar(E entidade) {
		EntityTransaction transacao = gerenciadorEntidade.getTransaction();
		transacao.begin();
		gerenciadorEntidade.persist(entidade);
		transacao.commit();
	}

	public List<E> listar(Class<E> entidade) {
		EntityTransaction transacao = gerenciadorEntidade.getTransaction();
		transacao.begin();

		List<E> lista = gerenciadorEntidade.createQuery("from " + entidade.getName()).getResultList();

		transacao.commit();
		return lista;
	}
	public void deletarPorID(E entidade) throws Exception{
		
		Object id = HibernateUtil.getChavePrimaria(entidade);
		            
		EntityTransaction transacao = gerenciadorEntidade.getTransaction();
		transacao.begin();
		
		gerenciadorEntidade
		 .createNativeQuery(
				 "delete from "+ entidade.getClass().getSimpleName().toLowerCase() 
				 + " where id = " + id).executeUpdate();
		transacao.commit();
	
		
	}
    
	
	public E pesquisar(E entidade) {
		Object id = HibernateUtil.getChavePrimaria(entidade);
		
		E e = (E) gerenciadorEntidade.find(entidade.getClass(), id);
		return e;
	}
    
	public E pesquisarPor(Long id, Class<E> entidade) {
		gerenciadorEntidade.clear();
		E e = (E) gerenciadorEntidade.createQuery("from " + entidade.getSimpleName() + " where id = " + id).getSingleResult();
		//E eGenerico = (E) gerenciadorEntidade.find(entidade,id);
		
		return e;
	}
	public EntityManager getEntityManager() {

		return gerenciadorEntidade;
	}
}
