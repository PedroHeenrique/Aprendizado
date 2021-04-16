package dao;

import model.Usuario;

public class DaoUsuario<E> extends DaoGenerico<Usuario>{
	
	public void removerUsuario(Usuario pessoa)throws Exception {
		String sqlDeleteFone = "delete from telefone where usuariopessoa_id = " + pessoa.getId();
		
		getEntityManager().getTransaction().begin();
		getEntityManager().createNativeQuery(sqlDeleteFone).executeUpdate();
		getEntityManager().getTransaction().commit();
		
		super.deletarPorID(pessoa);
	}

}
