package com.example.ecommerceBackend.repository;

import com.example.ecommerceBackend.entity.Cart;
import com.example.ecommerceBackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    Optional<Cart> findByUser(User user);
    
}
