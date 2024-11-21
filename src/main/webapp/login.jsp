<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Airport DSW1</title>
    <!-- Link para o Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
    <style>
        /* Estilo das mensagens de erro */
        .error {
            color: red;
            margin-top: 10px;
            font-weight: bold;
        }
    </style>
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center min-vh-100">

    <div class="card p-4 shadow" style="width: 100%; max-width: 400px;">
        <!-- Mensagens de erro -->
        <div class="mb-3">
            <%
                String error = request.getParameter("error");
                if ("login_required".equals(error)) {
            %>
                    <div class="alert alert-danger text-center">
                        <strong>!! You need to log in to access the system.. !!</strong>
                    </div>
            <%
                } else if ("invalid_credentials".equals(error)) {
            %>
                    <div class="alert alert-danger text-center">
                        <strong>!! Invalid username and/or password. Please try again !!</strong>
                    </div>
            <%
                }
            %>
        </div>

        <!-- Formulário de login -->
        <h3 class="text-center mb-4">Login</h3>
        <form action="login.do" method="post">
            <div class="mb-3">
                <label for="user" class="form-label">User:</label>
                <input type="text" id="user" name="username" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" id="password" name="textPassword" class="form-control" required>
            </div>
            <div class="d-grid">
                <button type="submit" class="btn btn-primary">Enter</button>
            </div>
        </form>
    </div>

</div>

<jsp:include page="/includes/script.html"></jsp:include>

<!-- Script do Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
