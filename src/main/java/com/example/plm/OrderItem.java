package com.example.plm;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
    private String orderItemId;
    private Product product;
    private int quantity;
    private float price;

    // Constructeur
    public OrderItem() {
    }

    public OrderItem(String orderItemId, Product product, int quantity, float price) {
        this.orderItemId = orderItemId;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters et Setters
    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // Méthodes métier
    public float calculateSubTotal() {
        return quantity * price;
    }
}