package com.jkmalan.Project2.Version3;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages and accesses the Flight index
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class ReservationSystem {

    private ArrayList<Flight> flights = new ArrayList<>();

    /**
     * Adds a Passenger to a Seat on a Flight
     *
     * @param flight The target Flight
     * @param seat The target Seat
     * @param passenger The passenger
     */
    public void addReservation(Flight flight, Seat seat, Passenger passenger) {
        if (flights.contains(flight)) {
            flight.addPassenger(seat, passenger);
        }
    }

    /**
     * Removes a Passenger from a Flight
     *
     * @param flight The target Flight
     * @param passenger The passenger
     */
    public void remReservation(Flight flight, Passenger passenger) {
        if (flights.contains(flight)) {
            flight.remPassenger(passenger);
        }
    }

    /**
     * Retrieve a list of all Flights that match the criteria
     *
     * Using an asterisk '*' will match all values in the category
     * For example, getFlightMatches("*", "JFK", "*", "*") will return
     * a list of all Flights that have the origin airport "JFK",
     * regardless of what their flight ids, destinations, and dates are
     *
     * @param flightId The flight id to search
     * @param origin The origin airport to search
     * @param destination The destination airport to search
     * @param date The departure date to search
     * @return Returns a list of varying size containing all matching Flights
     */
    public ArrayList<Flight> getFlightMatches(String flightId, String origin, String destination, String date) {
        ArrayList<Flight> temp = flights;

        if (flightId != null && !flightId.equals("*")) {
            temp = getFlightsById(temp, flightId);
        }

        if (origin != null && !origin.equals("*")) {
            temp = getFlightsByOrigin(temp, origin);
        }

        if (destination != null && !destination.equals("*")) {
            temp = getFlightsByDest(temp, destination);
        }

        if (date != null && !date.equals("*")) {
            temp = getFlightsByDate(temp, date);
        }

        return temp;
    }

    /*
     * Searches the input array for Flights matching the search value
     *
     * To be used by getFlightMatches()
     */
    private ArrayList<Flight> getFlightsById(ArrayList<Flight> flights, String value) {
        ArrayList<Flight> temp = new ArrayList<>();
        for (Flight f : flights) {
            if (f.getId().equals(value)) {
                temp.add(f);
            }
        }
        return temp;
    }

    /*
     * Searches the input array for Flights matching the search value
     *
     * To be used by getFlightMatches()
     */
    private ArrayList<Flight> getFlightsByOrigin(ArrayList<Flight> flights, String value) {
        ArrayList<Flight> temp = new ArrayList<>();
        for (Flight f : flights) {
            if (f.getOrigin().equals(value)) {
                temp.add(f);
            }
        }
        return temp;
    }

    /*
     * Searches the input array for Flights matching the search value
     *
     * To be used by getFlightMatches()
     */
    private ArrayList<Flight> getFlightsByDest(ArrayList<Flight> flights, String value) {
        ArrayList<Flight> temp = new ArrayList<>();
        for (Flight f : flights) {
            if (f.getDestination().equals(value)) {
                temp.add(f);
            }
        }
        return temp;
    }

    /*
     * Searches the input array for Flights matching the search value
     *
     * To be used by getFlightMatches()
     */
    private ArrayList<Flight> getFlightsByDate(ArrayList<Flight> flights, String value) {
        ArrayList<Flight> temp = new ArrayList<>();
        for (Flight f : flights) {
            LocalDate lDate = buildDate(value);
            if (f.getDeparture().toLocalDate().isEqual(lDate)) {
                temp.add(f);
            }
        }
        return temp;
    }

    /**
     * Loads the Flights into the ArrayList
     *
     * @return Successfully loaded flights
     */
    public int populateFlights() {
        int count = 0;
        File file = new File("Project2/Flight.txt");  // Default flight data location
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Flight flight = buildFlight(line);
                flights.add(flight);
                count++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File containing flight data not found!");
            e.printStackTrace();

        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return count;
    }

    /**
     * Constructs a Flight using an input String
     *
     * @param components Input properties
     * @return The flight
     */
    public Flight buildFlight(String components) {
        Scanner scanner = new Scanner(components);
        scanner.useDelimiter(",");

        String flightId = scanner.next();
        String origin = scanner.next();
        String destination = scanner.next();
        String[] d = scanner.next().split("_");
        String[] a = scanner.next().split("_");
        int maxCapacity = scanner.nextInt();

        scanner.close();

        LocalDateTime departure = buildDateTime(d[0], d[1]);
        LocalDateTime arrival = buildDateTime(a[0], a[1]);

        return new Flight(flightId, origin, destination, departure, arrival, maxCapacity);
    }

    /**
     * Returns a LocalDateTime from String input
     *
     * @param date The date String
     * @param time The time String
     * @return The new LocalDateTime object
     */
    public LocalDateTime buildDateTime(String date, String time) {
        return buildDate(date).atTime(buildTime(time));
    }

    /**
     * Returns a LocalDate from String input
     *
     * @param dateStr The date String
     * @return The new LocalDate object
     */
    public LocalDate buildDate(String dateStr) {
        Scanner scanner = new Scanner(dateStr);
        scanner.useDelimiter("-");

        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();

        scanner.close();

        return LocalDate.of(year, month, day);
    }

    /**
     * Returns a LocalTime from String input
     *
     * @param timeStr The time String
     * @return The new LocalTime object
     */
    public LocalTime buildTime(String timeStr) {
        Scanner scanner = new Scanner(timeStr);
        scanner.useDelimiter("-");

        int hour = scanner.nextInt();
        int minute = scanner.nextInt();

        scanner.close();

        return LocalTime.of(hour, minute);
    }

}
