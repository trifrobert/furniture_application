package com.example.sefapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CartSceneController implements Initializable {

    @FXML
    public Button backButton;
    @FXML
    public Button backButton1;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private TextArea textArea;

    public  String toPrint = "";

    public void initialize(URL URL, ResourceBundle resourceBundle) {
        showCart();
    }

    public void showCart(){
        try{
            File file = new File("src/cart.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String buff ;

            while((buff = br.readLine()) != null){
                toPrint = toPrint + buff + "\n";
            }
            textArea.setText(toPrint);
        }catch (Exception e1){
            e1.printStackTrace();
        }
    }

    public void switchToNextScene(ActionEvent event) throws IOException {

        if(!textArea.getText().isBlank()){
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CheckoutScene.fxml")));
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FailCheckoutScene.fxml")));
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

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
