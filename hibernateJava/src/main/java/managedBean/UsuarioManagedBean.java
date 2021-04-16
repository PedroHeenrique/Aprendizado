package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import dao.DaoUsuario;
import model.Usuario;

@ManagedBean(name = "UsuarioManagedBean")
@ViewScoped
public class UsuarioManagedBean {

	private Usuario user = new Usuario();
	private List<Usuario> lista = new ArrayList<Usuario>();
    private DaoUsuario<Usuario> daogenerico = new DaoUsuario<Usuario>();
	private BarChartModel barCharModel = new BarChartModel();
    
    
    public Usuario getUsuario() {
		return user;
	}

	public void setUsuario(Usuario usuario) {
		this.user = usuario;
	}

	public String salvar() {
		daogenerico.salvar(user);
		lista.add(user);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação", "Salvo com sucesso!"));
		return ""; /*
					 * CASO QUISESSE QUE RETORNASSE PARA OUTRA TELA ERA SO ESPECIFICAR O NOME DA
					 * TELA NO RETORNO DESSE METODO
					 */
	}

	public String novo() {
		user = new Usuario();// DEPOIS QUE SALVA INSTANCIA UM NOVO OBJETO QUE ELE VAI RETORNAR UM OBJETO
								// VAZIO
		return "";
	}

	/*
	 * DEPOIS QUE O MANAGED BEAN E CONSTRUIDO NA MEMORIA VAI CONSULTAR NO BANCO ESSE METODO
	 * APENAS UMA VEZ
	 */
	@PostConstruct
	public void init() {
		lista = daogenerico.listar(Usuario.class);
		
		for (Usuario usuario : lista) {
			ChartSeries usersalario = new ChartSeries("Salario do Usuario");
			usersalario.setLabel("Usuario");
			usersalario.set(usuario.getNome(),usuario.getSalario());
			barCharModel.addSeries(usersalario);
		}

	}
    
	public BarChartModel getBarCharModel() {
		return barCharModel;
	}
	
	public List<Usuario> getList() {
		return lista;
	}

	public String remover() {
		try {
			daogenerico.removerUsuario(user);
			lista.remove(user);
			Usuario usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação", "Removido com sucesso!"));

		} catch (Exception e) {
			if (e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Informação:", "Existem telefones para o Usuario"));
			}

		}
		return "";
	}
}
