package com.example.ecommerceBackend.controller;

import com.example.ecommerceBackend.entity.Cart;
import com.example.ecommerceBackend.entity.CartItem;
import com.example.ecommerceBackend.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/cart/{id}")
    public List<CartItem> getCart(@PathVariable int id) {
        Cart cart = cartRepository.findById(id).get();
        return cart.getCartItems();
    }
}
