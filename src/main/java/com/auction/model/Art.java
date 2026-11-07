package com.auction.model;

public class Art extends Item{
  private static final long serialVersionUID = 1L;
  private String artist;
  private int yearCreated;

  public Art(String id, String name, String description, double startingPrice, String artist, int yearCreated) {
    super(id, name, startingPrice, description);
    this.artist = artist;
    this.yearCreated = yearCreated;
  }

  @Override 
  public String getCategory() {
    return "ART";
  }

  @Override 
  public void printInfo() {
    System.out.printf("[Arts] %s - Artist: %s (%d)| Starting price: %.2f"
                      , name, artist, yearCreated, startingPrice);
  }

  public String getArtist() {
    return artist;
  }

  public int getYearCreated() {
    return yearCreated;
  }
}
