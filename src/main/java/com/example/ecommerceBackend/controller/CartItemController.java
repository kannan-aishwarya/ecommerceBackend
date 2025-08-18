package com.example.ecommerceBackend.controller;

import com.example.ecommerceBackend.entity.AddCartItemRequest;
import com.example.ecommerceBackend.entity.CartItem;
import com.example.ecommerceBackend.repository.CartItemRepository;
import com.example.ecommerceBackend.services.AddCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartItemController {
    @Autowired
    private AddCartItemService addCartItemService;

    @Autowired
    private CartItemRepository cartItemRepository;

    @PostMapping("/item/add")
    public void addCartItem(@RequestBody AddCartItemRequest cartItemRequest) {
        addCartItemService.addCartItem(cartItemRequest.getProductId(),cartItemRequest.getQuantity());
    }

    @PutMapping("/items/update/{id}")
    public void updateCartQuantity(@PathVariable int id, @RequestBody int quantity) {
        CartItem cartItem = cartItemRepository.findById(id).get();
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
    }

    @DeleteMapping("/items/delete/{id}")
    public void deleteCartItem(@PathVariable int id) {
        CartItem cartItem = cartItemRepository.findById(id).get();
        cartItemRepository.delete(cartItem);
    }
}
