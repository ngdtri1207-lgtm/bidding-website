package com.auction.model;

public abstract class User extends Entity {
  private static final long serialVersionUID = 1L;

  protected String username;
  protected String password;
  protected String email;

  public User(String id ,String username, String password, String email) {
    super(id);
    this.username = username;
    this.password = password;
    this.email = email;
  }

  public boolean authenticate(String inputPassword) {
    return this.password != null && this.password.equals(inputPassword);
  }

  public abstract void getRoleDetails();
  public abstract String getPermissionDescription();

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}


