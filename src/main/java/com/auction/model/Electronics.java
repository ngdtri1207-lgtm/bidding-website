package com.auction.model;

import com.auction.model.enums.ItemCondition;

public class Electronics extends Item {
    private int warrantyMonths;

    public Electronics(String id, String name, String description, double startingPrice, ItemCondition condition, String sellerId, int warrantyMonths) {
        super(id, name, description, startingPrice, condition, sellerId);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() { return warrantyMonths; }

    @Override
    public void printInfo() {
        System.out.println("[Electronics] " + name + " | Starting Price: " + startingPrice + " | Warranty: " + warrantyMonths + " months");
    }
}