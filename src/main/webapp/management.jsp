<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="br.edu.ifsp.dsw1.model.entity.FlightData" %>    

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
    <title>Flight Management</title>
    <!-- Link para o Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .error {
            color: red;
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div class="container mt-5">

    <h2 class="text-center mb-4">Flight Management</h2>

    <!-- Mensagem de erro -->
    <%
        String error = request.getParameter("error");
        if ("error_flight".equals(error)) {
    %>
        <div class="alert alert-danger text-center error" role="alert">
            Error registering flight
        </div>
    <%
        }
    %>

    <!-- Tabela de voos -->
    <div class="table-responsive">
        <table class="table table-bordered table-striped">
            <thead class="table-light">
                <tr>
                    <th>Flight number</th>
                    <th>Company</th>
                    <th>Arrival time</th>
                    <th>State</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<FlightData> flights = (List<FlightData>) session.getAttribute("flights");
                    if (flights != null && !flights.isEmpty()) {
                        for (FlightData flight : flights) {
                %>
                    <tr>
                        <td><%= flight.getFlightNumber() %></td>
                        <td><%= flight.getCompany() %></td>
                        <td><%= flight.getTime() %></td>
                        <td><%= flight.getState().getClass().getSimpleName() %></td>
                        <td>
                            <form action="updateFlight" method="post">
                                <!-- Campo oculto para enviar o número do voo -->
                                <input type="hidden" name="flightNumber" value="<%= flight.getFlightNumber() %>">
                                <input type="hidden" name="flights" value="<%= flights %>">
                                <button type="submit" class="btn btn-warning btn-sm">Update Status</button>
                            </form>
                        </td>
                    </tr>
                <%  
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="5" class="text-center">No flights registered.</td>
                    </tr>
                <%  
                    }
                %>
            </tbody>
        </table>
    </div>

    <!-- Link para adicionar voo -->
    <div class="text-center mt-3">
        <a href="addFlight.jsp" class="btn btn-primary">Register New Flight</a>
    </div>

    <!-- Link para logout -->
    <div class="text-center mt-3">
        <a href="LogoutServlet" class="btn btn-danger">Logout</a>
    </div>

</div>

<!-- Script do Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
