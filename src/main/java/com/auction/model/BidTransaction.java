package com.auction.model;

public class BidTransaction extends Entity{
  private static final long serialVersionUID = 1L;
  
  private String auctionId;
  private Bidder bidder;
  private double amount;

  public BidTransaction(String id, String auctionId, Bidder bidder, double amount) {
    super(id);
    this.auctionId = auctionId;
    this.auctionId = auctionId;
    this.bidder = bidder;
    this.amount = amount;
  }

  public String getAuctionId() {
    return auctionId;
  }

  public Bidder getBidder() {
    return bidder;
  }

  public double getAmount() {
    return amount;
  }

  @Override 
  public String toString() {
    return String.format("Bid[%s] by %s: &.2f at %s", id, bidder.getUsername(), amount, createdAt);
  }
}
