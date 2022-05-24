package com.example.sefapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Chairs implements Initializable {

    @FXML
    public Button backButton;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private ImageView image1;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image5;
    @FXML
    private ImageView image6;

    @Override
    public void initialize(URL URL, ResourceBundle resourceBundle){
        File f1 = new File("src/Images/front_page_template.jpg");
        Image myImage1 = new Image(f1.toURI().toString());

        File f3 = new File("src/Images/bed1.jpg");
        Image myImage3 = new Image(f3.toURI().toString());

        File f5 = new File("src/Images/bed2.jpg");
        Image myImage5 = new Image(f5.toURI().toString());

        File f6 = new File("src/Images/bed3.jpg");
        Image myImage6 = new Image(f6.toURI().toString());

        image1.setImage(myImage1);
        image3.setImage(myImage3);
        image5.setImage(myImage5);
        image6.setImage(myImage6);
    }

    public void switchToPreviousScene(ActionEvent event) throws IOException {

        if(LogginStatus.getStatus() && !LogoutStatus.getStatus()){
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoggedInScene.fxml")));
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainScene.fxml")));
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
