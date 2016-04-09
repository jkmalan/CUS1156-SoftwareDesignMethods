package com.jkmalan.Lab5.Part2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jkmalan (aka John Malandrakis)
 */
public class MailboxTest {

    private Mailbox box;

    @Before
    public void setUp() throws Exception {
        box = new Mailbox("John");
    }

    @Test
    public void testGetUser() throws Exception {
        assertEquals("John", box.getUser());
    }

    @Test
    public void testAddMessage() throws Exception {
        box.addMessage(new Message("Mark", "John", "This is a test"));
        assertFalse(box.isEmpty());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(box.isEmpty());
    }

    @Test
    public void testGetNextMessage() throws Exception {
        String expectedResult = "From: Mark\nTo: John\nThis is a test*****************\n";
        box.addMessage(new Message("Mark", "John", "This is a test"));
        assertEquals(expectedResult, box.getNextMessage().toString());
    }
}