package com.auction.model;

import java.util.ArrayList;
import java.util.List;

public class Seller extends User{
  private static final long serialVersionUID = 1L;
  private List<String> listedItemIds;

  public Seller(String id, String username, String password, String email) {
    super(id, username, password, email);
    this.listedItemIds = new ArrayList<>();
  }

  public void addItems(String itemId) {
    listedItemIds.add(itemId);
  }

  public List<String> getListedItemIds() {
    return listedItemIds;
  }

  @Override 
  public void getRoleDetails() {
    System.out.println("Role: Seller");
  }

  @Override 
  public String getPermissionDescription() {
    return "List products for sale, and create and manage auctions.";
  }
}
