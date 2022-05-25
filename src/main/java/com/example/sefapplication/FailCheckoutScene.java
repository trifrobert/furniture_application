package com.example.sefapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FailCheckoutScene {

    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    public void switchToMainScene(ActionEvent event) throws IOException {

        if(LogginStatus.getStatus() && !LogoutStatus.getStatus()){
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoggedInScene.fxml")));
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainScene.fxml")));
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
