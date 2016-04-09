package com.jkmalan.Project2.Version2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages reservations and flights
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class ReservationSystem {

    private ArrayList<Flight> flights = new ArrayList<>();

    public void addReservation(Passenger passenger, Seat seat, Flight flight) {

    }

    public void remReservation(Passenger passenger, Seat seat, Flight flight) {

    }

    public ArrayList<Flight> getFlightMatches(String flightId, String date, String origin, String dest) {
        ArrayList<Flight> temp = flights;
        if (flightId != null) {
            temp = getFlightsById(temp, flightId);
        }

        if (date != null) {
            temp = getFlightsByDate(temp, date);
        }

        if (origin != null) {
            temp = getFlightsByOrigin(temp, origin);
        }

        if (dest != null) {
            temp = getFlightsByDest(temp, dest);
        }
        return temp;
    }

    public ArrayList<Flight> getFlightsById(ArrayList<Flight> flights, String value) {
        ArrayList<Flight> temp = new ArrayList<>();
        for (Flight f : flights) {
            if (f.getFlightId().equals(value)) {
                temp.add(f);
            }
        }
        return temp;
    }

    public ArrayList<Flight> getFlightsByDate(ArrayList<Flight> flights, String value) {
        ArrayList<Flight> temp = new ArrayList<>();
        for (Flight f : flights) {
            LocalDate lDate = buildDate(value);
            if (f.getDepartureTime().toLocalDate().isEqual(lDate)) {
                temp.add(f);
            }
        }
        return temp;
    }

    public ArrayList<Flight> getFlightsByOrigin(ArrayList<Flight> flights, String value) {
        ArrayList<Flight> temp = new ArrayList<>();
        for (Flight f : flights) {
            if (f.getOrigin().equals(value)) {
                temp.add(f);
            }
        }
        return temp;
    }

    public ArrayList<Flight> getFlightsByDest(ArrayList<Flight> flights, String value) {
        ArrayList<Flight> temp = new ArrayList<>();
        for (Flight f : flights) {
            if (f.getDestination().equals(value)) {
                temp.add(f);
            }
        }
        return temp;
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
