package com.jkmalan.Lab5.Part2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jkmalan (aka John Malandrakis)
 */
public class MessageTest {

    private String msgStr;
    private String sender;
    private String recip;
    private Message msg;

    @Before
    public void setUp() throws Exception {
        msgStr = "Test Message";
        sender = "Mark";
        recip = "Frank";
        msg = new Message(sender, recip, msgStr);
    }

    @Test
    public void testGetRecipient() throws Exception {
        assertEquals("Frank", msg.getRecipient());
    }

    @Test
    public void testToString() throws Exception {
        String expectedResult = "From: Mark\nTo: Frank\nTest Message*****************\n";
        assertEquals(expectedResult, msg.toString());
    }
}