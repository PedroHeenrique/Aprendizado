package managedBean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.DaoTelefone;
import dao.DaoUsuario;
import model.Telefone;
import model.Usuario;

@ManagedBean(name = "telefoneManagedBean")
@ViewScoped
public class TelefoneManagedBean {

	private DaoTelefone<Telefone> daotelefone = new DaoTelefone<Telefone>();
	private Usuario usuario = new Usuario();
	private DaoUsuario<Usuario> daoUser = new DaoUsuario<Usuario>();

	private Telefone telefone = new Telefone();

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	@PostConstruct
	public void init() {

		String codigoUsuario = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("codigousuario");
		System.out.println(codigoUsuario);

		usuario = daoUser.pesquisarPor(Long.parseLong(codigoUsuario), Usuario.class);

	}

	public String salvar() {
		telefone.setUsuario(usuario);/* ESPECIFICA QUE E O USUARIO DONO DO TELEFONE */
		daotelefone.salvar(telefone);
		
		telefone = new Telefone(); /* RETORNA UMA NOVA INSTANCIA PARA CADASTRAR NOVAMENTE */
		usuario = daoUser.pesquisarPor(usuario.getId(), Usuario.class);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação", "Salvo com sucesso"));

		return "";
	}
	
	public String removeTelefone() throws Exception{
		daotelefone.deletarPorID(telefone);
		telefone = new Telefone();/*DEPOIS QUE REMOVE DEVE SE INSTANCIAR OUTRO OBJETO PARA EVITAR CONFLITO EM TELA*/
		usuario = daoUser.pesquisarPor(usuario.getId(), Usuario.class);
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação", "Telefone removido com sucesso"));

		
		return "";
	}

	public void setUsuario(Usuario user) {
		this.usuario = user;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setDaotelefone(DaoTelefone<Telefone> daotelefone) {
		this.daotelefone = daotelefone;
	}

	public DaoTelefone<Telefone> getDaotelefone() {
		return daotelefone;
	}
}
