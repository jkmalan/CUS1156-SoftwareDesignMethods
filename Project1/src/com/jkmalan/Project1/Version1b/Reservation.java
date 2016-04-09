package com.jkmalan.Project1.Version1b;
/**
* Creates the reservation object
* Holds passenger and flight
**/
public class Reservation {

    private Passenger passenger;
    private Flight flight;
    /**
    * Constructor to hold passenger and flight
    **/
    public Reservation(Passenger passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
    }
    /**
    * Sets the flight object
    **/
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    /**
    * Gets the flight object
    **/
    public Flight getFlight() {
        return flight;
    }
    /**
    * Sets the passenger object
    **/
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
    /**
    * Gets the passenger object
    **/
    public Passenger getPassenger() {
        return passenger;
    }
}
