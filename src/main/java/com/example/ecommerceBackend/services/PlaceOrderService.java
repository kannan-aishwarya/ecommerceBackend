package com.example.ecommerceBackend.services;

import com.example.ecommerceBackend.entity.*;
import com.example.ecommerceBackend.repository.OrderRepository;
import com.example.ecommerceBackend.repository.ProductRepository;
import com.example.ecommerceBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class PlaceOrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public void placeOrder(OrderRequest request) {
        User user = userRepository.findById(request.getUserId()).get();
        Order order = new Order();
        order.setOrderDate(LocalDate.now().toString());
        order.setOrderStatus(request.getOrderStatus());
        List<OrderItem> orderItems = new ArrayList<>();
        double total = 0.0;
        for (PlaceOrderRequest item : request.getOrderItem()) {
           Product product = productRepository.findById(item.getProductId()).get();
           OrderItem orderItem = new OrderItem();
           orderItem.setProduct(product);
           orderItem.setQuantity(item.getQuantity());
           orderItem.setPrice(item.getPrice());
           orderItem.setOrder(order);
           orderItems.add(orderItem);
           total += product.getPrice() * item.getQuantity();
        }
        order.setOrderItems(orderItems);
        order.setTotalAmount(total);
        orderRepository.save(order);
    }
}
