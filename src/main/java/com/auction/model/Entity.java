package com.auction.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Entity implements Serializable{
  private static final long serialVersionUID = 1L;
  protected String id;
  protected LocalDateTime createdAt;

  public Entity(String id) {
    if(id == null || id.trim().isEmpty()) {
      throw new IllegalArgumentException("ID should not be blank");
    }
    this.id = id;
    this.createdAt = LocalDateTime.now();
  }

  public String getId() {
    return id;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
}
