<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Airport DSW1</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
	
	<style> <!-- estilo das mensagens de erro-->
        .error {
            color: red;
            margin-top: 10px;
        }
    </style>
</head>
<body>

	
	<!-- Div que so sera renderizada caso ocorra um dos erros das condições --> 
    <div class="card position-absolute top-50 start-50 translate-middle" style="width: 70%;height: 50%; align-items: center;justify-content: center;" align="center">
	<div >
		<%
            String error = request.getParameter("error");
            if ("login_required".equals(error)) {
        %>
                <p class="error">!!You need to log in to access the system..!!</p>
        <%
            } else if ("invalid_credentials".equals(error)) {
        %>
                <p class="error">!!Invalid username and/or password. Please try again!!</p>
        <%
            }
        %>
	</div>
    	
    <!-- Formulario com os dados para login -->
   <form action="login.do" method="post">
	    <label for="user">User:</label>
	    <input type="text" id="user" name="username" required>
	    <br>
	    <br>
	    <br>
	    <label for="password">Password:</label>
	    <input type="password" id="password" name="textPassword" required>
	    <br>
	    <br>
	    <br>
	    <button type="submit">Enter</button>
	</form>
    
    </div>


<jsp:include page="/includes/script.html"></jsp:include>
</body>
</html>