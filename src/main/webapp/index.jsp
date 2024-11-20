<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Home Page</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
	
</head>
<body>

	<div class="card position-absolute top-50 start-50 translate-middle" style="width: 18rem;" align="center">
	
		<div style="width: 100%; height: 10rem; margin-top: 10px">
    		<i class="bi bi-person-circle" style="font-size: 9rem;"></i>  <!-- ícone do login -->
		</div>
	
		<div style="padding-top: 20px">
			<a href="login.jsp" style="font-size: 30px; text-decoration: none; display: inline-flex; align-items: center;">
				<span style="margin-right: 8px;">Login</span> <!-- direciona para a tela de login -->
				<i class="bi bi-box-arrow-in-left" style="margin-top: 10px"></i>
			</a>
		</div>
		
		<!-- Mensagem informativa para que o usuario saiba que so tera acesso ao cadastro e atualização de status caso esteja logado -->
		<h6 style="font-size: 10px; padding-top: 20px">*log in to enable admin options</h6>
	
		<!-- div com os links para as telas dos totens -->
		<div class="list-group">
		  <a class="list-group-item list-group-item-primary">Totens</a>
		  <!-- Lista com todos os Totens e suas respectivas páginas -->
		  <a href="#" class="list-group-item list-group-item-action">Hall 01</a>
		  <a href="#" class="list-group-item list-group-item-action">Hall 02</a>
		  <a href="#" class="list-group-item list-group-item-action">Departure Lounge</a>
		  <a href="#" class="list-group-item list-group-item-action">Arrivals Hall</a>
		</div>
	</div>
	

	<jsp:include page="/includes/script.html"></jsp:include>
</body>
</html>
