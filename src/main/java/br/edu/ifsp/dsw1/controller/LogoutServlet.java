package br.edu.ifsp.dsw1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//quando o usuario clicar no botão 'enter' o browser vai fazer uma requisição do tipo get
    	//o servlet ira pegar a sessao salva e inavalidara ela, ou seja, reseta para null a sessao
    	//retirando a permissao para acessar a tela de gerenciamento
        HttpSession session = request.getSession(false);
        if (session != null) {
        	session.setAttribute("isAuthenticated", false);
        }
        response.sendRedirect("index.jsp");  //redireciona para a tela de login
    }

}
