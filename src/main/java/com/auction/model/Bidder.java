package com.auction.model;

import java.util.ArrayList;
import java.util.List;

public class Bidder extends User{
  private static final long serialVersionUID = 1L;
  private List<String> participateAuctionIds;

  public Bidder(String id, String username, String password, String email) {
    super(id, username, password, email);
    this.participateAuctionIds = new ArrayList<>();
  }

  public void addParticipatedAuction(String auctionId) {
    if(!participateAuctionIds.contains(auctionId)) {
      participateAuctionIds.add(auctionId);
    }
  }

  public List<String> getParticipatedAcutionIds() {
    return participateAuctionIds;
  }

  @Override 
  public void getRoleDetails() {
    System.out.println("Role: Bidder");
  }

  @Override 
  public String getPermissionDescription() {
    return "View auctions, place bids, and set up automated bidding";
  }
}
