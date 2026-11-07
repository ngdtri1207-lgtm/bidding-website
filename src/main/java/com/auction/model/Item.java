package com.auction.model;

public abstract class Item extends Entity{
  private static final long serialVersionUID = 1L;

  protected String name;
  protected double startingPrice;
  protected String description;
  
  public Item(String id, String name, double startingPrice, String description) {
    super(id);
    if(startingPrice <= 0) {
      throw new IllegalArgumentException("The starting price cannot be negative.");
    }
    this.name = name;
    this.startingPrice = startingPrice;
    this.description = description;
  }

  public abstract void printInfo();
  public abstract String getCategory();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getStartingPrice() {
    return startingPrice;
  }

  public void setStartingPrice(double startingPrice) {
    this.startingPrice = startingPrice;
  }
}
