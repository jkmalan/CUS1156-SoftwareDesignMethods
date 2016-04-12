package com.jkmalan.Lab9.Auction;

/**
 * Bidder.java
 *
 * Bidders to the auction. They register themselves with the
 * auction so that they are notified when the state of the
 * auction has changed. (i.e. someone has put out a higher bid)
 */
import java.util.Observer;
import java.util.Random;
import java.util.Observable;

public class Bidder implements Observer {

    private BidBus bidBus;
    private Bid latestBid;
    private String name;
    private double limit;

    Boolean limitHit = false; // Unsure why this isn't private and why it's not primitive
    private Random rand = new Random();

    public Bidder(String name, BidBus bidBus) {
        setName(name);
        setBus(bidBus);
        setLimit(rand.nextDouble() * 1000.0); // Chooses a random limit per new Bidder()

        bidBus.addObserver(this);
    }

    public void display(Bid latestBid) {
        System.out.println(name + " observed the latest bid: " + latestBid);
    }

    public void update(Observable o, Object arg) {
        setLatestBid(bidBus.getBid());
        display(latestBid);
        if (latestBid.getAmount() >= limit && !limitHit) {
            limitHit = true;
            System.out.println(name + " has reached their bidding limit!");
        }
    }

    public void setLatestBid(Bid latestBid) {
        this.latestBid = latestBid;
    }

    public Bid getLatestBid() {
        return latestBid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }

    public void setBus(BidBus bidBus) {
        this.bidBus = bidBus;
    }

    public BidBus getBus() {
        return bidBus;
    }

    public boolean makeBid() {
        Boolean madeBid = false; // Unsure why this is also not primitive
        if (!limitHit) {
            if (!latestBid.getBidderName().equals(name)) {
                double amount = rand.nextDouble() * 10.0;
                bidBus.submitBid(new Bid(name, latestBid.getAmount() + amount));
                madeBid = true;
            }
        }
        return madeBid;
    }
}