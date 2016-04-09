package com.jkmalan.Project1.Version1b;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
* This Creates the flight class
* contains the passengersm and the flight info, such as origin, etc.
**/

public class Flight {

    private ArrayList<Passenger> passengers = new ArrayList<>();
    private String origin, destination;
    private LocalDateTime arrival, departure;
    private int flightNumber, maxCapacity;

    /**
    * This creates the Flight object
    **/
    public Flight(int flightNumber, int maxCapacity, String origin, String destination, LocalDateTime arrival, LocalDateTime departure) {
        this.flightNumber = flightNumber;
        this.maxCapacity = maxCapacity;
        this.origin = origin;
        this.destination = destination;
        this.arrival = arrival;
        this.departure = departure;
    }
    /**
    * Adds a passenger object
    **/
    public boolean addPassenger(String firstName, String lastName, String nationality) {
        if (passengers.size() == maxCapacity) {
            return false;
        } else {
            Passenger passenger = new Passenger(firstName, lastName, nationality);
            passengers.add(passenger);
            return true;
        }
    }
    
    /**
    * Deletes the passenger
    **/

    public void remPassenger(String value) {
        Passenger passenger = getPassenger(value);
        passengers.remove(passenger);
    }
    
    /**
    * Returns the passenger when called
    **/

    public Passenger getPassenger(String value) {
        Passenger passenger = null;
        for (Passenger p : passengers) {
            String firstName = p.getFirstName();
            String lastName = p.getLastName();
            if (firstName.equalsIgnoreCase(value) || lastName.equalsIgnoreCase(value)) {
                passenger = p;
            }
        }
        return passenger;
    }
    
    /**
    * Sets the flight's origin location
    **/

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    /**
    * This returns the origin
    **/
    public String getOrigin() {
        return origin;
    }
    /**
    * This sets the destination
    **/
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
    * Returns the destination
    **/
    public String getDestination() {
        return destination;
    }
    /**
    * Sets the arrival date and time
    **/
    public void setArrival(LocalDateTime dateTime) {
        this.arrival = dateTime;
    }
    /**
    * Returns the local arrival date and time
    **/
    public LocalDateTime getArrival() {
        return arrival;
    }
    /**
    * This sets the Departure date and time
    **/
    public void setDeparture(LocalDateTime dateTime) {
        this.departure = dateTime;
    }
    /**
    * This returns the local departure date and time
    **/
    public LocalDateTime getDeparture() {
        return departure;
    }
    /**
    * This sets the Flight ID
    **/
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }
    /**
    * Returns the flight number
    **/
    public int getFlightNumber() {
        return flightNumber;
    }

}
