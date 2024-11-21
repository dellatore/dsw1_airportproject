<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="br.edu.ifsp.dsw1.model.entity.FlightData" %>  
<!DOCTYPE html>
<html>
<head>
    <title>Totem Display</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Totem - Flight Information</h1>
        <table class="table table-bordered mt-4">
            <thead class="table-primary">
                <tr>
                     <th>Flight number</th>
                    <th>Company</th>
                    <th>Arrival time</th>
                    <th>State</th>
                </tr>
            </thead>
            <tbody>
                <%
                    // Obtém a lista de voos do atributo flights
                    List<FlightData> flights = 
                        (List<FlightData>) request.getAttribute("flights");

                    if (flights != null && !flights.isEmpty()) {
                        for (FlightData flight : flights) {
                %>
                            <tr>
                                <td><%= flight.getFlightNumber() %></td>
                                <td><%= flight.getCompany() %></td>
                                <td><%= flight.getTime() %></td>
                                <td><%= flight.getState().getClass().getSimpleName() %></td>
                            </tr>
                <%
                        }
                    } else {
                %>
                        <tr>
                            <td colspan="4" class="text-center">No flights available for this state.</td>
                        </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <a href="index.jsp" class="btn btn-secondary mt-3">Back to Home</a>
    </div>
</body>
</html>
