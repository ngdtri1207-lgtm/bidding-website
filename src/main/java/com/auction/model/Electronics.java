package com.auction.model;

public class Electronics extends Item{
  private static final long serialVersionUID = 1L;
  private String brand;
  private int warrantyMonth;

  public Electronics(String id, String name, double startingPrice, String description, String brand, int warrantyMonth) {
    super(id, name, startingPrice, description);
    this.brand = brand;
    this.warrantyMonth = warrantyMonth;
  }

  @Override 
  public void printInfo() {
    System.out.printf("[Electronics] %s - Brand: %s | Warranty: %d months | Starting price: %.2f", 
                      name, brand, warrantyMonth, startingPrice);  
  }

  @Override 
  public String getCategory() {
    return "ELECTRONICS";
  }

  public String getBrand() {
    return brand;
  }

  public int getWarrantyMonths() {
    return warrantyMonth;
  }
}
