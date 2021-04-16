package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import conexaojdbc.SingleConnection;
import model.Telefone;
import model.Usuario;
import model.UsuarioTelefone;

public class UserPosJavaDAO {

	private Connection conexao;

	public UserPosJavaDAO() {

		conexao = SingleConnection.getConexao();
	}

	public void salvar(Usuario user) {

		String sql = "insert into userposjava (nome,email) values (?,?)";

		try {
			PreparedStatement insert = conexao.prepareStatement(sql);
			// posição e valor a ser passado
			insert.setString(1, user.getNome());
			insert.setString(2, user.getEmail());

			insert.execute();
			conexao.commit();

		} catch (SQLException error) {
			error.printStackTrace();
			try {
				conexao.rollback();

			} catch (SQLException rollbackError) {
				rollbackError.printStackTrace();
			}

		}

	}

	public void salvarTelefone(Telefone tel) {
		String sql = "INSERT INTO telefoneuser(numero, tipo, usuario)VALUES ( ?, ?, ?)";

		try {
			PreparedStatement insertTel = conexao.prepareStatement(sql);
			insertTel.setString(1, tel.getTelefone());
			insertTel.setString(2, tel.getTipo());
			insertTel.setLong(3, tel.getIdUser());

			insertTel.execute();
			conexao.commit();
		} catch (SQLException erro) {
			erro.printStackTrace();
			try {
				conexao.rollback();

			} catch (SQLException rollbackError) {
				rollbackError.printStackTrace();
			}

		}

	}

	public Usuario buscar(long id) {

		Usuario user = new Usuario();
		String sql = "Select * from  userposjava where id = " + id;

		try {
			PreparedStatement selecao = conexao.prepareStatement(sql);
			ResultSet resultado = selecao.executeQuery();

			while (resultado.next()) {
				user.setId(resultado.getLong("ID"));
				user.setNome(resultado.getString("nome"));
				user.setEmail(resultado.getString("email"));
			}

		} catch (SQLException erroSelect) {

			erroSelect.printStackTrace();
		}
		return user;

	}

	public void atualizar(Usuario user) {
		try {

			String sql = "Update userposjava set nome = ? where id = " + user.getId();
			PreparedStatement update = conexao.prepareStatement(sql);
			update.setString(1, user.getNome());
			update.execute();
			conexao.commit();

		} catch (SQLException errorUpdate) {

			try {

				conexao.rollback();
			} catch (SQLException erroRollback) {
				erroRollback.printStackTrace();
			}
			errorUpdate.printStackTrace();

		}

	}

	public void deletar(long id) {

		try {
			String sql = "Delete from userposjava where id =" + id;

			PreparedStatement delete = conexao.prepareStatement(sql);
			delete.execute();
			conexao.commit();

		} catch (SQLException errorDelete) {

			try {
				conexao.rollback();
			} catch (SQLException errorRollback) {
				errorRollback.printStackTrace();
			}
		}

	}

	public List<UsuarioTelefone> listarUserTelefone(long idUser) {
		List<UsuarioTelefone> userFone = new ArrayList<>();

		String sql = " select nome,numero,email from telefoneuser as Fone ";
		sql += " inner join userposjava as usuario on (fone.usuario = usuario.id) ";
		sql+= " where usuario = " + idUser;

		try {
			PreparedStatement inner = conexao.prepareStatement(sql);
			ResultSet resultado = inner.executeQuery();
			
			while(resultado.next()) {
				UsuarioTelefone usuarioFone = new UsuarioTelefone();
				
				usuarioFone.setNome(resultado.getString("nome"));
				usuarioFone.setNumero(resultado.getString("numero"));
				usuarioFone.setEmail(resultado.getString("email"));
				
				userFone.add(usuarioFone);
				
			}
		} catch (SQLException erroInner) {

			erroInner.printStackTrace();

		}
		return userFone;
	}

	public List<Usuario> listarTodos() {

		List<Usuario> users = new ArrayList<Usuario>();
		String sql = "Select * from  userposjava";

		try {
			PreparedStatement selecao = conexao.prepareStatement(sql);
			ResultSet resultado = selecao.executeQuery();

		
			while (resultado.next()) {

				Usuario user = new Usuario();
				user.setId(resultado.getLong("ID"));
				user.setNome(resultado.getString("nome"));
				user.setEmail(resultado.getString("email"));

				users.add(user);
			}

		} catch (SQLException erroSelect) {

			erroSelect.printStackTrace();
		}
		return users;

	}

}
