package com.jkmalan.Project1.Version2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages a list of Flights and Reservations
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class ReservationSystem {

    private ArrayList<Flight> flights = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();

    /**
     * Adds a new Reservation to the list
     *
     * @param reservation The new reservation
     * @return If successful return true, else return false
     */
    public boolean addReservation(Reservation reservation) {
        Passenger passenger = reservation.getPassenger();
        Flight flight = reservation.getFlight();
        Reservation temp = getReservation(passenger, flight);
        if (temp == null) {
            reservations.add(reservation);
            boolean result = flight.addPassenger(passenger);
            if (!result) {
                return false;
            }

            updateFlight(flight);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a Reservation from the list
     *
     * @param reservation The reservation
     * @return If successful return true, else return false
     */
    public boolean remReservation(Reservation reservation) {
        Passenger passenger = reservation.getPassenger();
        Flight flight = reservation.getFlight();
        Reservation temp = getReservation(passenger, flight);
        if (temp != null) {
            reservations.remove(temp);
            boolean result = flight.remPassenger(passenger);
            if (!result) {
                return false;
            }
            updateFlight(flight);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a Reservation from the list
     *
     * @param passenger The Passenger object
     * @param flight The Flight object
     * @return If successful return a Reservation, else return null
     */
    public Reservation getReservation(Passenger passenger, Flight flight) {
        Reservation reservation = null;
        for (Reservation r : reservations) {
            String firstName = r.getPassenger().getFirstName();
            String lastName = r.getPassenger().getLastName();
            String flightId = r.getFlight().getFlightId();
            if (flightId.equalsIgnoreCase(flight.getFlightId()) && lastName.equalsIgnoreCase(passenger.getLastName()) && firstName.equalsIgnoreCase(passenger.getFirstName())) {
                reservation = r;
            }
        }
        return reservation;
    }

    /**
     * Updates the Flight roster
     *
     * @param flight The flight to change
     */
    public void updateFlight(Flight flight) {
        for (Flight f : flights) {

            // Highly specific if clause (MUST MATCH FLIGHT!)
            if (f.getFlightId().equalsIgnoreCase(flight.getFlightId())
                    && f.getDestination().equalsIgnoreCase(flight.getDestination())
                    && f.getDestinationTime().isEqual(flight.getDestinationTime())
                    && f.getSource().equalsIgnoreCase(flight.getSource())
                    && f.getSourceTime().isEqual(flight.getSourceTime())) {

                flights.remove(f);
                flights.add(flight);
                return;
            }
        }
    }

    /**
     * Returns a single Flight from the list
     *
     * @param flightId The flight id
     * @return If successful return a Flight, else return null
     */
    public Flight getFlight(String flightId) {
        Flight flight = null;
        for (Flight f : flights) {
            if (f.getFlightId().equalsIgnoreCase(flightId)) {
                flight = f;
            }
        }
        return flight;
    }

    /**
     * Returns a single Flight from the list
     *
     * @param flightId The flight id
     * @return If successful return a Flight, else return null
     */
    public Flight getFlight(String flightId, String date) {
        Flight flight = null;
        for (Flight f : flights) {
            LocalDate lDate = buildDate(date);
            if (f.getFlightId().equalsIgnoreCase(flightId) && f.getSourceTime().toLocalDate().isEqual(lDate)) {
                flight = f;
            }
        }
        return flight;
    }

    /**
     * Returns a all Flight matches from the list
     *
     * @param oCode The origin airport
     * @param dCode The destination airport
     * @return If successful return a Flight, else return null
     */
    public ArrayList<Flight> getFlightMatches(String oCode, String dCode, String date) {
        ArrayList<Flight> flightMatches = new ArrayList<>();
        for (Flight f : flights) {
            if (f.getSource().equalsIgnoreCase(oCode) && f.getDestination().equalsIgnoreCase(dCode)) {
                LocalDate lDate = buildDate(date);
                if (f.getSourceTime().toLocalDate().isEqual(lDate)) {
                    flightMatches.add(f);
                }
            }
        }
        return flightMatches;
    }

    /**
     * Returns the number of Flights successfully loaded from file
     *
     * @return The number of Flights
     */
    public int populateFlights() {
        int count = 0;
        Scanner inFile = null;
        try {
            inFile = new Scanner(new File("Project1/Flight.txt")); // Default flight data location

            while (inFile.hasNextLine()) {
                String line = inFile.nextLine();
                Flight flight = buildFlight(line);
                flights.add(flight);

                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File containing flight data not found!");
            e.printStackTrace();
        } finally {
            if (inFile != null) {
                inFile.close();
            }
        }
        return count;
    }

    /*
     * Converts a line of comma delimited properties into a Flight object
     * Will return a new Flight object
     */
    private Flight buildFlight(String properties) {
        Scanner inLine = new Scanner(properties);
        inLine.useDelimiter(",");

        String flightId = inLine.next();
        int maxCapacity = inLine.nextInt();
        String origin = inLine.next();
        String destination = inLine.next();
        LocalDateTime arrival = buildDateTime(inLine.next());
        LocalDateTime departure = buildDateTime(inLine.next());

        return new Flight(flightId, origin, destination, arrival, departure, maxCapacity);
    }

    /*
     * Converts a line of hyphen delimited numbers into a LocalDateTime object
     * Will return a new LocalDateTime object
     */
    private LocalDateTime buildDateTime(String components) {
        Scanner inLine = new Scanner(components);
        inLine.useDelimiter("-");

        return LocalDateTime.of(inLine.nextInt(), inLine.nextInt(), inLine.nextInt(), inLine.nextInt(), inLine.nextInt());
    }

    /*
     * Converts a line of hyphen delimited numbers into a LocalDate object
     * Will return a new LocalDate object
     */
    private LocalDate buildDate(String components) {
        Scanner inLine = new Scanner(components);
        inLine.useDelimiter("-");

        return LocalDate.of(inLine.nextInt(), inLine.nextInt(), inLine.nextInt());
    }

}
