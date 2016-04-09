package com.jkmalan.Project1.Version2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles all user input and output operations for the program
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class ReservationMenu {

    public void run(ReservationSystem manager) {

        Scanner input = new Scanner(System.in);

        manager.populateFlights();

        boolean exitProgram = false;
        while (!exitProgram) {
            prnt("\nWelcome! Please choose an option: \n"
                    + "F : Search flights \n"
                    + "A : Make a reservation \n"
                    + "R : Delete a reservation \n"
                    + "L : List flight roster \n"
                    + "Q : Quit");

            String option = input.nextLine();
            prnt("");

            switch (option) {
                case "F":
                case "f":
                    prnt("Enter the origin airport code: ");
                    String oCode = input.nextLine();
                    prnt("Enter the destination airport code: ");
                    String dCode = input.nextLine();
                    prnt("Enter the date (YYYY-MM-DD): ");
                    String dateOne = input.nextLine();

                    ArrayList<Flight> flights = manager.getFlightMatches(oCode, dCode, dateOne);
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
                    String lastName = input.nextLine();
                    prnt("Enter first name: ");
                    String firstName = input.nextLine();
                    prnt("Enter nationality: ");
                    String nationality = input.nextLine();
                    prnt("Enter the flight number: ");
                    String flightId = input.nextLine();
                    prnt("Enter departure date (YYYY-MM-DD): ");
                    String dateTwo = input.nextLine();

                    Passenger p = new Passenger(firstName, lastName, nationality);
                    Flight f = manager.getFlight(flightId, dateTwo);
                    boolean resultAdd = manager.addReservation(new Reservation(p, f));
                    if (resultAdd) {
                        prnt("Reservation added!");
                    } else {
                        prnt("Reservation was unable to be added!");
                    }
                    break;

                case "R":
                case "r":
                    prnt("Enter last name: ");
                    String last = input.nextLine();
                    prnt("Enter first name: ");
                    String first = input.nextLine();
                    prnt("Enter nationality: ");
                    String nation = input.nextLine();
                    prnt("Enter the flight number: ");
                    String flightNum = input.nextLine();
                    prnt("Enter departure date (YYYY-MM-DD): ");
                    String dateThree = input.nextLine();

                    Passenger pass = new Passenger(first, last, nation);
                    Flight flig = manager.getFlight(flightNum);
                    boolean resultRem = manager.remReservation(new Reservation(pass, flig));
                    if (resultRem) {
                        prnt("Reservation removed!");
                    } else {
                        prnt("Reservation was unable to be removed!");
                    }
                    break;

                case "L":
                case "l":
                    prnt("Enter the flight number: ");
                    String flightNumber = input.nextLine();
                    prnt("Enter the date (YYYY-MM-DD): ");
                    String dateFour = input.nextLine();

                    Flight flight = manager.getFlight(flightNumber, dateFour);
                    displayFlight(flight);
                    prnt("- - - - - - - - - - - - - - - - -");
                    displayRoster(flight);
                    break;

                case "Q":
                case "q":
                    prnt("Goodbye");
                    exitProgram = true;
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
        prnt("Source Airport: " + flight.getSource());
        prnt("Departure Time: " + flight.getSourceTime().toString());
        prnt("Destination Airport: " + flight.getDestination());
        prnt("Arrival Time: " + flight.getDestinationTime().toString());
    }

    /*
     * Display information on a Flight roster
     */
    public void displayRoster(Flight flight) {
        ArrayList<Passenger> pList = flight.getPassengers();
        for (Passenger p : pList) {
            prnt(p.getLastName() + ", " + p.getFirstName() + ", " + p.getNationality());
        }
    }

}
