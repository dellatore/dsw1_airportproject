package br.edu.ifsp.dsw1.model.flightstates;

import br.edu.ifsp.dsw1.model.entity.FlightData;

public class TakingOff implements State {
	private static volatile TakingOff instance = null;

    private TakingOff() { }

    public static TakingOff getInstance() {
        if (instance == null) {
            synchronized (TakingOff.class) {
                if (instance == null) {
                    instance = new TakingOff();
                }
            }
        }
        return instance;
    }

    @Override
    public void change(FlightData flight) {
        flight.setState(TookOff.getInstance()); // Muda para TookOff 
    }
    
    @Override
    public String toString() {
		return "TakingOff";
    	
    }
    
}
