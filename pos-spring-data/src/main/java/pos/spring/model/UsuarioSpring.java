package pos.spring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UsuarioSpring {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
    private String login;
    private String senha;
    private String nome;
    private String email;
   
    @OneToMany(mappedBy = "usuario",orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Telefone> telefone;
    
    
	public List<Telefone> getTelefone() {
		return telefone;
	}
	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "UsuarioSpring [id=" + id + ", login=" + login + ", senha=" + senha + ", nome=" + nome + ", email="
				+ email + "]";
	}
    
	
    
}
