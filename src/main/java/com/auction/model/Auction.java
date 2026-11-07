package com.auction.model;
import java.util.concurrent.locks.ReentrantLock;

import com.auction.exception.InvalidBidException;

public class Auction {
  private String auctionId;
  private Item item;
  private double currentHighestBid;
  private Bidder currentWinner;
  private String status;

  private final ReentrantLock lock = new ReentrantLock();

  public Auction(String auctionId, Item item) {
    this.auctionId = auctionId;
    this.item = item;
    this.currentHighestBid = item.startingPrice;
    this.status = "OPEN";
  }

  //xu ly ngoai le 
  public void placeBid(Bidder bidder, double bidAmount) throws InvalidBidException {
    lock.lock();
    try {
      if(!status.equals("RUNNING")) {
        throw new InvalidBidException("The auction has not yet opened or has already ended.");
      }
      if(bidAmount <= currentHighestBid) {
        throw new InvalidBidException("The order price must be higher than the current price!");
      }

      //Cập nhật người dẫn đầu
      this.currentHighestBid = bidAmount;
      this.currentWinner = bidder;

      System.out.println("Bidder " + bidder.getId() + " set price " + bidAmount + " successfully.");
      // TODO: Gọi Observer Pattern notify các Client ở đây

    } finally {
      lock.unlock();
    }
  }
}
