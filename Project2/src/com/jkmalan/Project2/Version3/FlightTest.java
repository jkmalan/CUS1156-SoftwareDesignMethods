package com.jkmalan.Project2.Version3;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Runs tests of the Flight class
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class FlightTest {

    private Flight flight;

    @Before
    public void setUp() throws Exception {
        LocalDateTime depart = LocalDateTime.of(2016, 3, 6, 17, 0);
        LocalDateTime arrival = LocalDateTime.of(2016, 3, 6, 23, 0);
        flight = new Flight("221", "JFK", "BOS", depart, arrival, 30);
    }

    @Test
    public void testAddPassenger() throws Exception {
        Seat seat = new Seat(1, "A");
        Passenger passenger = new Passenger("John", "Malandrakis", "US");
        flight.addPassenger(seat, passenger);
        assertEquals(passenger, flight.getPassenger(seat));
    }

    @Test
    public void testRemPassenger() throws Exception {
        Seat seat = new Seat(1, "A");
        Passenger passenger = new Passenger("John", "Malandrakis", "US");
        flight.addPassenger(seat, passenger);
        flight.remPassenger(passenger);
        assertEquals(null, flight.getPassenger(seat));
    }

    @Test
    public void testGetPassengerMatches() throws Exception {
        Seat seatOne = new Seat(1, "A");
        Passenger passengerOne = new Passenger("John", "Malandrakis", "US");
        Seat seatTwo = new Seat(1, "A");
        Passenger passengerTwo = new Passenger("Mark", "Johnson", "US");
        ArrayList<Passenger> passengers = new ArrayList<>();
        passengers.add(passengerTwo);
        flight.addPassenger(seatOne, passengerOne);
        flight.addPassenger(seatTwo, passengerTwo);
        assertEquals(passengers, flight.getPassengerMatches("*", "Johnson", "*"));
    }

    @Test
    public void testGetPassenger() throws Exception {
        Seat seat = new Seat(1, "A");
        Passenger passenger = new Passenger("John", "Malandrakis", "US");
        flight.addPassenger(seat, passenger);
        assertEquals(passenger, flight.getPassenger(seat));
    }

    @Test
    public void testGetSeat() throws Exception {
        Seat seat = new Seat(1, "A");
        Passenger passenger = new Passenger("John", "Malandrakis", "US");
        flight.addPassenger(seat, passenger);
        assertTrue(seat.equals(flight.getSeat(passenger)));
    }

}