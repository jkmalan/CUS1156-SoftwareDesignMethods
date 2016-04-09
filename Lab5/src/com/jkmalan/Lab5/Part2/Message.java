package com.jkmalan.Lab5.Part2;


/**
 * An email message. A message has a sender, a recipient, and text
 */
public class Message {
    private String sender;
    private String recipient;
    private String text;


    /**
     * Constructs a Message object.
     *
     * @param from the sender of the message
     */
    public Message(String from, String recip, String txt) {
        sender = from;
        text = txt;
        recipient = recip;
    }


    /**
     * Gets the recipient.
     *
     * @return the recipient
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     * Formats the email message.
     */
    public String toString() {
        return "From: " + sender + "\n" + "To: " + recipient + "\n" + text + "*****************\n";
    }
}
