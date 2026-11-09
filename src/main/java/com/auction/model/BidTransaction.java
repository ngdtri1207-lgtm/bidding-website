package com.auction.model;

import java.time.LocalDateTime;

public class BidTransaction extends Entity {
    private String auctionId;
    private String bidderId;
    private double bidAmount;
    private LocalDateTime timestamp;

    public BidTransaction(String id, String auctionId, String bidderId, double bidAmount) {
        super(id);
        this.auctionId = auctionId;
        this.bidderId = bidderId;
        this.bidAmount = bidAmount;
        this.timestamp = LocalDateTime.now();
    }

    public String getAuctionId() { return auctionId; }
    public String getBidderId() { return bidderId; }
    public double getBidAmount() { return bidAmount; }
    public LocalDateTime getTimestamp() { return timestamp; }
}