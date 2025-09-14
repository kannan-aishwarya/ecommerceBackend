package com.example.ecommerceBackend.controller;

import com.example.ecommerceBackend.entity.*;
import com.example.ecommerceBackend.repository.UserRepository;
import com.example.ecommerceBackend.services.AddCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    @Autowired
    private AddCartService cartService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<Cart> addCartItem(@RequestBody AddCartItemRequest request) {
        Cart cart = cartService.addItemToCart(request.getEmail(), request.getProductId(), request.getQuantity());
        return ResponseEntity.ok(cart);
    }
    // Update quantity
    @PutMapping("/item/update/{id}")
    public ResponseEntity<CartItem> updateCartItem(@PathVariable int id, @RequestBody UpdateCartItemRequest request) {
        CartItem cartItem = cartService.updateCartItem(id, request.getQuantity());
        return ResponseEntity.ok(cartItem);
    }

    // Delete item
    @DeleteMapping("/item/delete/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable int id) {
        cartService.removeItemCart(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/item")
    public ResponseEntity<Cart> getCartItems(@RequestBody FetchCart email) {
        User user = userRepository.findByEmailIgnoreCase(email.getEmail()).get();
        Cart cart = cartService.getCartForUser(user);
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/clear/{email}")
    public ResponseEntity<String> clearCart(@PathVariable String email) {
        cartService.clearCart(email);
        return ResponseEntity.ok("Cart cleared successfully");
    }

}
