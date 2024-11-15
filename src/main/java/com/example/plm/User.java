package com.example.plm;

import java.util.Date;

public class User {
    private String userId;
    private String name;
    private String role;
    private String accessLevel;
    private String email;
    private String password;
    private Date createdAt;
    private Date updatedAt;

    // Constructeur
    public User() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public User(String userId, String name, String role, String accessLevel, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.accessLevel = accessLevel;
        this.email = email;
        this.password = password;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    // Getters et Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Méthodes métier
    public String login() {
        // Logique de connexion
        return "Logged in successfully";
    }

    public void logout() {
        // Logique de déconnexion
    }

    public void manageAccess() {
        // Logique de gestion des accès
    }

    public void updateProfile() {
        this.updatedAt = new Date();
        // Logique de mise à jour du profil
    }

    public boolean validatePassword(String password) {
        // Logique de validation du mot de passe
        return this.password.equals(password);
    }

    // Méthode toString pour l'affichage
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", accessLevel='" + accessLevel + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}