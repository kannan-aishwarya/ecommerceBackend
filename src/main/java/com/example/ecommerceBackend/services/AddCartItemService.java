package com.example.ecommerceBackend.services;

import com.example.ecommerceBackend.entity.CartItem;
import com.example.ecommerceBackend.entity.Product;
import com.example.ecommerceBackend.repository.CartItemRepository;
import com.example.ecommerceBackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddCartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private ProductRepository productRepository;
    public  void addCartItem(int productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
    }
}
