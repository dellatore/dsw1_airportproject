package br.edu.ifsp.dsw1.model.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import br.edu.ifsp.dsw1.model.flightstates.TakingOff;
import br.edu.ifsp.dsw1.model.flightstates.TookOff;
import br.edu.ifsp.dsw1.model.observer.FlightDataObserver;
import br.edu.ifsp.dsw1.model.observer.FlightDataSubject;

public class FlightDataCollection implements FlightDataSubject {

    private List<FlightData> flights;
    private List<FlightDataObserver> observers;
    private FlightData lastUpdated;

    public FlightDataCollection() {
        this.flights = new LinkedList<FlightData>();  // Lista interna para armazenar os voos
        this.observers = new LinkedList<FlightDataObserver>();  // Lista de observadores
    }

    @Override
    public void register(FlightDataObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(FlightDataObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.stream().forEach(observer -> observer.update(lastUpdated)); 
    }

    public void insertFlight(FlightData flight) {
        if (flight != null) {
            lastUpdated = flight; //seta a variavel do observer
            flights.add(flight);  // Adiciona o voo à lista
            notifyObservers(); //notifica os observers da mudanca
        }
    }

    public List<FlightData> updateFlight(Long flightNumber, List<FlightData> oldlist) {

    	FlightData changed = null; //cria um novo aviao
    	
    	for (int i = 0; i < oldlist.size(); i++) {
    		//verifica se o numero desse aviao esta na lista
			if (oldlist.get(i).getFlightNumber().equals(flightNumber)) {
				changed = oldlist.get(i); //seta o aviao achado na lista para o changed
	            oldlist.remove(i); //remove o aviao da lista
				changed.getState().change(changed); //altera o estado do aviao 
				if (changed.getState() instanceof TookOff) {
	                return oldlist; // se chegar no TookOff ele remove permanente da lista
	            }
				lastUpdated = changed; // seta a variavel do observer
				oldlist.add(changed); //adiciona novamente a lista
			}
		}
    	
   
    	notifyObservers(); //notifica os observadores
    	return oldlist; // retorna a lista que sera novamente salva na sess
    	
    }

    public List<FlightData> getAllFligths() {
        return new ArrayList<>(flights);  // Retorna uma cópia da lista de voos
    }

    private FlightData findByNumber(Long flightNumber) {
//        return flights.stream()
//                .filter(flight -> flight.getFlightNumber() == (flightNumber))
//                .findFirst()
//                .orElse(null);  // Retorna null se não encontrar o voo
    	for (int i = 0; i < getAllFligths().size(); i++) {
    		
			if (flights.get(i).getFlightNumber().equals(flightNumber)) {
				return flights.get(i);
			}
		}
    	
    	return null;
    	
    }
}

