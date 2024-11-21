<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    Boolean authenticated = (Boolean) session.getAttribute("isAuthenticated");
    if (authenticated == null || authenticated.equals(false)) {
        response.sendRedirect("login.jsp?error=login_required");
        return;
    }
%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Flight Registration</title>
    <!-- Link para o Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container min-vh-100 d-flex justify-content-center align-items-center">

    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title text-center">Flight Registration</h5>

            <!-- Formulário para adicionar voo -->
            <form action="addFlight" method="post">
                <div class="mb-3">
                    <label for="flightNumber" class="form-label">Flight number:</label>
                    <input type="text" id="flightNumber" name="flightNumber" class="form-control" required />
                </div>
                <div class="mb-3">
                    <label for="company" class="form-label">Company:</label>
                    <input type="text" id="company" name="company" class="form-control" required />
                </div>
                <div class="mb-3">
                    <label for="time" class="form-label">Arrival time:</label>
                    <input type="text" id="time" name="time" class="form-control" required />
                </div>
                <button type="submit" class="btn btn-primary w-100">Register Flight</button>
            </form>

            <!-- Link para gerenciar voos -->
            <br>
            <a href="management.jsp" class="btn btn-link d-block text-center mt-3">Go Back</a>
        </div>
    </div>
    
</div>

<!-- Script do Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
