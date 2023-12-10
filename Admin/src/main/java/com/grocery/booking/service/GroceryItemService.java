package com.grocery.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.grocery.booking.dto.GroceryItemRequest;
import com.grocery.booking.dto.InventoryRequest;
import com.grocery.booking.entity.GroceryItem;
import com.grocery.booking.repository.GroceryItemRepository;

@Service
public class GroceryItemService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    // Service method to add a new grocery item
    public void addGroceryItem(GroceryItemRequest request) {
        // Business logic, validation, etc. can be added here
        GroceryItem newItem = new GroceryItem(request.getName(), request.getPrice(), request.getQuantity());
        groceryItemRepository.save(newItem);
    }

    // Service method to get all grocery items
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    public ResponseEntity<String> removeGroceryItem(Long itemId) {
        Optional<GroceryItem> optionalGroceryItem = groceryItemRepository.findById(itemId);
        
        if (optionalGroceryItem.isPresent()) {
            groceryItemRepository.deleteById(itemId);
            return ResponseEntity.ok("Grocery item removed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Grocery item not found");
        }
    }
    
    public ResponseEntity<String> updateGroceryItem(Long itemId, GroceryItemRequest request) {
        Optional<GroceryItem> optionalGroceryItem = groceryItemRepository.findById(itemId);

        if (optionalGroceryItem.isPresent()) {
            GroceryItem existingItem = optionalGroceryItem.get();

            // Update the details
            existingItem.setName(request.getName());
            existingItem.setPrice(request.getPrice());
            existingItem.setQuantity(request.getQuantity());

            // Save the updated item
            groceryItemRepository.save(existingItem);

            return ResponseEntity.ok("Grocery item updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Grocery item not found");
        }
    }
    public ResponseEntity<String> manageInventory(Long itemId, InventoryRequest request) {
        Optional<GroceryItem> optionalGroceryItem = groceryItemRepository.findById(itemId);

        if (optionalGroceryItem.isPresent()) {
            GroceryItem existingItem = optionalGroceryItem.get();

            // Perform inventory management (increase or decrease)
            int newQuantity = existingItem.getQuantity() + request.getQuantity();
            
            if (newQuantity < 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Inventory cannot be negative");
            }

            existingItem.setQuantity(newQuantity);

            // Save the updated item
            groceryItemRepository.save(existingItem);

            return ResponseEntity.ok("Inventory managed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Grocery item not found");
        }
    }

}
