package com.example.ecommerceBackend.repository;

import com.example.ecommerceBackend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
