package br.com.compasso.modelo;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.com.compasso.bd.ConnectionFactory;

public class UsuarioDAO extends BeanCrud implements Serializable {

	public UsuarioDAO() {
		try {
			connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean validateUser(Usuario usuario) throws Exception {
		if (usuario.getEmail().isEmpty() || usuario.getEmail() == null || usuario.getEmail().length() < 10) {
			throw new Exception("Error: E-mail '" + usuario.getEmail() + "' is invalid.");
		} else if (usuario.getSenha().length() < 6) {
			throw new Exception("Error: password '" + usuario.getSenha() + "' is invalid.");
		} else if (usuario.getCpf().length() < 14) {
			throw new Exception("Error: cpf '" + usuario.getCpf() + "' is invalid.");
		} else if (usuario.getNome().length() < 2) {
			throw new Exception("Error: name '" + usuario.getNome() + "' is invalid.");
		} else if (usuario.getSobrenome().length() < 1) {
			throw new Exception("Error: last name '" + usuario.getSobrenome() + "' is invalid");
		} else if (usuario.getSexo().isEmpty() || usuario.getSexo() == null) {
			throw new Exception("Error: gender '" + usuario.getSexo() + "' is invalid.");
		} else if (usuario.getDataNascimento().length() != 10) {
			throw new Exception("Error: date of birth '" + usuario.getDataNascimento().length() + "' is invalid.");
		} else if (usuario.getTelefone().length() < 13) {
			throw new Exception("Error: telephone number '" + usuario.getTelefone() + "' is invalid.");
		}
		return true;
	}

	public void insere(Usuario usuario) {
		String sql = "insert into usuario " + "(email, senha, cpf, nome, sobrenome, sexo, dataNascimento, telefone)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
		List<Object> arguments = new ArrayList<Object>();
		arguments.add(usuario.getEmail());
		arguments.add(usuario.getSenha());
		arguments.add(usuario.getCpf());
		arguments.add(usuario.getNome());
		arguments.add(usuario.getSobrenome());
		arguments.add(usuario.getSexo());
		arguments.add(usuario.getDataNascimento());
		arguments.add(usuario.getTelefone());
		toDo(sql, arguments);
	}

	public void altera(Usuario usuario) {
		String sql = "update usuario set email=?, senha=?, cpf=?, nome=?, sobrenome=?, sexo=?, "
				+ "dataNascimento=?, telefone=?" + " where id=?";
		List<Object> arguments = new ArrayList<Object>();
		arguments.add(usuario.getEmail());
		arguments.add(usuario.getSenha());
		arguments.add(usuario.getCpf());
		arguments.add(usuario.getNome());
		arguments.add(usuario.getSobrenome());
		arguments.add(usuario.getSexo());
		arguments.add(usuario.getDataNascimento());
		arguments.add(usuario.getTelefone());
		arguments.add(usuario.getId());
		toDo(sql, arguments);
	}

	public void deleta(int id) {
		String sql = "delete from usuario " + "where id = ?";
		List<Object> arguments = new ArrayList<Object>();
		arguments.add(id);
		toDo(sql, arguments);
	}

	public List<Usuario> getLista() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select * from usuario ";
		Statement st;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Usuario user = new Usuario();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setSenha(rs.getString("senha"));
				user.setCpf(rs.getString("cpf"));
				user.setNome(rs.getString("nome"));
				user.setSobrenome(rs.getString("sobrenome"));
				user.setSexo(rs.getString("sexo"));
				user.setDataNascimento(rs.getString("dataNascimento"));
				user.setTelefone(rs.getString("telefone"));

				usuarios.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	public Usuario find(Integer id) {
		String sql = "select * from usuario where id=" + id;
		Statement st;
		Usuario user = null;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			user = new Usuario();
			user.setId(rs.getInt("id"));
			user.setEmail(rs.getString("email"));
			user.setSenha(rs.getString("senha"));
			user.setCpf(rs.getString("cpf"));
			user.setNome(rs.getString("nome"));
			user.setSobrenome(rs.getString("sobrenome"));
			user.setSexo(rs.getString("sexo"));
			user.setDataNascimento(rs.getString("dataNascimento"));
			user.setTelefone(rs.getString("telefone"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public boolean loginAllReadyExists(String email) {
		String sql = "select * from usuario where email='" + email + "';";
		Statement st;
		boolean loginExists = false;
		try {
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString("email").equals(email)) {
					loginExists = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginExists;
	}
}