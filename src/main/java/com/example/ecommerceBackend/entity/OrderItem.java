package com.example.ecommerceBackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orderItem")
public class OrderItem {
    @Id
    @GeneratedValue
    private int itemId;
    @ManyToOne
    private Product product;
    private int quantity;
    private double price;
    @ManyToOne
    @JoinColumn(name = "id")
    private Order order;

    public OrderItem() {

    }

    public OrderItem(int id, Product product, int quantity, double price, Order order) {
        this.itemId = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
    }

    public int getId() {
        return itemId;
    }

    public void setId(int id) {
        this.itemId = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
