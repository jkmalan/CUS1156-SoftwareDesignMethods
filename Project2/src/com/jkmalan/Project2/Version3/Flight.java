package com.jkmalan.Project2.Version3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Represents a Flight containing Seats and Passengers
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class Flight {

    private TreeMap<Seat, Passenger> seats = new TreeMap<>();
    private ArrayList<Passenger> passengers = new ArrayList<>();

    private String id;
    private String origin, destination;
    private LocalDateTime departure, arrival;
    private int maxCapacity, curCapacity = 0;

    /**
     * Constructs a Flight object
     *
     * @param id The flight id
     * @param origin The origin airport
     * @param destination The destination airport
     * @param departure The departure time
     * @param arrival The arrival time
     * @param maxCapacity The flight capacity
     */
    public Flight(String id, String origin, String destination, LocalDateTime departure, LocalDateTime arrival, int maxCapacity) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.departure = departure;
        this.arrival = arrival;
        this.maxCapacity = maxCapacity;

        int row = 1, seat = 10;
        while (curCapacity < maxCapacity) {
            Seat s = new Seat(row, Integer.toHexString(seat).toUpperCase());
            seats.put(s, null);

            if (seat == 15) {
                seat = 9;
                row++;
            }

            seat++;
            curCapacity++;
        }
        curCapacity = 0;
    }

    /**
     * Adds a passenger to the Flight index
     *
     * @param seat The passenger's seat
     * @param passenger The passenger
     */
    public void addPassenger(Seat seat, Passenger passenger) {
        if (seats.containsKey(seat)) {
            seats.put(seat, passenger);
            passengers.add(passenger);
            curCapacity++;
        }
    }

    /**
     * Removes a passenger from the Flight index
     *
     * @param passenger The passenger
     */
    public void remPassenger(Passenger passenger) {
        Seat seat = getSeat(passenger);
        if (seats.containsKey(seat)) {
            seats.put(seat, null);
            passengers.remove(passenger);
            curCapacity--;
        }
    }

    /**
     * Retrieve a list of all Passengers that match the criteria
     *
     * Using an asterisk '*' will match all values in the category
     * For example, getPassengerMatches("John", "*", "*") will return
     * a list of all Passengers that have the first name "John",
     * regardless of what their last names or nationalities are.
     *
     * @param firstName The first name to search
     * @param lastName The last name to search
     * @param nationality The nationality to search
     * @return Returns a list of varying size containing all matching Passengers
     */
    public ArrayList<Passenger> getPassengerMatches(String firstName, String lastName, String nationality) {
        ArrayList<Passenger> temp = passengers;

        if (firstName != null && !firstName.equals("*")) {
            temp = getPassengersByFirstName(temp, firstName);
        }

        if (lastName != null && !lastName.equals("*")) {
            temp = getPassengersByLastName(temp, lastName);
        }

        if (nationality != null && !nationality.equals("*")) {
            temp = getPassengersByNationality(temp, nationality);
        }

        return temp;
    }

    /*
     * Searches the input array for Passengers matching the search value
     *
     * To be used by getPassengerMatches()
     */
    private ArrayList<Passenger> getPassengersByFirstName(ArrayList<Passenger> passengers, String value) {
        ArrayList<Passenger> temp = new ArrayList<>();
        for (Passenger p : passengers) {
            if (p.getFirstName().equals(value)) {
                temp.add(p);
            }
        }
        return temp;
    }

    /*
     * Searches the input array for Passengers matching the search value
     *
     * To be used by getPassengerMatches()
     */
    private ArrayList<Passenger> getPassengersByLastName(ArrayList<Passenger> passengers, String value) {
        ArrayList<Passenger> temp = new ArrayList<>();
        for (Passenger p : passengers) {
            if (p.getLastName().equals(value)) {
                temp.add(p);
            }
        }
        return temp;
    }

    /*
     * Searches the input array for Passengers matching the search value
     *
     * To be used by getPassengerMatches()
     */
    private ArrayList<Passenger> getPassengersByNationality(ArrayList<Passenger> passengers, String value) {
        ArrayList<Passenger> temp = new ArrayList<>();
        for (Passenger p : passengers) {
            if (p.getNationality().equals(value)) {
                temp.add(p);
            }
        }
        return temp;
    }

    /**
     * Returns the Passenger by Seat
     *
     * @param seat The seat to find
     * @return If found returns the Passenger, else returns null
     */
    public Passenger getPassenger(Seat seat) {
        for (Seat s : seats.keySet()) {
            if (s.equals(seat)) {
                return seats.get(seat);
            }
        }
        return null;
    }

    /**
     * Returns the Seat by Passenger
     *
     * If null is used in place of Passenger input, it will return the
     * first empty seat found in the index
     *
     * @param passenger The passenger to find
     * @return If found returns the Seat, else returns null
     */
    public Seat getSeat(Passenger passenger) {
        for (Seat s : seats.keySet()) {
            Passenger p = seats.get(s);
            if (passenger == null) {
                if (p == null) {
                    return s;
                }
            } else if (p != null && passenger.equals(p)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Returns the flight identifier
     *
     * @return The flight id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the flight indentifier
     *
     * @param id The flight id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the origin airport code
     *
     * @return The origin airport
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the origin airport code
     *
     * @param origin The origin airport
     */
    public void setOrigin(String origin) {
        this.origin = origin;
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
    public LocalDateTime getDeparture() {
        return departure;
    }

    /**
     * Sets the date and time of departure
     *
     * @param departure The departure time
     */
    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    /**
     * Returns the date and time of arrival
     *
     * @return The arrival time
     */
    public LocalDateTime getArrival() {
        return arrival;
    }

    /**
     * Sets the date and time of arrival
     *
     * @param arrival The arrival time
     */
    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    /**
     * Returns the current number of filled seats
     *
     * @return The number of filled seats
     */
    public int getCurCapacity() {
        return curCapacity;
    }

    /**
     * Returns the total number of seats
     *
     * @return The total number of seats
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * Returns the Flight capacity
     *
     * @return If filled returns true, else returns false
     */
    public boolean isFilled() {
        return maxCapacity == curCapacity;
    }

    /**
     * Returns a formatted String containing Flight data
     *
     * @return Flight data
     */
    public String getFlightData() {
        String data = "- Flight " + getId() + "\n"
                + "  Departs from " + getOrigin()
                + " on " + getDeparture().toString() + "\n"
                + "  Arrives at " + getDestination()
                + " on " + getArrival().toString() + "\n"
                + "  " + getCurCapacity() + " out of "
                + getMaxCapacity() + " seats filled";
        return data;
    }

    /**
     * Returns a formatted String containing Flight roster
     *
     * @return Flight roster
     */
    public String getFlightRoster() {
        String roster = "";
        for (Seat s : seats.keySet()) {
            String pass = "empty";
            if (seats.get(s) != null) {
                Passenger temp = seats.get(s);
                pass = temp.getLastName() + ", " + temp.getFirstName() + " " + temp.getNationality();
            }
            roster += "  " + s.getNumber() + s.getLetter() + "  :  " + pass + "\n";
        }
        return roster;
    }

    @Override
    public boolean equals(Object obj) {
        Flight f = (Flight) obj;

        if (obj != null && f.getId().equals(id) && f.getOrigin().equals(origin) && f.getDestination().equals(destination)
                && f.getDeparture().equals(departure) && f.getArrival().equals(arrival) && f.getMaxCapacity() == maxCapacity) {
            return true;
        } else {
            return false;
        }
    }
}
