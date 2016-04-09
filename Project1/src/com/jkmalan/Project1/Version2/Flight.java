package com.jkmalan.Project1.Version2;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Represents a Flight containing Passengers
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class Flight {

    private ArrayList<Passenger> passengers = new ArrayList<>();

    private String flightId;
    private String source, destination;
    private LocalDateTime sourceTime, destinationTime;
    private int maxCapacity;
    private int capacityFilled;

    /**
     * Constructs a Flight object
     *
     * @param flightId The flight identifier
     * @param source The source airport
     * @param destination The destination airport
     * @param sourceTime The departure time
     * @param destinationTime The arrival time
     * @param maxCapacity The maximum passenger capacity
     */
    public Flight(String flightId, String source, String destination, LocalDateTime sourceTime, LocalDateTime destinationTime, int maxCapacity) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.sourceTime = sourceTime;
        this.destinationTime = destinationTime;
        this.maxCapacity = maxCapacity;
        this.capacityFilled = 0;
    }

    /**
     * Adds a Passenger to the Flight roster
     * Will only execute if the Passenger doesn't exist
     *
     * @param passenger The passenger to add
     * @return If successful return true, else return false
     */
    public boolean addPassenger(Passenger passenger) {
        if (isFilled()) {
            return false;
        }

        Passenger temp = getPassenger(passenger.getLastName(), passenger.getFirstName());
        if (temp == null) {
            passengers.add(passenger);
            capacityFilled += 1;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a Passenger from the Flight roster
     * Will only execute if the Passenger exists
     *
     * @param passenger The passenger to remove
     * @return If successful return true, else return false
     */
    public boolean remPassenger(Passenger passenger) {
        Passenger temp = getPassenger(passenger.getLastName(), passenger.getFirstName());
        if (temp != null) {
            passengers.remove(temp);
            capacityFilled -= 1;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a Passenger from the Flight roster
     *
     * @param lastName The last name to search
     * @param firstName The first name to search
     * @return If successful return a Passenger, else return null
     */
    public Passenger getPassenger(String lastName, String firstName) {
        Passenger passenger = null;
        for (Passenger p : passengers) {
            if (p.getLastName().equalsIgnoreCase(lastName) && p.getFirstName().equalsIgnoreCase(firstName)) {
                passenger = p;
            }
        }
        return passenger;
    }

    /**
     * Returns the Passenger list (Flight roster)
     *
     * @return The Passenger list
     */
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    /**
     * Returns the flight identifier
     *
     * @return The flight id
     */
    public String getFlightId() {
        return flightId;
    }

    /**
     * Sets the flight indentifier
     *
     * @param flightId The flight id
     */
    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    /**
     * Returns the source airport code
     *
     * @return The source airport
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the source airport code
     *
     * @param source The source airport
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Returns the destination airport code
     *
     * @return The destination airport
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets the destination airport code
     *
     * @param destination The destination airport
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Returns the date and time of departure
     *
     * @return The departure time
     */
    public LocalDateTime getSourceTime() {
        return sourceTime;
    }

    /**
     * Sets the date and time of departure
     *
     * @param sourceTime The departure time
     */
    public void setSourceTime(LocalDateTime sourceTime) {
        this.sourceTime = sourceTime;
    }

    /**
     * Returns the date and time of arrival
     *
     * @return The arrival time
     */
    public LocalDateTime getDestinationTime() {
        return destinationTime;
    }

    /**
     * Sets the date and time of arrival
     *
     * @param destinationTime The arrival time
     */
    public void setDestinationTime(LocalDateTime destinationTime) {
        this.destinationTime = destinationTime;
    }

    public boolean isFilled() {
        if (capacityFilled == maxCapacity) {
            return true;
        } else {
            return false;
        }
    }
}
