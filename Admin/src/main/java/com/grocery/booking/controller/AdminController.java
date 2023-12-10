package com.grocery.booking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.booking.dto.GroceryItemRequest;
import com.grocery.booking.dto.InventoryRequest;
import com.grocery.booking.entity.GroceryItem;
import com.grocery.booking.service.GroceryItemService;
@RestController
@RequestMapping("/api/admin/items")

public class AdminController {

    @Autowired
    private GroceryItemService groceryItemService;


    // Endpoint for adding new grocery items
    @PostMapping
    public ResponseEntity<String> addGroceryItem(@RequestBody GroceryItemRequest request) {
        groceryItemService.addGroceryItem(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Grocery item added successfully");
    }
    
    @GetMapping
    public ResponseEntity<List<GroceryItem>> viewGroceryItems() {
        List<GroceryItem> groceryItems = groceryItemService.getAllGroceryItems();
        return ResponseEntity.ok(groceryItems);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<String> removeGroceryItem(@PathVariable Long itemId) {
        return groceryItemService.removeGroceryItem(itemId);
    }
    
    @PutMapping("/{itemId}")
    public ResponseEntity<String> updateGroceryItem(
            @PathVariable Long itemId,
            @RequestBody GroceryItemRequest request
    ) {
        return groceryItemService.updateGroceryItem(itemId, request);
    }
     
    @PatchMapping("/{itemId}/inventory")
    public ResponseEntity<String> manageInventory(
            @PathVariable Long itemId,
            @RequestBody InventoryRequest request
    ) {
        return groceryItemService.manageInventory(itemId, request);
    }
}


