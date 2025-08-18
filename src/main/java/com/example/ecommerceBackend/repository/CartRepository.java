package com.example.ecommerceBackend.repository;

import com.example.ecommerceBackend.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
