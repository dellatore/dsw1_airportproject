package br.edu.ifsp.dsw1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dsw1.model.entity.FlightData;

@WebServlet("/management")
public class ManagementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtém os voos da sessão
        HttpSession session = request.getSession();
        List<FlightData> flights = (List<FlightData>) session.getAttribute("flights");

        // Se não houver voos, cria uma lista vazia
        if (flights == null) {
            flights = new ArrayList<>();
        }

        // Passa a lista de voos para a página JSP
        session.setAttribute("flights", flights);
    }
}