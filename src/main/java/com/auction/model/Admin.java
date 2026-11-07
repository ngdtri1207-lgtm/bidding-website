package com.auction.model;

public class Admin extends User{
  public Admin(String id, String username, String password) {
    super(id, username, password);
  }
  
  @Override 
  public void getRoleDetails() {
    System.out.println("Role: Admin");
  }
}
