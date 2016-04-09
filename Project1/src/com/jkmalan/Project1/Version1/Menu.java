package com.jkmalan.Project1.Version1;

import java.util.Scanner;

public class Menu {

    private ReservationManager manager = null;

    public void run(ReservationManager manager) {
        this.manager = manager;

        Scanner in = new Scanner(System.in);
        System.out.println("Please choose an option: ");
        System.out.println("F");
        System.out.println("A");
        System.out.println("R");
        System.out.println("L");
        System.out.println("Q");

        String input = in.nextLine();


        if (input.equals("F")) {
            System.out.println("Enter a flight id to search for:");
            int id = Integer.parseInt(in.nextLine());
            Flight flight = manager.getFlight(id);
        } else if (input.equals("A")) {

        }
    }




    public static void displayReservation() {

    }

    public static void listReservations() {

    }

    public static void displayFlight() {

    }

    public static void listFlights() {

    }

    public static void displayPassenger() {

    }

    public static void listPassengers() {

    }

}
