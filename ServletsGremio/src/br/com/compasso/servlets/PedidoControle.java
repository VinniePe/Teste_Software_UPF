package br.com.compasso.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.compasso.modelo.Pedido;
import br.com.compasso.modelo.PedidoDAO;
import br.com.compasso.modelo.Produto;
import br.com.compasso.modelo.Usuario;
import br.com.compasso.modelo.UsuarioDAO;



/**
 * Servlet implementation class PedidoControle
 */
@WebServlet("/PedidoControle")
public class PedidoControle extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("opcao").equals("delete")) {
			doDelete(req, resp);
		} else if (req.getParameter("opcao").equals("update")) {
			doPut(req, resp);
		} else if (req.getParameter("opcao").equals("refresh")) {
			resp.sendRedirect("pedidos.jsp");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession status = req.getSession();
		String id = status.getAttribute("id").toString();
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuario = usuarioDao.find(Integer.parseInt(id));
		Produto prod = new Produto();
		prod = prod.find(Integer.parseInt(req.getParameter("prod")));
		Integer qtd = Integer.parseInt(req.getParameter("quantidade"));
		Integer valor = prod.getValor() * qtd;
		
		Pedido pedido = new Pedido(usuario, prod, Integer.parseInt(req.getParameter("quantidade")), valor);
		PedidoDAO dao = new PedidoDAO();
		dao.insere(pedido);
		resp.sendRedirect("pedidos.jsp");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession status = req.getSession();
		String id = status.getAttribute("id").toString();
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuario = usuarioDao.find(Integer.parseInt(id));		
		Produto prod = new Produto();
		prod = prod.find(Integer.parseInt(req.getParameter("prod")));
		Integer valor = prod.getValor() * Integer.parseInt(req.getParameter("quantidade"));
		
		Pedido pedido = new Pedido(Integer.parseInt(req.getParameter("id")), usuario, prod, Integer.parseInt(req.getParameter("quantidade")), valor);
		PedidoDAO dao = new PedidoDAO();
		dao.altera(pedido);
		resp.sendRedirect("pedidos.jsp");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PedidoDAO dao = new PedidoDAO();
		String id = req.getParameter("id");
		dao.deleta(Integer.parseInt(id));
		resp.sendRedirect("PedidoControle?opcao=refresh");
	}
}
