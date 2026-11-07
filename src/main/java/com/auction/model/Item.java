package com.auction.model;

public abstract class Item extends Entity{
  protected String name;
  protected double startingPrice;
  
  public Item(String id, String name, double startingPrice) {
    super(id);
    this.name = name;
    this.startingPrice = startingPrice;
  }

  public abstract void printInfo();
}
