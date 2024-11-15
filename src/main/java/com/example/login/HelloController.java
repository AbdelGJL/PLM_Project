package com.example.login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;

import java.io.IOException;

public class HelloController {
    @FXML
    private void GoToSignUp(ActionEvent event) {
        try {
            // Charger la nouvelle scène
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/login/Sign_up.fxml"));
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
}