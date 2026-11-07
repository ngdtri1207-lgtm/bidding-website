package com.auction.model;

public class Bidder extends User{
  public Bidder(String id, String username, String password) {
    super(id, username, password);
  }

  @Override 
  public void getRoleDetails() {
    System.out.println("Role: Bidder");
  }
}
