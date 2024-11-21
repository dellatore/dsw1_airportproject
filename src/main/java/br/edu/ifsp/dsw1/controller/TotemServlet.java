package br.edu.ifsp.dsw1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.entity.FlightDataCollection;
import br.edu.ifsp.dsw1.model.flightstates.Arriving;
import br.edu.ifsp.dsw1.model.flightstates.Boarding;
import br.edu.ifsp.dsw1.model.flightstates.TakingOff;
import br.edu.ifsp.dsw1.model.flightstates.TookOff;
import br.edu.ifsp.dsw1.model.observer.TotemObserver;

/**
 * Servlet implementation class TotemServlet
 */
@WebServlet("/totem")
public class TotemServlet extends HttpServlet {

	    private static final FlightDataCollection flightCollection = new FlightDataCollection();

	    // Observadores para cada estado
	    private static final  TotemObserver hall1Observer = new TotemObserver("TakingOff");
	    private  static final TotemObserver hall2Observer = new TotemObserver("TookOff");
	    private static final TotemObserver departureLoungeObserver = new TotemObserver("Boarding");
	    private  static final TotemObserver arrivalsTotemObserver = new TotemObserver("Arriving");

	    static {
	        flightCollection.register(hall1Observer);
	        flightCollection.register(hall2Observer);
	        flightCollection.register(departureLoungeObserver);
	        flightCollection.register(arrivalsTotemObserver);
	    }

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String totem = request.getParameter("totem");
	        
	        HttpSession session = request.getSession();
	        System.out.print( session.getAttribute("flights"));

	        List<FlightData> flights = (List<FlightData>) session.getAttribute("flights");
	        switch (totem) {
	            case "hall1":
	                flights = hall1Observer.getFilteredFlights(flights);
	                break;
	            case "hall2":
	                flights = hall2Observer.getFilteredFlights(flights);
	                break;
	            case "departureLounge":
	                flights = departureLoungeObserver.getFilteredFlights(flights);
	                break;
	            case "arrivalsHall":
	                flights = arrivalsTotemObserver.getFilteredFlights(flights);
	                break;
	            default:
	                flights = List.of();
	        }

	        request.setAttribute("flights", flights);
	        request.getRequestDispatcher("/totem.jsp").forward(request, response);
	    }
	}
