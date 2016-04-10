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
	Boolean limitHit = false;
	private Random rand = new Random();



	public void display(Bid latestBid) {
		System.out.println(name + " observed the latest bid :" + latestBid);
	}


	public Bid getLatestBid() {
		return latestBid;
	}

	public String getName() {
		return name;
	}

	public boolean makeBid()
	{
     Boolean madeBid = false;
	 if (!limitHit)
		{
	    	if (!latestBid.getBidderName().equals(name))
	    	{
	 		{
     	    	double amount = rand.nextDouble() * 10.0;
	        	bidBus.submitBid(new Bid(name, latestBid.getAmount() + amount));
	        	madeBid=true;
	    		}

		}
	 return madeBid;
	}
}
