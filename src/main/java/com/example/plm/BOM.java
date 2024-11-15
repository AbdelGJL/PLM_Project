package com.example.plm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BOM {
    private String bomId;
    private String type;
    private String details;
    private String resources;
    private List<com.example.plm.BOMItem> items;
    private Date createdDate;

    // Constructeur
    public BOM() {
        this.items = new ArrayList<>();
        this.createdDate = new Date();
    }

    // Getters et Setters
    public String getBomId() {
        return bomId;
    }

    public void setBomId(String bomId) {
        this.bomId = bomId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public List<com.example.plm.BOMItem> getItems() {
        return items;
    }

    public void setItems(List<com.example.plm.BOMItem> items) {
        this.items = items;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    // Méthodes métier
    public void generateBOM() {
        // Logique de génération de BOM
    }

    public void updateBOM() {
        // Logique de mise à jour de BOM
    }

    public void addItem(com.example.plm.BOMItem item) {
        this.items.add(item);
    }

    public double calculateTotalCost() {
        return items.stream()
                .mapToDouble(item -> item.getUnitCost() * item.getQuantity())
                .sum();
    }
}
