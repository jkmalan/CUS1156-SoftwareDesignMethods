package com.jkmalan.Project1.Version1;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Flight {

    private ArrayList<Passenger> passengers = new ArrayList<>();
    private String origin, destination;
    private LocalDateTime arrival, departure;
    private int flightNumber, maxCapacity;

    public Flight(int flightNumber, int maxCapacity, String origin, String destination, LocalDateTime arrival, LocalDateTime departure) {
        this.flightNumber = flightNumber;
        this.maxCapacity = maxCapacity;
        this.origin = origin;
        this.destination = destination;
        this.arrival = arrival;
        this.departure = departure;
    }

    public boolean addPassenger(String firstName, String lastName, String nationality) {
        if (passengers.size() == maxCapacity) {
            return false;
        } else {
            Passenger passenger = new Passenger(firstName, lastName, nationality);
            passengers.add(passenger);
            return true;
        }
    }

    public void remPassenger(String value) {
        Passenger passenger = getPassenger(value);
        passengers.remove(passenger);
    }

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

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setArrival(LocalDateTime dateTime) {
        this.arrival = dateTime;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setDeparture(LocalDateTime dateTime) {
        this.departure = dateTime;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

}
