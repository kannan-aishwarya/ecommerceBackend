package com.example.ecommerceBackend.repository;

import com.example.ecommerceBackend.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
}
