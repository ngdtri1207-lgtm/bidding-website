package com.auction.model;

public class Electronics extends Item{
  public Electronics(String id, String name, double startingPrice) {
    super(id, name, startingPrice);
  }

  @Override 
  public void printInfo() {
    System.out.println("Electronics: " + name);
  }
}
