package com.jkmalan.Project2.Version1;

/**
 * Represents a Reservation composed of a Passenger and a Flight
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class Reservation {

    private Passenger passenger;
    private Flight flight;

    /**
     * Constructs a Reservation object
     *
     * @param passenger The Passenger
     * @param flight The Flight
     */
    public Reservation(Passenger passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
    }

    /**
     * Returns the Passenger
     *
     * @return The Passenger
     */
    public Passenger getPassenger() {
        return passenger;
    }

    /**
     * Sets the Passenger
     *
     * @param passenger The Passenger to set
     */
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    /**
     * Returns the Flight
     *
     * @return The Flight
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * Sets the Flight
     *
     * @param flight The Flight to set
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
