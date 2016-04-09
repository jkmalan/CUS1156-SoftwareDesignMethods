package com.jkmalan.Project1.Version1b;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Holds the manager
 * Enter Letter for next step
 **/
public class ReservationMenu {

    private ReservationSystem manager = null;

    private ArrayList<Passenger> roster = new ArrayList<Passenger>();

    /**
     * Adds a passenger object to the roster
     **/
    public void add(Passenger passen) {
        roster.add(passen);
    }

    /**
     * Runs the system manager
     **/
    public void run(ReservationSystem manager) {
        this.manager = manager;
        manager.populateFlights();

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a command"
                + "\nF: find flights,"
                + "\nA: make a reservation"
                + "\nR: delete reservation"
                + "\nL:list flight roster"
                + "\nQ: quit");

        String option = in.nextLine();

        if (option.equals("F")) {
            System.out.println("Enter a flight id to search for:");
            int id = Integer.parseInt(in.nextLine());
            Flight flight = manager.getFlight(id);
            if (flight != null) {

                System.out.println("Flight ID: " + flight.getFlightNumber());
                System.out.println("Origin: " + flight.getOrigin());
                System.out.println("Destination: " + flight.getDestination());
                System.out.println("Arrival Time: " + flight.getArrival());
                System.out.println("Departure Time: " + flight.getDeparture().toString());
            }
        } else if (option.equals("A")) {
            System.out.println("Enter last name");
            String lastname = in.nextLine();
            System.out.println("Enter first name");
            String firstname = in.nextLine();
            System.out.println("Enter nationality");
            String Nationality = in.nextLine();
            System.out.println("Enter flight code");
            String flightcode = in.nextLine();
            System.out.println("Enter departure date using yyyy-mm-dd format");
            String departuredate = in.nextLine();
            System.out.println("reservation succeeded");
        } else if (option.equals("L")) {
            System.out.println("Enter the flight number");
            String flightnumber = in.nextLine();
            int flightnum = Integer.parseInt(flightnumber);
            Flight flight = manager.getFlight(flightnum);
            System.out.println("Flight ID: " + flight.getFlightNumber());
            System.out.println("Origin: " + flight.getOrigin());
            System.out.println("Destination: " + flight.getDestination());
            System.out.println("Arrival Time: " + flight.getArrival().toString());
            System.out.println("Departure Time: " + flight.getDeparture().toString());
        } else if (option.equals("Q")) {
            System.out.println("System quit");
            System.exit(0);
        } else {
            System.out.println("Try again with given options");
        }
    }


}


