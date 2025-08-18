package com.example.ecommerceBackend.controller;

import com.example.ecommerceBackend.entity.Product;
import com.example.ecommerceBackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductRepository repository;
    
    @GetMapping("/")
    public List<Product> getAllProducts() {
        List<Product>productList = repository.findAll();
        return productList;
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id) {
        Product product = repository.findById(id).get();
        return product;
    }
}
