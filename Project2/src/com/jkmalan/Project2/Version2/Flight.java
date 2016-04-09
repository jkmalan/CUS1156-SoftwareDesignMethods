package com.jkmalan.Project2.Version2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Represents a Flight
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class Flight {

    private TreeMap<Seat, Passenger> seats = new TreeMap<>();
    private ArrayList<Passenger> passengers = new ArrayList<>();

    private String flightId;
    private String origin, destination;
    private LocalDateTime departureTime, arrivalTime;
    private int curCapacity, maxCapacity;

    public Flight(String flightId, String origin, String dest, LocalDateTime dTime, LocalDateTime aTime, int capacity) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = dest;
        this.departureTime = dTime;
        this.arrivalTime = aTime;
        this.maxCapacity = capacity;
        curCapacity = 0;

        int num = 0, row = 0;
        while (num < maxCapacity) {
            if (row > 5) {
                row = 0;
            }

            Seat seat = new Seat(Integer.toHexString(row) + num);
            seats.put(seat, null);
            row++;
            num++;
        }
    }

    public Seat getEmptySeat() {
        for (Seat s : seats.keySet()) {
            if (seats.get(s) == null) {
                return s;
            }
        }
        return null;
    }

    public Seat getSeat(Passenger passenger) {
        Seat seat = null;
        for (Seat s : seats.keySet()) {
            if (seats.get(s).equals(passenger)) {
                seat = s;
            }
        }
        return seat;
    }

    public void addPassenger(Passenger passenger, String seatId) {
        if (isFilled()) {
            return;
        }

        if (passenger != null) {
            for (Seat s : seats.keySet()) {
                if (s.getId().equals(seatId)) {
                    passengers.add(seats.get(s));
                    seats.put(s, passenger);
                    curCapacity += 1;
                }
            }
        }
    }

    public void remPassenger(String seatId) {
        for (Seat s : seats.keySet()) {
            if (s.getId().equals(seatId)) {
                passengers.remove(seats.get(s));
                seats.put(s, null);
                curCapacity -= 1;
            }
        }
    }

    public void remPassenger(Passenger passenger) {
        if (passenger == null) {
            return;
        }

        if (passengers.contains(passenger)) {
            passengers.remove(passenger);
        }
    }

    public Passenger getPassenger(String seat) {
        Passenger temp = null;
        for (Seat s : seats.keySet()) {
            if (s.getId().equals(seat)) {
                temp = seats.get(s);
            }
        }
        return temp;
    }

    public ArrayList<Passenger> getPassengerMatches(String firstName, String lastName, String nationality) {
        ArrayList<Passenger> temp = passengers;
        if (firstName != null) {
            temp = getPassengersByFirstName(temp, firstName);
        }

        if (lastName != null) {
            temp = getPassengersByLastName(temp, lastName);
        }

        if (nationality != null) {
            temp = getPassengersByNationality(temp, nationality);
        }
        return temp;
    }

    public ArrayList<Passenger> getPassengersByFirstName(ArrayList<Passenger> passengers, String value) {
        ArrayList<Passenger> temp = new ArrayList<>();
        for (Passenger p : passengers) {
            if (p.getFirstName().equals(value)) {
                temp.add(p);
            }
        }
        return temp;
    }

    public ArrayList<Passenger> getPassengersByLastName(ArrayList<Passenger> passengers, String value) {
        ArrayList<Passenger> temp = new ArrayList<>();
        for (Passenger p : passengers) {
            if (p.getLastName().equals(value)) {
                temp.add(p);
            }
        }
        return temp;
    }

    public ArrayList<Passenger> getPassengersByNationality(ArrayList<Passenger> passengers, String value) {
        ArrayList<Passenger> temp = new ArrayList<>();
        for (Passenger p : passengers) {
            if (p.getNationality().equals(value)) {
                temp.add(p);
            }
        }
        return temp;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public boolean isFilled() {
        return curCapacity == maxCapacity;
    }
}
