package com.jkmalan.Lab9.Auction;

import java.util.Observable;


/**
 * this is a message bus for bids
 * when a bid is submitted, it goes on the bus
 * other participants are notified and can
 * retrieve the bid from the bus
 *
 */
public class BidBus extends Observable {
	private Bid latestBid;
	
	public BidBus () { }

	/**
	 * Observers will call this to pull the latest bid.
	 */
	public Bid getBid() {
		return latestBid;
	}

	/* bidders invoke this method when they submit a bid */	
	public void submitBid(Bid latestBid) {
	
		this.latestBid = latestBid;
        display();
	
		//we must first call setChanged() to indicate
		//that the state has changed and then we
		// call notifyObservers() in the parent class
		// which notifes all observers that the state
		// has changed.
		 
		setChanged();
		notifyObservers();		
	}
	
	private void display()
	{
		System.out.println("Bid submitted: " + latestBid);
	}
}
