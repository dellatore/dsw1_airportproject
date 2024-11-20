package br.edu.ifsp.dsw1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    		String username = request.getParameter("username"); //pega atraves do name do formulario o valor digitado pelo usuario no campo 'User' do formulario
    	    String password = request.getParameter("textPassword");//pega atraves do name do formulario o valor digitado pelo usuario no campo 'Password' do formulario

    	  //verifica se o usuario e senha estao corretos
          //por padrao do projeto a senha e usuario sao iguais a "admin"
    	    if ("admin".equals(username) && "admin".equals(password)) {

    	    	//armazenando o usuario na Session
    	    	HttpSession session = request.getSession(); 
    	        session.setAttribute("user", username);
    	        
    	        response.sendRedirect("management.jsp"); //direcionando a tela de gerenciamento de voos [exclusiva para admins]
    	    } else {
    	      	
    	        	//caso algum dado de login esteja errado ele envia um parametro de credenciais invalidas
    	        	response.sendRedirect("login.jsp?error=invalid_credentials");
    	    }
    	
    }
}
