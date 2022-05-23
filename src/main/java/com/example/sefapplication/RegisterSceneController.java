package com.example.sefapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;

public class RegisterSceneController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusMessage;

    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    private String str = "";

    public int validateRegistration(){
        try{
            File file = new File("src/data.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            int count = 0;
            String buff;
            while((buff = br.readLine()) != null){
                str = str + buff + "\n";
                count++;
                if( (count+1) % 5 == 0 ){
                    if(buff.equals(usernameField.getText())){
                        return 0;
                    }
                }
            }
            return 1;
        }catch (Exception e1){
            e1.printStackTrace();
        }
        return 1;
    }

    public void registerButton(ActionEvent event) throws IOException{

        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();

        boolean c1 = name.isBlank();
        boolean c2 = email.isBlank();
        boolean c3 = phone.isBlank();
        boolean c4 = username.isBlank();
        boolean c5 = password.isBlank();

        if(!c1 && !c2 && !c3 && !c4 && !c5){
            if(validateRegistration() == 1){
                try{
                    //File file = new File("src/data.txt");

                    str = str + name + "\n";
                    str = str + email + "\n";
                    str = str + phone + "\n";
                    str = str + username + "\n";
                    str = str + password + "\n";

                    PrintStream out;
                    out=new PrintStream(new FileOutputStream("src/data.txt"));
                    out.append(str);
                    str = "";

                    statusMessage.setTextFill(Color.web("#14c929"));
                    statusMessage.setText("Registration successful!");

                }catch(Exception e2){
                    e2.printStackTrace();
                }
            }
            else{
                statusMessage.setTextFill(Color.web("#bd0f0f"));
                statusMessage.setText("Could not complete the registration. Please try again!");
            }
        }else{
            statusMessage.setTextFill(Color.web("#bd0f0f"));
            statusMessage.setText("Could not complete the registration. Please try again!");
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
