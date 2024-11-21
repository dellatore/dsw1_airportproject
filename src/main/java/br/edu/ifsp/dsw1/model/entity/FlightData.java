package br.edu.ifsp.dsw1.model.entity;

import br.edu.ifsp.dsw1.model.flightstates.State;

public final class FlightData {
	private final Long flightNumber;
    private final String company;
    private final String time;
    private State state;

    public FlightData(Long flightNumber, String company, String time) {
        this.flightNumber = flightNumber;
        this.company = company;
        this.time = time;
        this.state = null; // o estado sera setado manualmente
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Long getFlightNumber() {
        return flightNumber;
    }

    public String getCompany() {
        return company;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "FlightData [flightNumber=" + flightNumber +
                ", company=" + company +
                ", time=" + time +
                ", state=" + (state != null ? state.getClass().getSimpleName() : "N/A") + "]";
    }
	
	
}
