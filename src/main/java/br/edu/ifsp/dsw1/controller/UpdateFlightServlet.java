package br.edu.ifsp.dsw1.controller;

import java.io.IOException;
import java.util.List;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;
import br.edu.ifsp.dsw1.model.flightstates.Boarding;
import br.edu.ifsp.dsw1.model.flightstates.TakingOff;
import br.edu.ifsp.dsw1.model.flightstates.TookOff;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateFlight")
public class UpdateFlightServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final FlightDataCollection flightCollection = new FlightDataCollection();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	try {
            // Recupera o número do voo e a lista de cadastros enviados pelo botao
            String flightNumberParam = request.getParameter("flightNumber");
            String flights = request.getParameter("flights");
         

            
            if (flightNumberParam == null || flightNumberParam.isEmpty()) {
            	//exibe uma mensagem de erro caso de excessao ao tentar achar um aviao
            	response.sendRedirect("management.jsp?error=error_flight");
            }

            //realiza o casting 
            Long flightNumber = Long.parseLong(flightNumberParam);


            // Pega a lista da sessao para ser manipulada
            HttpSession session = request.getSession();
            List<FlightData> oldList = (List<FlightData>) session.getAttribute("flights");
            
            //chama a função updateFlight do flightCollection 
            List<FlightData> newList = flightCollection.updateFlight(flightNumber, oldList);// Supondo que você tenha esse método
            
            //pega a lista atualizada e seta ela novamente na sesssao
            session.setAttribute("flights", newList);

            // Redireciona para a página JSP
            response.sendRedirect("management.jsp");
        } catch (NumberFormatException e) {
        	
        	//exibe uma mensagem de erro caso de excessao ao tentar achar um aviao
        	response.sendRedirect("management.jsp?error=error_flight");
        } catch (Exception e) {
        	
        	//exibe uma mensagem de erro caso de excessao ao tentar achar um aviao
        	response.sendRedirect("management.jsp?error=error_flight");        }
    }
}