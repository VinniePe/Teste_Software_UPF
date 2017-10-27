package br.com.compasso.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.compasso.modelo.Usuario;
import br.com.compasso.modelo.UsuarioDAO;

/**
 * Servlet implementation class UsuarioControle
 */
@WebServlet("/UsuarioControle")
public class UsuarioControle extends HttpServlet {
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("acao").equals("sair")) {
			HttpSession status = req.getSession(true);
			status.invalidate();
			resp.sendRedirect("index.html");
		}else if(req.getParameter("acao").equals("delete")){
	    		doDelete(req, resp);
	    	}else 
	    		if(req.getParameter("acao").equals("update")){
	    		doPut(req, resp);
	    	}else {
	    		resp.sendRedirect("index.jsp");
	    	}
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("pwd");
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("name");
		String sobrenome = request.getParameter("mName");
		String sexo = request.getParameter("gender");
		String dataNascimento = request.getParameter("birthday");
		String telefone = request.getParameter("phone");
				
		HttpSession status = request.getSession(true);
		status.setAttribute("email", email);
		status.setAttribute("senha", senha);
		status.setAttribute("cpf", cpf);
		status.setAttribute("nome", nome);
		status.setAttribute("sobrenome", sobrenome);
		status.setAttribute("sexo", email);
		status.setAttribute("dataNascimento", dataNascimento);
		status.setAttribute("telefone", telefone);
		
		Usuario user = new Usuario();
		UsuarioDAO dao = new UsuarioDAO();
		boolean teste = false;
		String page = "index.html";
		String errorRegister = null;
		
		if (request.getParameter("acao").equals("insert")) {
			if(!dao.loginAllReadyExists(email)){
				teste = true;
				dao.insere(new Usuario(email, senha, cpf, nome, sobrenome, sexo, dataNascimento, telefone));
			}else{
				errorRegister = "cadastro.html#errorRegister";
			}
		}
		List<Usuario> lista = dao.getLista();

		for (int i = 0; i < lista.size(); i++) {
			user = lista.get(i);
			if (user.getEmail().equals(email) && user.getSenha().equals(senha)) {				
				status.setAttribute("id", user.getId().toString());
				status.setAttribute("cpf", user.getCpf());
				status.setAttribute("nome", user.getNome());
				status.setAttribute("sobrenome", user.getSobrenome());
				status.setAttribute("sexo", user.getSexo());
				status.setAttribute("dataNascimento", user.getDataNascimento());
				status.setAttribute("telefone", user.getTelefone());
				teste = true;
				page = ("UsuarioVisao?email=" + email + "&senha=" + senha);
			}
		}
		if (!teste) {
			status.invalidate();
			page = "index.html#errorLogin";						
		}
		if(errorRegister != null){
			page = errorRegister;
		}
		response.sendRedirect(page);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		String senha = req.getParameter("pwd");
		String cpf = req.getParameter("cpf");
		String nome = req.getParameter("name");
		String sobrenome = req.getParameter("mName");
		String sexo = req.getParameter("gender");
		String dataNascimento = req.getParameter("birthday");
		String telefone = req.getParameter("phone");

		HttpSession status = req.getSession();
		status.setAttribute("id", id);
		status.setAttribute("email", email);
		status.setAttribute("senha", senha);
		status.setAttribute("cpf", cpf);
		status.setAttribute("nome", nome);
		status.setAttribute("sobrenome", sobrenome);
		status.setAttribute("sexo", email);
		status.setAttribute("dataNascimento", dataNascimento);
		status.setAttribute("telefone", telefone);
		Usuario usuario = new Usuario(Integer.parseInt(id), email, senha, cpf, nome, sobrenome, sexo, dataNascimento, telefone);
		UsuarioDAO dao = new UsuarioDAO();
		dao.altera(usuario);
		resp.sendRedirect("perfil.jsp");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsuarioDAO dao = new UsuarioDAO();
		String id = req.getParameter("id");
		dao.deleta(Integer.parseInt(id));
		resp.sendRedirect("UsuarioControle?acao=sair");
	}
}
