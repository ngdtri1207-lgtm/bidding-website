package com.auction.factory;
import com.auction.model.Electronics;
import com.auction.model.Item;

public class ItemFactory {
  public static Item createItem(String type, String id, String name, double price) {
    switch (type.toLowerCase()){
      case "electronics": return new Electronics(id, name, price);
      default: throw new IllegalArgumentException("Unknown item type");
    }
  }
}
