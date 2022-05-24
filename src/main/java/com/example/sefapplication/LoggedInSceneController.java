package com.example.sefapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoggedInSceneController implements Initializable {

    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image4;
    @FXML
    public Button logoutButton;
    @FXML
    public Button cartButton;
    @FXML
    public TextField searchBar;
    @FXML
    public ImageView searchButton;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    @Override
    public void initialize(URL URL, ResourceBundle resourceBundle){
        File backgroundFile = new File("src/Images/searchButton.png");
        Image myImage = new Image(backgroundFile.toURI().toString());

        File f1 = new File("src/Images/front_page_template.jpg");
        Image myImage1 = new Image(f1.toURI().toString());

        File f2 = new File("src/Images/chair3.png");
        Image myImage2 = new Image(f2.toURI().toString());

        File f3 = new File("src/Images/bed1.jpg");
        Image myImage3 = new Image(f3.toURI().toString());

        File f4 = new File("src/Images/table1.jpg");
        Image myImage4 = new Image(f4.toURI().toString());

        searchButton.setImage(myImage);
        image1.setImage(myImage1);
        image2.setImage(myImage2);
        image3.setImage(myImage3);
        image4.setImage(myImage4);
    }

    public void switchToCartScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CartScene.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMainScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainScene.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        LogginStatus.changeStatus(false);
        LogoutStatus.changeStatus(true);
    }

    public void switchToBedsScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Beds.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToTablesScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Tables.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToChairsScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Chairs.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAllScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AllScene.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
