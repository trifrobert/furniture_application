package com.example.sefapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class LoginSceneController {

    @FXML
    public CheckBox checkMaintainer;
    @FXML
    public Button backButton;
    @FXML
    public Button loginButton;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label statusMessage;

    public int validateLogin()  {
        try{
            File file = new File("src/data.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String username = "";
            String password ;
            String buff ;
            int flag = 0;

            while ((buff = br.readLine()) != null) {
                flag++;
                if((flag+1) % 5 == 0){
                    username = buff;
                }
                if(flag % 5 == 0){
                    password = buff;

                    if( username.equals(usernameTextField.getText()) && password.equals(passwordField.getText()) ){
                        return 1;
                    }
                }
            }
            return 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public void loginButtonOnAction(ActionEvent event) throws IOException {
        if(!usernameTextField.getText().isBlank() && !passwordField.getText().isBlank()) {
            if(validateLogin() == 1) {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoggedInScene.fxml")));
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                LogginStatus.changeStatus(true);
                LogoutStatus.changeStatus(false);
            }
            else {
                statusMessage.setTextFill(Color.web("#bd0f0f"));
                statusMessage.setText("Wrong username or password. Please try again!");
            }
        }
        else {
            statusMessage.setTextFill(Color.web("#bd0f0f"));
            statusMessage.setText("Wrong username or password. Please try again!");
        }
    }

    public void switchToMainScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainScene.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
