package com.example.ecommerceBackend.repository;

import com.example.ecommerceBackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
