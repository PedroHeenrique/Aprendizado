package pos.spring;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pos.spring.dao.InterfaceSpringDataUser;
import pos.spring.dao.InterfaceTelefone;
import pos.spring.model.Telefone;
import pos.spring.model.UsuarioSpring;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"}) /*EM FORMA DE ARRAY*/
public class AppSpringDataTest {
	
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Autowired
	private InterfaceTelefone interfaceTelefone;
	
	@Test
	public void testeInsert() {
		System.out.println("iniciou Spring com sucesso");
	}
	
	@Test
	public void testInsert() {
	    UsuarioSpring usuarioSpring = new UsuarioSpring();
	    usuarioSpring.setEmail("PHenrique@outlook.com");
	    usuarioSpring.setLogin("JavaSenior");
	    usuarioSpring.setSenha("123");
	    usuarioSpring.setNome("Pedro H S Ferreira");
	    
	    interfaceSpringDataUser.save(usuarioSpring);
	    System.out.println(interfaceSpringDataUser.count());
	}
    
	@Test
	public void testConsulta() {
		
		Optional<UsuarioSpring> user = interfaceSpringDataUser.findById(1l);
		
		System.out.println(user.get().getNome());
		System.out.println(user.get().getLogin());
		System.out.println(user.get().getEmail());

	}
	
	@Test
	public void testConsularTodos () {
		
		Iterable<UsuarioSpring> listaDeUsuarios = interfaceSpringDataUser.findAll();
		
		for (UsuarioSpring usuarioSpring : listaDeUsuarios) {
			System.out.println(usuarioSpring);
		}
		
	}
	
	@Test
	public void testUpdate() {
		Optional<UsuarioSpring> user = interfaceSpringDataUser.findById(1l);
		
		UsuarioSpring data =  user.get();
		data.setEmail("pedroheenriqd@gmail.com");
		interfaceSpringDataUser.save(data);
	}
	
	@Test
	public void testDelete() {
		
		
		Optional<UsuarioSpring> user = interfaceSpringDataUser.findById(2l);
		
		interfaceSpringDataUser.delete(user.get());
		
	/*	interfaceSpringDataUser.deleteById(2l);*/
		
	}
	@Test
	public void testConsultaNome() {
	  List<UsuarioSpring> user = interfaceSpringDataUser.buscaPorNome("Pedro");
	  
	  for (UsuarioSpring usuarioSpring : user) {
		System.out.println(usuarioSpring);
	}
	}
	
	@Test
	public void testBuscaPorParametro() {
	UsuarioSpring user = interfaceSpringDataUser.buscaNomePorParametro("Pedro Henrique");
	
	System.out.println(user);
		
	}
	
	@Test
	public void testDeletePorNome() {
		interfaceSpringDataUser.deletePorNome("Dom");
		
	}
	
	@Test
	public void testUpdateEmailPorNome() {
		interfaceSpringDataUser.updateEmailPorNome("programadorjavaPedro@outlook.com", "Pedro Henrique");
	}
	
	@Test
	public void testTelefone() {
		Optional <UsuarioSpring>user= interfaceSpringDataUser.findById(1l);
		
		Telefone contato = new Telefone();
		
		contato.setNumero("3848-1450");
		contato.setTipo("Residencial");
		contato.setUsuario(user.get());
		
		interfaceTelefone.save(contato);
		/*Optional<UsuarioSpring> user = interfaceSpringDataUser.findById(1l);
		Telefone tele = new Telefone();
		
		tele.setNumero("123456789");
		tele.setTipo("celular");
		tele.setUsuario(user.get());
		
		interfaceTelefone.save(tele);**/
	}
}
