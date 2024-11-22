package br.edu.ifsp.dsw1.model.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.edu.ifsp.dsw1.model.entity.FlightData;
import br.edu.ifsp.dsw1.model.flightstates.State;

public class TotemObserver implements FlightDataObserver{
	

    private List<FlightData> flights;  //lista com os voos
    private String stateFilter; //estado do voo, sera unico para cada observer

    public TotemObserver(String stateFilter) {
        this.flights = new ArrayList<>(); //inicializa a lista de voos
        this.stateFilter = stateFilter;  //pega o estado de acordo com cada variavel do servlet
    }

    @Override
    public void update(FlightData flightData) {
        if (flightData.getState().getClass().getSimpleName().equals(stateFilter)) {
            flights.add(flightData); //garante a integridade do estado
        } else {
            flights.remove(flightData);
        }
    }

    public List<FlightData> getFilteredFlights(List<FlightData> flights) {
    
    	List<FlightData> listTotem = new ArrayList<FlightData>(); //inicializa a lista a qual sera adicionada apenas os voos com estado correspondente
    	
    	for (int i = 0; i < flights.size(); i++) {
    		
    		//verifica se o estado do observer e o presente no voo da lista sao o mesmo
			if (flights.get(i).getState().toString().equals(stateFilter)) {
				listTotem.add(flights.get(i));  //adiciona o voo a lista
			}
    	}
    	return listTotem; //retorna a lista

    }
}
