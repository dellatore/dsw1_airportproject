<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- Retorna uma url com um parametro error, que indica que é necessario realizar o login -->
   <%
	    String user = (String) session.getAttribute("user");
	    if (user == null) {
	        response.sendRedirect("login.jsp?error=login_required");
	        return;
	    }
	%>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flight Management</title>
</head>
<body>

	<!-- Botão apenas para teste da funcionalidade de Logout -->
	<a href="LogoutServlet">Log out</a>

</body>
</html>