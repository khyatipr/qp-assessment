package com.grocery.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.grocery.booking.dto.OrderItemRequest;
import com.grocery.booking.entity.GroceryItem;
import com.grocery.booking.service.GroceryItemService;
import com.grocery.booking.service.UserOrderService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private GroceryItemService groceryItemService;

    @Autowired
    private UserOrderService userOrderService;

    // Endpoint for viewing available grocery items
    @GetMapping("/items")
    public ResponseEntity<List<GroceryItem>> viewAvailableItems() {
        List<GroceryItem> groceryItems = groceryItemService.getAllGroceryItems();
        return ResponseEntity.ok(groceryItems);
    }

    // Endpoint for booking multiple grocery items in a single order
    @PostMapping("/orders")
    public ResponseEntity<String> bookGroceryItems(@RequestBody List<OrderItemRequest> orderItems) {
        return userOrderService.bookGroceryItems(orderItems);
    }

    // Other endpoints...
}

