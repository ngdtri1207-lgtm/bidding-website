package com.auction.model;

public class Seller extends User{
  public Seller(String id, String username, String password) {
    super(id, username, password);
  }

  @Override 
  public void getRoleDetails() {
    System.out.println("Role: Seller");
  }
}
