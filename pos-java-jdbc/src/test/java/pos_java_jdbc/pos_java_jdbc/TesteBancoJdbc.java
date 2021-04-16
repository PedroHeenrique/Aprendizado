package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import dao.UserPosJavaDAO;
import model.Usuario;
import model.Telefone;
import model.UsuarioTelefone;

public class TesteBancoJdbc {
    
	@Test
	public void inicializaConexao() {
		
		UserPosJavaDAO userBanco = new UserPosJavaDAO();
		Usuario usuario = new Usuario();
		
		usuario.setNome("Epic games");
		usuario.setEmail("Epig@gmail.com");
		
		userBanco.salvar(usuario);
		
	}
	
	@Test
	public void testlistar () {
		UserPosJavaDAO userBanco = new UserPosJavaDAO();
		
		List<Usuario> lista = userBanco.listarTodos();
		
		
		for(Usuario u : lista) {
			System.out.println(u);
			System.out.println("------------");
			
		}
	}
	
	@Test
	public void testbuscar() {
		
		UserPosJavaDAO userdao = new UserPosJavaDAO();
		
		Usuario userEncontrado = userdao.buscar(5);
		System.out.println(userEncontrado);
		
		
	}
	@Test
	public void testAtualizar() {
		
		UserPosJavaDAO userbanco = new UserPosJavaDAO();
		
	    Usuario user = userbanco.buscar(3l);;
	    
	    user.setNome("Josue marques");
	    
	    userbanco.atualizar(user);
		
	}
	@Test
	public void testSalvarTelefone() {
		UserPosJavaDAO dao = new UserPosJavaDAO();
	    Telefone tel = new Telefone();
	    
	    tel.setIdUser(7l);
	    tel.setTelefone("3848-3194");
	    tel.setTipo("Residencial");
	    
	    dao.salvarTelefone(tel);   
		
	}
	
	@Test
	public void testDelete() {
		
		UserPosJavaDAO dao = new UserPosJavaDAO();
		Usuario user = dao.buscar(3l);
		
		dao.deletar(user.getId());
	}
	
	@Test
	public void tesListaFone() {
	
	UserPosJavaDAO dao = new  UserPosJavaDAO();
	
	List<UsuarioTelefone> telefones = dao.listarUserTelefone(7l);
	
	
	for (UsuarioTelefone usuarioTelefone : telefones) {
		System.out.println(usuarioTelefone);
	}
		
	}
	
}
