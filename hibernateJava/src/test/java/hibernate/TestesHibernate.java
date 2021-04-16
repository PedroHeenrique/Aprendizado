package hibernate;

import java.util.List;

import org.junit.Test;

import dao.DaoGenerico;
import model.Telefone;
import model.Usuario;

public class TestesHibernate {

	@Test
	public void testsalvar() {

		DaoGenerico<Usuario> dao = new DaoGenerico<Usuario>();

		Usuario pessoa = new Usuario();

		pessoa.setNome("Pedro Henrique");
		pessoa.setSobrenome("Dos Santos ferreira");
		pessoa.setIdade(27);
		pessoa.setEmail("programadorJavaPleno@gmail.com");
		pessoa.setSenha("110892");
		pessoa.setLogin("PHenriProgramerJava");

		dao.salvar(pessoa);

	}

	@Test
	public void testQueryList() {
	  DaoGenerico<Usuario> daogenerico = new  DaoGenerico<Usuario>();
	  
	  List<Usuario> user =  daogenerico.getEntityManager().createQuery("from Usuario").getResultList();/* PODENDO SER COLOCADO CONDIÇÕES*/
	  
	  for (Usuario usuario : user) {
		  
		  System.out.println(usuario.toString());
		
	}
	 
	}
	 @Test
	  public void testDelete() {
		 DaoGenerico<Usuario> daogenerico = new  DaoGenerico<Usuario>();
		 
		 Usuario pessoa = daogenerico.pesquisarPor(19l, Usuario.class);
		 try {
			 
			 daogenerico.deletarPorID(pessoa);
		 }catch(Exception e) {
			 
		 }
		  
	 }
	 
	 @Test
	 public void testPesquisaID() {
		 
		 DaoGenerico<Usuario> dao = new DaoGenerico<Usuario>();
		 
		 Usuario pessoa = new Usuario();
		 pessoa.setId(23l);
		 
		 pessoa = dao.pesquisar(pessoa);
		 
		 System.out.println(pessoa);
		 
	 }
	 
	 @Test
	 public void testPesquisaIdEntidade() {
      DaoGenerico<Usuario> daogenerico = new  DaoGenerico<Usuario>();
		 
	   Usuario pessoa = daogenerico.pesquisarPor(19l, Usuario.class);
	   System.out.println(pessoa);
	 }
	
	 @Test
	 public void testeGravaTelefone() {
		 DaoGenerico daoGenerico = new DaoGenerico();
		 Usuario pessoa =(Usuario) daoGenerico.pesquisarPor(14l, Usuario.class);
	  
		 Telefone tele = new Telefone();
		 tele.setNumero("11948715091");
		 tele.setTipo("Celular");
		 tele.setUsuarioTelefone(pessoa);
		 daoGenerico.salvar(tele);
	 
	 }
}
