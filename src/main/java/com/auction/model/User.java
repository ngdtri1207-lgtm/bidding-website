package com.auction.model;

public abstract class User extends Entity {
  protected String username;
  protected String password;

  public User(String id ,String username, String password) {
    super(id);
    this.username = username;
    this.password = password;
  }

  public abstract void getRoleDetails();
}


