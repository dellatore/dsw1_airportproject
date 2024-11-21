<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="br.edu.ifsp.dsw1.model.entity.FlightData" %>    


 <%
	    Boolean autenticado = (Boolean) session.getAttribute("isAuthenticated");
	    if (autenticado == null || autenticado.equals("false")) {
	        response.sendRedirect("login.jsp?error=login_required");
	        return;
	    }
	%>

<!DOCTYPE html>
<html>
<head>

	<style> 
	<!-- estilo das mensagens de erro-->
        .error {
            color: red;
            margin-top: 10px;
        }
    </style>
    <title>Flight Management</title>
</head>
<body>

<h2>Flight Management</h2>

		<%
            String error = request.getParameter("error");
            if ("error_flight".equals(error)) {
        %>
                <p class="error">Error registering flight</p>
        <%
            } 
        %>
         

<!-- tabela com os dados do voo -->
<table border="1">
    <thead>
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
            // Recupera a lista de voos da sessão
            List<FlightData> flights = (List<FlightData>) session.getAttribute("flights");
        

            // Verifica se a lista de voos não é nula e tem voos
            if (flights != null && !flights.isEmpty()) {
                // Itera sobre os voos
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
				        <button type="submit">Update Status</button>
				    </form>
                </td>
            </tr>
        <%  
                }
            } else {
        %>
            <tr>
                <td colspan="5">No flights registered.</td>
            </tr>
        <%  
            }
        %>
    </tbody>
</table>

<!-- Link para adicionar voo -->
<br>
<a href="addFlight.jsp">Register New Flight</a>

</body>
</html>