package com.jkmalan.Project1.Version1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class ReservationManager {

    private ArrayList<Reservation> reservations = new ArrayList<>();
    private ArrayList<Flight> flights = new ArrayList<>();

    public void addReservation(Passenger passenger, Flight flight) {
        Reservation reservation = new Reservation(passenger, flight);
        reservations.add(reservation);
    }

    public void remReservation(String value) {
        Reservation reservation = getReservation(value);
        reservations.remove(reservation);
    }

    public Reservation getReservation(String value) {
        Reservation reservation = null;
        for (Reservation r : reservations) {
            String firstName = r.getPassenger().getFirstName();
            String lastName = r.getPassenger().getLastName();
            if (firstName.equalsIgnoreCase(value) || lastName.equalsIgnoreCase(value)) {
                reservation = r;
            }
        }
        return reservation;
    }

    public Flight getFlight(int value) {
        Flight flight = null;
        for (Flight f : flights) {
            int flightNumber = f.getFlightNumber();
            if (flightNumber == value) {
                flight = f;
            }
        }
        return flight;
    }

    public ArrayList<Flight> getFlightList() {
        return flights;
    }

    private void populateFlights() {
        Scanner inFile = new Scanner("Project1/flights.txt");
        while (inFile.hasNextLine()) {
            String line = inFile.nextLine();
            Flight flight = processLine(line);

        }
    }

    private Flight processLine(String line) {
        Flight flight = null;

        return flight;
    }

}
