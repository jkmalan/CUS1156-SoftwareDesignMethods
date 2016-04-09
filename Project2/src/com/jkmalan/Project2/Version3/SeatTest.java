package com.jkmalan.Project2.Version3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Runs tests of the Seat class
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class SeatTest {

    private Seat seat;

    @Before
    public void setUp() throws Exception {
        seat = new Seat(1, "A");
    }

    @Test
    public void testGetNumber() throws Exception {
        int number = seat.getNumber();
        assertEquals(1, number);
    }

    @Test
    public void testGetLetter() throws Exception {
        String letter = seat.getLetter();
        assertEquals("A", letter);
    }

    @Test
    public void testCompareTo() throws Exception {
        Seat seatOne = new Seat(1, "A");
        Seat seatTwo = new Seat(1, "B");
        Seat seatThree = new Seat(1, "C");
        assertEquals(0, seat.compareTo(seatOne));
        assertEquals(-1, seat.compareTo(seatTwo));
        assertEquals(1, seatThree.compareTo(seat));
    }

    @Test
    public void testEquals() {
        Seat seat = new Seat(1, "A");
        assertTrue(seat.equals(this.seat));
    }
}