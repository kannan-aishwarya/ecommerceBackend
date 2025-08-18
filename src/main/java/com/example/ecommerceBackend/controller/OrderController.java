package com.example.ecommerceBackend.controller;

import com.example.ecommerceBackend.entity.Order;
import com.example.ecommerceBackend.entity.OrderRequest;
import com.example.ecommerceBackend.entity.PlaceOrderRequest;
import com.example.ecommerceBackend.repository.OrderRepository;
import com.example.ecommerceBackend.services.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class OrderController {
    @Autowired
    private PlaceOrderService placeOrderService;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/orders/add")
    public void placeOrder(@RequestBody OrderRequest request) {
        placeOrderService.placeOrder(request);
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable int id) {
        Order order = orderRepository.findById(id).get();
        return order;
    }
}
