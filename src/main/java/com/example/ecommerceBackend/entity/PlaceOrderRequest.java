package com.example.ecommerceBackend.entity;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public class PlaceOrderRequest {
    private int productId;
    private int quantity;
    private int price;

    public PlaceOrderRequest() {

    }

    public PlaceOrderRequest(int productId, int quantity, int price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
