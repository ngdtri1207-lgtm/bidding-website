package com.auction.service;

import com.auction.model.Auction;
import com.auction.model.BidTransaction;
import com.auction.model.enums.AuctionStatus;
import com.auction.model.enums.BidResponseStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuctionService {
    private List<Auction> auctions;
    private List<BidTransaction> transactions;

    public AuctionService() {
        this.auctions = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public void addAuction(Auction auction) {
        auctions.add(auction);
    }

    public List<Auction> getAllAuctions() {
        return auctions;
    }

    public Optional<Auction> findAuctionById(String auctionId) {
        return auctions.stream()
                .filter(a -> a.getId().equals(auctionId))
                .findFirst();
    }

    public BidResponseStatus placeBid(String auctionId, String bidderId, double bidAmount) {
        Optional<Auction> optionalAuction = findAuctionById(auctionId);

        if (optionalAuction.isEmpty()) {
            return BidResponseStatus.AUCTION_CLOSED;
        }

        Auction auction = optionalAuction.get();

        // Kiểm tra xem phiên đấu giá có đang mở hoặc chạy không
        if (auction.getStatus() != AuctionStatus.OPEN && auction.getStatus() != AuctionStatus.RUNNING) {
            return BidResponseStatus.AUCTION_CLOSED;
        }

        // Kiểm tra thời gian kết thúc
        if (LocalDateTime.now().isAfter(auction.getEndTime())) {
            auction.setStatus(AuctionStatus.FINISHED);
            return BidResponseStatus.AUCTION_CLOSED;
        }

        // Kiểm tra giá đặt phải lớn hơn giá cao nhất hiện tại
        if (bidAmount <= auction.getCurrentHighestBid()) {
            return BidResponseStatus.LOWER_THAN_CURRENT;
        }

        // Cập nhật mức giá cao nhất mới
        auction.setCurrentHighestBid(bidAmount);
        auction.setCurrentHighestBidderId(bidderId);

        // Lưu vết lịch sử giao dịch
        String transactionId = "TX-" + System.currentTimeMillis();
        BidTransaction transaction = new BidTransaction(transactionId, auctionId, bidderId, bidAmount);
        transactions.add(transaction);

        return BidResponseStatus.SUCCESS;
    }

    public List<BidTransaction> getTransactionsForAuction(String auctionId) {
        List<BidTransaction> result = new ArrayList<>();
        for (BidTransaction tx : transactions) {
            if (tx.getAuctionId().equals(auctionId)) {
                result.add(tx);
            }
        }
        return result;
    }
}