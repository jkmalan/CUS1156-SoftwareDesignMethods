package com.jkmalan.Project2.Version3;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Runs tests of the SystemReservation class
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class ReservationSystemTest {

    private ReservationSystem manager;

    @Before
    public void setUp() throws Exception {
        manager = new ReservationSystem();
        manager.populateFlights();
    }

    /*
     * Will not run from a relative file path, file in
     * ReservationSystem#populateFlights must be changed
     * to an absolute path for this test
     */
    @Test
    public void testAddReservation() throws Exception {
        Flight flight = manager.getFlightMatches("221", "LGA", "BA", "2016-03-06").get(0);
        Seat seat = new Seat(1, "A");
        Passenger passenger = new Passenger("John", "Malandrakis", "US");
        manager.addReservation(flight, seat, passenger);
        assertEquals(passenger, flight.getPassenger(seat));
        assertEquals(seat, flight.getSeat(passenger));
    }

    /*
     * Will not run from a relative file path, file in
     * ReservationSystem#populateFlights must be changed
     * to an absolute path for this test
     */
    @Test
    public void testRemReservation() throws Exception {
        Flight flight = manager.getFlightMatches("221", "LGA", "BA", "2016-03-06").get(0);
        Seat seat = new Seat(1, "A");
        Passenger passenger = new Passenger("John", "Malandrakis", "US");
        manager.addReservation(flight, seat, passenger);
        manager.remReservation(flight, passenger);
        assertEquals(null, flight.getPassenger(seat));
        assertEquals(null, flight.getSeat(passenger));
    }

    /*
     * Will not run from a relative file path, file in
     * ReservationSystem#populateFlights must be changed
     * to an absolute path for this test
     */
    @Test
    public void testGetFlightMatches() throws Exception {
        ArrayList<Flight> flightsOne = manager.getFlightMatches("221", "LGA", "BA", "2016-03-06");
        ArrayList<Flight> flightsTwo = new ArrayList<>();
        flightsTwo.add(new Flight("221", "LGA", "BA", manager.buildDateTime("2016-03-06", "02-00"), manager.buildDateTime("2016-03-07", "15-00"), 30));
        assertTrue(flightsOne.size() == flightsTwo.size());
        assertTrue(flightsTwo.get(0).equals(flightsOne.get(0)));
    }

    @Test
    public void testBuildDateTime() throws Exception {
        LocalDateTime dateTime = LocalDateTime.of(2016, 3, 6, 17, 00);
        assertEquals(dateTime, manager.buildDateTime("2016-03-06", "17-00"));
    }

    @Test
    public void testBuildDate() throws Exception {
        LocalDate date = LocalDate.of(2016, 3, 06);
        assertEquals(date, manager.buildDate("2016-03-06"));
    }

    @Test
    public void testBuildTime() throws Exception {
        LocalTime time = LocalTime.of(17, 00);
        assertEquals(time, manager.buildTime("17-00"));
    }

}