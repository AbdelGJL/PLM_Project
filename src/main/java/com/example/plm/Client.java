package com.example.plm;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String clientId;
    private String name;
    private String contactInfo;
    private String email;
    private String address;
    private List<Order> orders;

    // Constructeur
    public Client() {
        this.orders = new ArrayList<>();
    }

    public Client(String clientId, String name, String contactInfo, String email, String address) {
        this.clientId = clientId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.email = email;
        this.address = address;
        this.orders = new ArrayList<>();
    }

    // Getters et Setters
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<com.example.plm.Order> getOrders() {
        return orders;
    }

    // Méthodes métier
    public void addClient() {
        // Logique d'ajout de client
    }

    public void updateClient() {
        // Logique de mise à jour de client
    }

    public void addOrder(com.example.plm.Order order) {
        this.orders.add(order);
    }

    public double calculateTotalOrders() {
        return orders.stream()
                .mapToDouble(com.example.plm.Order::getTotalAmount)
                .sum();
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                ", name='" + name + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}