package com.grocery.booking.dto;

public class InventoryRequest {
    private int quantity;

    // Constructors, getters, and setters

    // Default constructor for JSON serialization
    public InventoryRequest() {
    }

    public InventoryRequest(int quantity) {
        this.quantity = quantity;
    }

    // Getters and setters

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

