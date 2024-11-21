package br.edu.ifsp.dsw1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;

@WebServlet("/addFlight")
public class AddFlightServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final FlightDataCollection flightCollection = new FlightDataCollection();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        	
        	 
            // Obtém os dados do voo
            String flightNumber =request.getParameter("flightNumber");
            String company = request.getParameter("company");
            String time = request.getParameter("time");
                        
            Long flightNumberLong = Long.valueOf(flightNumber);

            // Cria o voo com estado "chegando"
            FlightData flight = new FlightData(flightNumberLong, company, time);
            flight.setState(Arriving.getInstance()); // Estado inicial é "chegando"

            // Adiciona o voo à coleção
            flightCollection.insertFlight(flight);

            // Armazena a lista de voos na sessão
            HttpSession session = request.getSession();
            session.setAttribute("flights", flightCollection.getAllFligths());
            
            //System.out.print("da sessao:" + session.getAttribute("flights") + "\n");

            // Redireciona para a página de gerenciamento de voos
            response.sendRedirect("management.jsp");
            
           

        } catch (Exception e) {

        	//exibe uma mensagem de erro caso de excessao ao tentar achar um aviao
        	response.sendRedirect("management.jsp?error=error_flight"); 
        }
    }
}