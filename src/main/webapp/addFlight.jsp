<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%
	    Boolean authenticated = (Boolean) session.getAttribute("isAuthenticated");
	    if (authenticated == null || authenticated.equals("false")) {
	        response.sendRedirect("login.jsp?error=login_required");
	        return;
	    }
	%>
    
    
<!DOCTYPE html>
<html>
<head>
    <title>Flight Registration</title>
</head>
<body>

<h2>Flight Registration</h2>

<!-- Formulário para adicionar voo -->
<form action="addFlight" method="post">
    <label for="flightNumber">Flight number:</label>
    <input type="text" id="flightNumber" name="flightNumber" required />
    <br>
    <label for="company">Company:</label>
    <input type="text" id="company" name="company" required />
    <br>
    <label for="time">Arrival time:</label>
    <input type="text" id="time" name="time" required />
    <br>
    <input type="submit" value="Cadastrar Voo" />
</form>

<!-- Link para gerenciar voos -->
<br>
<a href="management.jsp">To Go Back</a>

</body>
</html>