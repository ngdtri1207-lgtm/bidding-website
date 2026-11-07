package com.auction.controller;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.auction.model.Auction;

//// Quản lý kết nối / Auction Manager
public class AuctionManager {
  private static AuctionManager instance;

  //// Dùng ConcurrentHashMap để an toàn trong môi trường đa luồng
  private Map<String, Auction> activeAcutions;

  private AuctionManager() {
    activeAcutions = new ConcurrentHashMap<>();
  }

  public static synchronized AuctionManager getInstance() {
    if(instance == null) {
      instance = new AuctionManager();
    }
    return instance;
  }

  public void addAuction(Auction auction){
    
  }
}
