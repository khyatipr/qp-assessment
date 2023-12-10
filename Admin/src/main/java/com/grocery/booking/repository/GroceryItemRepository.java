package com.grocery.booking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocery.booking.entity.GroceryItem;
@Repository
public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {
    Optional<GroceryItem> findByName(String name);
}

