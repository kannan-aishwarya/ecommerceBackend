package com.example.ecommerceBackend.controller;

import com.example.ecommerceBackend.entity.Product;
import com.example.ecommerceBackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
