package com.example.ecommerceBackend.entity;

import java.util.List;

public class OrderRequest {
    private int userId;
    private List<PlaceOrderRequest> orderItem ;
    private String orderStatus;
    public OrderRequest() {

    }

    public OrderRequest(int userId, List<PlaceOrderRequest> orderItem,String orderStatus) {
        this.userId = userId;
        this.orderItem = orderItem;
        this.orderStatus = orderStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<PlaceOrderRequest> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<PlaceOrderRequest> orderItem) {
        this.orderItem = orderItem;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
