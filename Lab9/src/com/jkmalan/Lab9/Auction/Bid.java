package com.jkmalan.Lab9.Auction;

/**
 * Bid.java
 *
 * A bid for the auction.
 */
public class Bid {

    private String bidderName;
    private double amount;

    public Bid(String bidderName, double amount) {
        this.bidderName = bidderName;
        this.amount = amount;
    }

    public String getBidderName() {
        return bidderName;
    }

    public double getAmount() {
        return amount;
    }

    public String toString() {
        return "From  " + bidderName + " for $" + amount;
    }

}

