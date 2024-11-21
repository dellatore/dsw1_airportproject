package br.edu.ifsp.dsw1.model.flightstates;

import br.edu.ifsp.dsw1.model.entity.FlightData;

public class TookOff implements State {
	private static volatile TookOff instance = null;

    private TookOff() { }

    public static TookOff getInstance() {
        if (instance == null) {
            synchronized (TookOff.class) {
                if (instance == null) {
                    instance = new TookOff();
                }
            }
        }
        return instance;
    }

    @Override
    public void change(FlightData flight) {
    	flight.setState(this); //seta esse mesmo estado ja que sera removido no updateFlights caso chegue nele
    }
}
