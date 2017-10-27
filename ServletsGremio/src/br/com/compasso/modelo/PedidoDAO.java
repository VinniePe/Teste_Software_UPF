package br.com.compasso.modelo;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.com.compasso.bd.ConnectionFactory;

public class PedidoDAO extends BeanCrud implements Serializable{
	
	public PedidoDAO() {
		try {
			connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insere(Pedido pedido) {
		String sql = "insert into pedido " + "( usuario_id, produto_id, quantidade, valor)"
				+ " values (?,?,?,?)";
		List<Object> arguments = new ArrayList<Object>();
		arguments.add(pedido.getUsuario().getId());
		arguments.add(pedido.getProduto().getId());
		arguments.add(pedido.getQuantidade());
		arguments.add(pedido.getValor());
		toDo(sql, arguments);

	}

	public void altera(Pedido pedido) {
		String sql = "update pedido set usuario_id = ?, produto_id = ?, quantidade = ?,"
				+ " valor = ? where id = ?";
		List<Object> arguments = new ArrayList<Object>();
		arguments.add(pedido.getUsuario().getId());
		arguments.add(pedido.getProduto().getId());
		arguments.add(pedido.getQuantidade());
		arguments.add(pedido.getValor());
		arguments.add(pedido.getId());
		toDo(sql, arguments);
	}

	public void deleta(int id) {
		String sql = "delete from pedido " + "where id = ?";
		List<Object> arguments = new ArrayList<Object>();
		arguments.add(id);
		toDo(sql, arguments);
	}

	public List<Pedido> getLista() {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		String sql = "select * from pedido ";
		Statement st;
		try {
			st = connection.createStatement();

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Pedido pdd = new Pedido();
				pdd.setId(rs.getInt("id"));
				UsuarioDAO daoU = new UsuarioDAO();		
				pdd.setUsuario(daoU.find(rs.getInt("usuario_id")));
				Produto p = new Produto();
				pdd.setProduto(p.find(rs.getInt("produto_id")));
				pdd.setQuantidade(rs.getInt("quantidade"));
				pdd.setValor(rs.getInt("valor"));
				pedidos.add(pdd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pedidos;
	}
	
	public List<Pedido> getLista(Integer id) {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		String sql = "select * from pedido where usuario_id=" + id;
		Statement st;
		try {
			st = connection.createStatement();

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Pedido pdd = new Pedido();
				pdd.setId(rs.getInt("id"));
				UsuarioDAO daoU = new UsuarioDAO();		
				pdd.setUsuario(daoU.find(rs.getInt("usuario_id")));
				Produto p = new Produto();
				pdd.setProduto(p.find(rs.getInt("produto_id")));
				pdd.setQuantidade(rs.getInt("quantidade"));
				pdd.setValor(rs.getInt("valor"));
				pedidos.add(pdd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pedidos;
	}
}
