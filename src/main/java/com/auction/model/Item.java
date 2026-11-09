package com.auction.model;

import com.auction.model.enums.ItemCondition;

public abstract class Item extends Entity {
    protected String name;
    protected String description;
    protected double startingPrice;
    protected ItemCondition condition;
    protected String sellerId;

    public Item(String id, String name, String description, double startingPrice, ItemCondition condition, String sellerId) {
        super(id);
        this.name = name;
        this.description = description;
        this.startingPrice = startingPrice;
        this.condition = condition;
        this.sellerId = sellerId;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getStartingPrice() { return startingPrice; }
    public ItemCondition getCondition() { return condition; }
    public String getSellerId() { return sellerId; }

    public abstract void printInfo();
}