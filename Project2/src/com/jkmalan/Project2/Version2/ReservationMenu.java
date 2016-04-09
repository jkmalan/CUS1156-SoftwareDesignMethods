package com.jkmalan.Project2.Version2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles all user scanner and output operations for the program
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class ReservationMenu {

    private ReservationSystem manager;
    private Scanner scanner;

    public void run(ReservationSystem manager) {

        this.manager = manager;
        this.scanner = new Scanner(System.in);
        
        manager.populateFlights();

        boolean exitProgram = false;
        while (!exitProgram) {
            prnt("\nWelcome! Please choose an option: \n"
                    + "F : Search flights \n"
                    + "A : Make a reservation \n"
                    + "R : Delete a reservation \n"
                    + "L : List flight roster \n"
                    + "Q : Quit");

            String option = scanner.nextLine();
            prnt("");

            switch (option) {
                case "Q":
                case "q":
                    prnt("Goodbye");
                    exitProgram = true;
                    break;

                case "F":
                case "f":
                    prnt("Enter the origin airport code: ");
                    String oCode = scanner.nextLine();
                    prnt("Enter the destination airport code: ");
                    String dCode = scanner.nextLine();
                    prnt("Enter the date (YYYY-MM-DD): ");
                    String dateOne = scanner.nextLine();

                    ArrayList<Flight> flights = manager.getFlightMatches(null, dateOne, oCode, dCode);
                    for (Flight f : flights) {
                        displayFlight(f);
                    }

                    if (flights.size() == 0) {
                        prnt("No flights matching those search keys found!");
                    }

                    break;

                case "A":
                case "a":
                    prnt("Enter last name: ");
                    String lastName = scanner.nextLine();
                    prnt("Enter first name: ");
                    String firstName = scanner.nextLine();
                    prnt("Enter nationality: ");
                    String nationality = scanner.nextLine();
                    prnt("Enter the flight number: ");
                    String flightId = scanner.nextLine();
                    prnt("Enter departure date (YYYY-MM-DD): ");
                    String dateTwo = scanner.nextLine();

                    Passenger p = new Passenger(firstName, lastName, nationality);
                    ArrayList<Flight> flightsOne = manager.getFlightMatches(flightId, dateTwo, null, null);
                    if (flightsOne.size() == 1) {
                        Flight f = flightsOne.get(0);
                        prnt("Flight found! Would you like to choose a seat (y/n)?");
                        String response = scanner.nextLine();

                        if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
                            prnt("Enter the desired seat: ");
                            String seatId = scanner.nextLine();

                            Seat s;
                            if (f.getPassenger(seatId) == null) {
                                s = f.getSeat(p);
                                prnt("Seat is empty! Creating reservation...");
                            } else {
                                s = f.getEmptySeat();
                                prnt("Seat is not empty! Empty seat has been chosen.");
                            }

                            manager.addReservation(p, s, f);
                            prnt("Reservation added!");
                        } else {
                            Seat s = f.getEmptySeat();
                            prnt("Empty seat has been chosen.");

                            manager.addReservation(p, s, f);
                        }
                    } else if (flightsOne.size() < 1) {
                        prnt("No matching flights have been found! Reservation failed.");
                    } else {
                        prnt("Multiple matching flights have been found! Reservation failed.");
                    }
                    break;

                case "R":
                case "r":
                    prnt("Enter last name: ");
                    String last = scanner.nextLine();
                    prnt("Enter first name: ");
                    String first = scanner.nextLine();
                    prnt("Enter nationality: ");
                    String nation = scanner.nextLine();
                    prnt("Enter the flight number: ");
                    String flightNum = scanner.nextLine();
                    prnt("Enter departure date (YYYY-MM-DD): ");
                    String dateThree = scanner.nextLine();

                    Passenger pass = new Passenger(first, last, nation);
                    ArrayList<Flight> flightsTwo = manager.getFlightMatches(flightNum, dateThree, null, null);
                    if (flightsTwo.size() == 1) {
                        prnt("Reservation removed!");
                    } else if (flightsTwo.size() < 1) {

                    } else {

                    }
                    break;

                case "L":
                case "l":
                    prnt("Enter the flight number: ");
                    String flightNumber = scanner.nextLine();
                    prnt("Enter the date (YYYY-MM-DD): ");
                    String dateFour = scanner.nextLine();

                    Flight flight = null;
                    displayFlight(flight);
                    prnt("- - - - - - - - - - - - - - - - -");
                    displayRoster(flight);
                    break;

                default:
                    prnt("Oops, try again");
            }

        }

    }

    /*
     * Accessible only within this class to prevent outside overuse
     * Exists to simply make life easier
     */
    private void prnt(Object o) {
        System.out.println(o);
    }

    /*
     * Display information about a Flight
     */
    private void displayFlight(Flight flight) {
        prnt("FlightID: " + flight.getFlightId());
        prnt("Source Airport: " + flight.getOrigin());
        prnt("Departure Time: " + flight.getDepartureTime().toString());
        prnt("Destination Airport: " + flight.getDestination());
        prnt("Arrival Time: " + flight.getArrivalTime().toString());
    }

    /*
     * Display information on a Flight roster
     */
    private void displayRoster(Flight flight) {
        ArrayList<Passenger> passengers = flight.getPassengerMatches(null, null, null);
        for (Passenger p : passengers) {
            prnt(p.getLastName() + ", " + p.getFirstName() + ", " + p.getNationality());
        }
    }

}
