package com.jkmalan.Lab5.Part2;

import java.util.ArrayList;
import java.io.PrintWriter;

/**
 * An email mailbox.
 */
public class Mailbox {
    private String user;
    private ArrayList<Message> messages;

    /**
     * Constructs a Mailbox object.
     *
     * @param person the user
     */
    public Mailbox(String person) {
        user = person;
        messages = new ArrayList<Message>();
    }

    /**
     * Gets the user.
     *
     * @return the user of this mailbox
     */
    public String getUser() {
        return user;
    }

    /**
     * Adds a message to the list.
     *
     * @param m the message to add
     */
    public void addMessage(Message m) {
        messages.add(m);
    }

    public boolean isEmpty() {
        if (messages.size() == 0)
            return true;
        else
            return false;
    }

    public Message getNextMessage() {
        Message msg = messages.remove(0);
        return msg;
    }


}
