package com.jkmalan.Project2.Version3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class ReservationMenu {

    public void run(ReservationSystem manager) {

        Scanner scanner = new Scanner(System.in);

        prnt("Loading flights...");
        int flightsLoaded = manager.populateFlights();
        prnt("Loaded " + flightsLoaded + " different flights. \n");

        boolean exitProgram = false;
        while (!exitProgram) {

            prnt("Please choose an option: \n"
                    + " F : Search flights \n"
                    + " A : Make a reservation \n"
                    + " R : Delete a reservation \n"
                    + " L : List flight roster \n"
                    + " Q : Quit");

            String option = scanner.nextLine();
            prnt("");

            if (option.equalsIgnoreCase("q")) {
                prnt("Exiting program...");
                exitProgram = true;

            } else if (option.equalsIgnoreCase("f")) {
                prnt("Enter the origin airport code: ");
                String origin = scanner.nextLine();
                prnt("Enter the destination airport code: ");
                String dest = scanner.nextLine();
                prnt("Enter departure date (YYYY-MM-DD): ");
                String date = scanner.nextLine();
                prnt("");

                ArrayList<Flight> flights = manager.getFlightMatches("*", origin, dest, date);

                prnt(flights.size() + " flights found matching the criteria");
                for (Flight f : flights) {
                    prnt(f.getFlightData());
                }

            } else if (option.equalsIgnoreCase("a")) {
                prnt("Enter last name: ");
                String lastName = scanner.nextLine();
                prnt("Enter first name: ");
                String firstName = scanner.nextLine();
                prnt("Enter nationality: ");
                String nationality = scanner.nextLine();
                prnt("Enter the flight number: ");
                String flightId = scanner.nextLine();
                prnt("Enter departure date (YYYY-MM-DD): ");
                String date = scanner.nextLine();
                prnt("");

                ArrayList<Flight> flights = manager.getFlightMatches(flightId, "*", "*", date);
                Passenger p = new Passenger(firstName, lastName, nationality);

                if (flights.size() == 1) {
                    Flight f = flights.get(0);

                    if (!f.isFilled()) {
                        prnt("Flight found, would you like to choose your seat (Y/N)?");
                        String optionTwo = scanner.nextLine();

                        if (optionTwo.equalsIgnoreCase("Yes") || optionTwo.equalsIgnoreCase("Y")) {
                            prnt("Enter the row number: ");
                            String num = scanner.nextLine();
                            prnt("Enter the seat letter: ");
                            String seat = scanner.nextLine();

                            Seat s = new Seat(Integer.parseInt(num), seat);

                            if (f.getPassenger(s) == null) {
                                manager.addReservation(f, s, p);
                                prnt("Reservation added!");
                            } else {
                                prnt("Reservation was not added! This seat is already taken.");
                            }

                        } else if (optionTwo.equalsIgnoreCase("No") || optionTwo.equalsIgnoreCase("N")) {
                            Seat s = f.getSeat(null);
                            manager.addReservation(f, s, p);
                            prnt("Reservation added!");

                        } else {
                            prnt("Reservation was not added! \'" + optionTwo + "\' is not a valid response.");
                        }

                    } else {
                        prnt("Reservation was not added! This flight is completely filled.");
                    }

                } else {
                    prnt("Reservation was not added! There are too many matching flights.");
                }

            } else if (option.equalsIgnoreCase("r")) {
                prnt("Enter last name: ");
                String lastName = scanner.nextLine();
                prnt("Enter first name: ");
                String firstName = scanner.nextLine();
                prnt("Enter nationality: ");
                String nationality = scanner.nextLine();
                prnt("Enter the flight number: ");
                String flightId = scanner.nextLine();
                prnt("Enter departure date (YYYY-MM-DD): ");
                String date = scanner.nextLine();
                prnt("");

                ArrayList<Flight> flights = manager.getFlightMatches(flightId, "*", "*", date);

                if (flights.size() == 1) {
                    Flight f = flights.get(0);
                    ArrayList<Passenger> passengers = f.getPassengerMatches(firstName, lastName, nationality);

                    if (passengers.size() == 1) {
                        Passenger p = passengers.get(0);
                        manager.remReservation(f, p);
                        prnt("Reservation removed!");

                    } else {
                        prnt("Reservation was not removed! There are too many matching passengers.");
                    }

                } else {
                    prnt("Reservation was not removed! There are too many matching flights.");
                }

            } else if (option.equalsIgnoreCase("l")) {
                prnt("Enter the flight number: ");
                String flightId = scanner.nextLine();
                prnt("Enter departure date (YYYY-MM-DD): ");
                String date = scanner.nextLine();
                prnt("");

                ArrayList<Flight> flights = manager.getFlightMatches(flightId, "*", "*", date);

                if (flights.size() == 1) {
                    Flight f = flights.get(0);
                    prnt(f.getFlightData());
                    prnt(f.getFlightRoster());

                } else {
                    prnt("Flight could not be displayed! There are too many matching flights.");
                }

            } else {
                prnt("Oops, try again...");

            }

        }

        scanner.close();

        prnt("Goodbye!");

    }

    /*
     * A convenience method to send output to console
     */
    private void prnt(Object o) {
        System.out.println(o);
    }

}
