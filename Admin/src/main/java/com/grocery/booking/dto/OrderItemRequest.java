package com.grocery.booking.dto;

public class OrderItemRequest {
    private Long itemId;
    private int quantity;

    // Constructors, getters, and setters

    // Default constructor for JSON serialization
    public OrderItemRequest() {
    }

    public OrderItemRequest(Long itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    // Getters and setters

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

