package com.jkmalan.Lab5.Part1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jkmalan (aka John Malandrakis)
 */
public class CounterTest {

    private Counter counter;

    @Before
    public void setUp() throws Exception {
        counter = new Counter();
    }

    @Test
    public void testIncrement() throws Exception {
        int result = counter.increment();
        assertEquals(1, result);
    }

    @Test
    public void testDecrement() throws Exception {
        int result = counter.decrement();
        assertEquals(-1, result);
    }

}