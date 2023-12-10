package com.grocery.booking.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.grocery.booking.dto.OrderItemRequest;
import com.grocery.booking.entity.GroceryItem;
import com.grocery.booking.repository.GroceryItemRepository;

@Service
public class UserOrderService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    // Other service methods...

    // Service method to book multiple grocery items in a single order
    public ResponseEntity<String> bookGroceryItems(List<OrderItemRequest> orderItems) {
        // Validate and process the order items
        for (OrderItemRequest orderItem : orderItems) {
            Optional<GroceryItem> optionalGroceryItem = groceryItemRepository.findById(orderItem.getItemId());

            if (optionalGroceryItem.isPresent()) {
                GroceryItem groceryItem = optionalGroceryItem.get();
                if (groceryItem.getQuantity() < orderItem.getQuantity()) {
                    return ResponseEntity.badRequest().body("Not enough inventory for item: " + groceryItem.getName());
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Grocery item not found");
            }
        }

        // Update inventory levels and save the order
        for (OrderItemRequest orderItem : orderItems) {
            GroceryItem groceryItem = groceryItemRepository.findById(orderItem.getItemId()).get();
            groceryItem.setQuantity(groceryItem.getQuantity() - orderItem.getQuantity());
            groceryItemRepository.save(groceryItem);
        }

        return ResponseEntity.ok("Order placed successfully");
    }

    // Other service methods...
}

