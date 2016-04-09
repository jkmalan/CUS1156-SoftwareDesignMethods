package com.jkmalan.Project2.Version3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Runs tests of the Passenger class
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class PassengerTest {

    private Passenger passenger;

    @Before
    public void setUp() throws Exception {
        passenger = new Passenger("John", "Malandrakis", "US");
    }

    @Test
    public void testGetFirstName() throws Exception {
        String firstName = passenger.getFirstName();
        assertEquals("John", firstName);
    }

    @Test
    public void testSetFirstName() throws Exception {
        passenger.setFirstName("Cheesus");
        assertEquals("Cheesus", passenger.getFirstName());
    }

    @Test
    public void testGetLastName() throws Exception {
        String lastName = passenger.getLastName();
        assertEquals("Malandrakis", lastName);
    }

    @Test
    public void testSetLastName() throws Exception {
        passenger.setLastName("Crust");
        assertEquals("Crust", passenger.getLastName());
    }

    @Test
    public void testGetNationality() throws Exception {
        String nationality = passenger.getNationality();
        assertEquals("US", nationality);
    }

    @Test
    public void testSetNationality() throws Exception {
        passenger.setNationality("DP");
        assertEquals("DP", passenger.getNationality());
    }

    @Test
    public void testEquals() throws Exception {
        Passenger passenger = new Passenger("John", "Malandrakis", "US");
        boolean result = passenger.equals(this.passenger);
        assertTrue(result);
    }
}