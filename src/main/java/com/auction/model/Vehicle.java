package com.auction.model;

public class Vehicle extends Item{
  private static final long serialVersionUID = 1L;
  private String model;
  private int mileage;

  public Vehicle(String id, String name, String description, double startingPrice, String model, int mileage) {
    super(id, name, startingPrice, description);
    this.model = model;
    this.mileage = mileage;
  }

  @Override 
  public String getCategory() {
    return "VEHICLE";
  }

  @Override 
  public void printInfo() {
    System.out.printf("[VEHICLE] %s - Model: %s | ODO: %d | Starting price: %.2f"
                      ,name, model, mileage, startingPrice );
  }

  public String getModel() {
    return model;
  }

  public int getMileage() {
    return mileage;
  }
}
