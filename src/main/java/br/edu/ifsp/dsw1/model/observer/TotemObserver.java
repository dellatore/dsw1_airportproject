package br.edu.ifsp.dsw1.model.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.flightstates.State;

public class TotemObserver implements FlightDataObserver{
	

    private List<FlightData> flights;
    private String stateFilter;

    public TotemObserver(String stateFilter) {
        this.flights = new ArrayList<>();
        this.stateFilter = stateFilter;
    }

    @Override
    public void update(FlightData flightData) {
        if (flightData.getState().getClass().getSimpleName().equals(stateFilter)) {
            flights.add(flightData);
        } else {
            flights.remove(flightData);
        }
    }

    public List<FlightData> getFilteredFlights(List<FlightData> flights) {
    
    	List<FlightData> listTotem = new ArrayList<FlightData>();
    	
    	for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i).getState().toString().equals(stateFilter)) {
				listTotem.add(flights.get(i));
			}
    	}
    	return listTotem;

    }
}
