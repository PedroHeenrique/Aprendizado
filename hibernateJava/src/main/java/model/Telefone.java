package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Telefone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String tipo;
	private String numero;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Usuario usuarioTelefone;

	public Usuario getUsuarioTelefone() {
		return usuarioTelefone;
	}

	public void setUsuarioTelefone(Usuario usuarioTelefone) {
		this.usuarioTelefone = usuarioTelefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Usuario getUsuario() {
		return usuarioTelefone;
	}

	public void setUsuario(Usuario usuario) {
		this.usuarioTelefone = usuario;
	}

}
