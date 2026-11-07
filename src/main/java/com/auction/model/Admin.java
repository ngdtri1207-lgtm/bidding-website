package com.auction.model;

public class Admin extends User{
  private static final long serialVersionUID = 1L;

  public Admin(String id, String username, String password, String email) {
    super(id, username, password, email);
  }

  @Override 
  public void getRoleDetails() {
    System.out.println("Role: Admin");
  }

  @Override 
  public String getPermissionDescription() {
    return "System-wide administration, user moderation, and termination of non-compliant sessions.";
  }
}

