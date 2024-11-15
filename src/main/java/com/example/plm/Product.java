package com.example.plm;

public class Product {
    private String productId;
    private String name;
    private String category;
    private String range;
    private String reference;
    private double price;
    private String description;
    private int stockQuantity;

    // Constructeur
    public Product() {
    }

    public Product(String productId, String name, String category, String range, String reference, double price) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.range = range;
        this.reference = reference;
        this.price = price;
    }

    // Getters et Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    // Méthodes métier
    public void createProduct() {
        // Logique de création de produit
    }

    public void updateProduct() {
        // Logique de mise à jour de produit
    }

    public void deleteProduct() {
        // Logique de suppression de produit
    }

    public void updateStock(int quantity) {
        this.stockQuantity += quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", range='" + range + '\'' +
                ", reference='" + reference + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                '}';
    }
}