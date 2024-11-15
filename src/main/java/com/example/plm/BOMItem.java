package com.example.plm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BOMItem {
    private String itemId;
    private String description;
    private int quantity;
    private float unitCost;
    private Product product;

    // Constructeur
    public BOMItem() {
    }

    public BOMItem(String itemId, String description, int quantity, float unitCost) {
        this.itemId = itemId;
        this.description = description;
        this.quantity = quantity;
        this.unitCost = unitCost;
    }

    // Getters et Setters
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(float unitCost) {
        this.unitCost = unitCost;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // Méthodes métier
    public void addItem() {
        // Logique d'ajout d'item
    }

    public void removeItem() {
        // Logique de suppression d'item
    }

    public float calculateTotalCost() {
        return quantity * unitCost;
    }
}