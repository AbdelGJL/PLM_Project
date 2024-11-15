package com.example.plm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

// Controller.java
public class Controller {
    public Controller() {
        try {
            DBManager.connect();
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        }
    }

    @FXML
    private void GoToLogin(ActionEvent event) {
        try {
            // Charger la nouvelle scène
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/login/Login.fxml"));
            Parent root = fxmlLoader.load();

            // Créer et configurer la nouvelle fenêtre
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            // Obtenir la fenêtre actuelle et la fermer
            Stage currentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            currentStage.close();

            // Afficher la nouvelle fenêtre
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Méthodes pour User
    public boolean createUser(User user) {
        try {
            DBManager.createUser(user);
            return true;
        } catch (SQLException e) {
            System.err.println("Error creating user: " + e.getMessage());
            return false;
        }
    }

    public User getUser(String userId) {
        try {
            return DBManager.getUser(userId);
        } catch (SQLException e) {
            System.err.println("Error retrieving user: " + e.getMessage());
            return null;
        }
    }

    // Méthodes pour Product
    public boolean createProduct(Product product) {
        try {
            DBManager.createProduct(product);
            return true;
        } catch (SQLException e) {
            System.err.println("Error creating product: " + e.getMessage());
            return false;
        }
    }

    public Product getProduct(String productId) {
        try {
            return DBManager.getProduct(productId);
        } catch (SQLException e) {
            System.err.println("Error retrieving product: " + e.getMessage());
            return null;
        }
    }

    // Méthodes pour Order
    public boolean createOrder(Order order) {
        // Implémenter la logique
        return false;
    }

    // Méthodes pour Client
    public boolean createClient(Client client) {
        // Implémenter la logique
        return false;
    }

    // Fermeture de la connexion
    public void closeConnection() {
        try {
            DBManager.disconnect();
        } catch (SQLException e) {
            System.err.println("Error closing database connection: " + e.getMessage());
        }
    }
}