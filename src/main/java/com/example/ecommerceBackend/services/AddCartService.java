package com.example.ecommerceBackend.services;

import com.example.ecommerceBackend.entity.Cart;
import com.example.ecommerceBackend.entity.CartItem;
import com.example.ecommerceBackend.entity.Product;
import com.example.ecommerceBackend.entity.User;
import com.example.ecommerceBackend.repository.CartItemRepository;
import com.example.ecommerceBackend.repository.CartRepository;
import com.example.ecommerceBackend.repository.ProductRepository;
import com.example.ecommerceBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddCartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserRepository userRepository;

    public  Cart getCartForUser(User user) {
        return cartRepository.findByUser(user)
                .orElseGet(() -> {
                    Cart cart = new Cart();
                    cart.setUser(user);
                    cart.setOrderStatus("Empty");
                    return cartRepository.save(cart);
                });
    }

    public Cart addItemToCart(String email, int productId, int quantity) {
        User user = userRepository.findByEmailIgnoreCase(email).get();
        Cart cart = getCartForUser(user);
        Product product = productRepository.findById(productId).get();
        CartItem cartItem = cart.getCartItems().stream()
                .filter(item -> item.getProduct().getId() == productId)
                .findFirst().orElse(null);
        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        } else {
            CartItem cartItem1 = new CartItem();
            cartItem1.setProduct(product);
            cartItem1.setQuantity(quantity);
            cart.setCartItems(cartItem1);
        }
        return cartRepository.save(cart);
    }

    public CartItem updateCartItem(int cartItemId, int quantity) {
        CartItem cartItem = cartItemRepository.findById(cartItemId).get();
        cartItem.setQuantity(quantity);
        return cartItemRepository.save(cartItem);
    }

    public void removeItemCart(int cartItemId) {
        CartItem cartItem = cartItemRepository.findById(cartItemId).get();
        cartItemRepository.delete(cartItem);
    }
}
