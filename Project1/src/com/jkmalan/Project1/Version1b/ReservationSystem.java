package com.jkmalan.Project1.Version1b;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
* Creates arraylists to hold reservations and flights
* Populates flights and takes in flight information from text
**/
public class ReservationSystem {

    private ArrayList<Reservation> reservations = new ArrayList<>();
    private ArrayList<Flight> flights = new ArrayList<>();
    /**
    * Adds a reservation
    **/
    public void addReservation(Passenger passenger, Flight flight) {
        Reservation reservation = new Reservation(passenger, flight);
        reservations.add(reservation);
    }
    /**
    * Deletes the reservation
    **/
    public void remReservation(String value) {
        Reservation reservation = getReservation(value);
        reservations.remove(reservation);
    }
    /**
    * Creates the reservation 
    **/
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
    /**
    * returns the flight from arraylist
    **/
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
    /**
    * returns flights from flightlist
    **/
    public ArrayList<Flight> getFlightList() {
        return flights;
    }

    // Load test flights from file
    public void populateFlights() {
    	Scanner fileIn;
		try {
			fileIn = new Scanner(new File("Project1/Flight.txt"));
			 while (fileIn.hasNextLine()) {
		            String line = fileIn.nextLine();
		            Flight flight = processLine(line);
		            flights.add(flight);
			 }
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			System.out.println("Error: Flight info file not found");

			e.printStackTrace();
			
		
       
        } }
        
	private Flight processLine(String line) {

	    Scanner input = new Scanner(line);
	    input.useDelimiter(",");
	    
	    int flightID = input.nextInt();
	    
	    int maxCapacity = input.nextInt();
	    String origin = input.next();
	    String destination = input.next();
	    LocalDateTime arrival = processDateString(input.next());
	    LocalDateTime departure = processDateString(input.next());

	    return new Flight(flightID, maxCapacity, origin, destination, arrival, departure);
	}

	private LocalDateTime processDateString(String dateString) {
	    Scanner input = new Scanner(dateString);
	    input.useDelimiter("-");
	    LocalDateTime dateTime = LocalDateTime.of(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt());
	    return dateTime;
	}
}


          /*  String[] fields = line.split(",");
            int flightNumber = Integer.parseInt(fields[0]);
            int maxCapacity = Integer.parseInt(fields[1]);
            String origin = fields[2];
            String destination = fields[3];
            String[] dt = fields[4].split("-");
            LocalDateTime dtArrival = LocalDateTime.of(Integer.parseInt(dt[0]), Integer.parseInt(dt[1]), Integer.parseInt(dt[2]), Integer.parseInt(dt[3]), Integer.parseInt(dt[4]));
            // LocalDateTime destination
            // Flight flight    */
    

