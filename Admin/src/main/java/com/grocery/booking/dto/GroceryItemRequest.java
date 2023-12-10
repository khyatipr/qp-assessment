package com.grocery.booking.dto;



public class GroceryItemRequest {
    private String name;
    private Double price;
    private Integer quantity;

    // Constructors, getters, and setters

    // Default constructor for JSON serialization
    public GroceryItemRequest() {
    }

    public GroceryItemRequest(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
