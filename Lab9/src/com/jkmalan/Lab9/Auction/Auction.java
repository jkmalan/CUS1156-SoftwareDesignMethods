package com.jkmalan.Lab9.Auction;


/**
 * Auction.java
 *
 * Provide an auction whereby bidders register with the BidList.
 * Bidders may then submit bids and all bidders are notified when 
 * a bid is made.
 */

public class Auction {
 public static void main(String[] args) {
  BidBus bidBus = new BidBus();
  
  // create some bidders
  Bidder amy = new Bidder("Amy", bidBus);
  Bidder julie = new Bidder("Julie", bidBus);
  Bidder pat = new Bidder("Pat", bidBus);

  // submit some bids to the auction 
  bidBus.submitBid(new Bid(amy.getName(),150));
  
  boolean stillBidding = true;
  while (stillBidding)
  {
	  stillBidding = amy.makeBid() || julie.makeBid() || pat.makeBid();

  }
  System.out.println("Done");
 
 }
}
