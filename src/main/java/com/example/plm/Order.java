package com.example.plm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private String orderId;
    private Date date;
    private String status;
    private com.example.plm.Client client;
    private List<com.example.plm.OrderItem> items;
    private double totalAmount;

    // Constructeur
    public Order() {
        this.items = new ArrayList<>();
        this.date = new Date();
    }

    // Getters et Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public com.example.plm.Client getClient() {
        return client;
    }

    public void setClient(com.example.plm.Client client) {
        this.client = client;
    }

    public List<com.example.plm.OrderItem> getItems() {
        return items;
    }

    public void setItems(List<com.example.plm.OrderItem> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    // Méthodes métier
    public void createOrder() {
        this.status = "CREATED";
        calculateTotal();
    }

    public void updateOrder() {
        calculateTotal();
    }

    public void generateInvoice() {
        // Logique de génération de facture
    }

    public void addItem(com.example.plm.OrderItem item) {
        items.add(item);
        calculateTotal();
    }

    private void calculateTotal() {
        this.totalAmount = items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }
}