package com.auction.model;

import com.auction.model.enums.AuctionStatus;
import java.time.LocalDateTime;

public class Auction extends Entity {
    private Item item;
    private double currentHighestBid;
    private String currentHighestBidderId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private AuctionStatus status;

    public Auction(String id, Item item, double startingPrice, LocalDateTime startTime, LocalDateTime endTime) {
        super(id);
        this.item = item;
        this.currentHighestBid = startingPrice;
        this.currentHighestBidderId = null;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = AuctionStatus.OPEN;
    }

    public Item getItem() { return item; }
    public double getCurrentHighestBid() { return currentHighestBid; }
    public void setCurrentHighestBid(double currentHighestBid) { this.currentHighestBid = currentHighestBid; }
    public String getCurrentHighestBidderId() { return currentHighestBidderId; }
    public void setCurrentHighestBidderId(String currentHighestBidderId) { this.currentHighestBidderId = currentHighestBidderId; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
    public AuctionStatus getStatus() { return status; }
    public void setStatus(AuctionStatus status) { this.status = status; }
}