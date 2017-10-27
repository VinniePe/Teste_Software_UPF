package br.com.compasso.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/UsuarioVisao")
public class UsuarioVisao extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		HttpSession status = request.getSession();
		if( status.getAttribute("email").equals(email) && status.getAttribute("senha").equals(senha)){
			response.sendRedirect("index.jsp");
		}else{
		response.sendRedirect("index.html");
		}
	}

}
