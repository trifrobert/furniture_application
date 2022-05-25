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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class Tables implements Initializable {

    @FXML
    public Button backButton;
    @FXML
    public Button buyButton;
    @FXML
    public Button buyButton2;
    @FXML
    public Button buyButton3;
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
    @FXML
    private Text firstText;
    @FXML
    private Text secondText;
    @FXML
    private Text thirdText;

    String fileContent = "";
    String last_string = "";

    public String incrementString(String string){
        int value = Integer.parseInt(string);
        value += 1;
        return Integer.toString(value);
    }

    public int isAdded(Text text){
        String toCheck = text.getText();
        try{
            File file = new File("src/cart.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String buff;
            int count = 0;
            int result = 0;

            while((buff = br.readLine()) != null){
                count++;
                if(buff.contains(toCheck)){
                    result = count;
                    StringTokenizer st = new StringTokenizer(buff," ");
                    String strLastToken = null;
                    while( st.hasMoreTokens() ) {
                        strLastToken = st.nextToken();
                    }
                    last_string = strLastToken;
                }
                if(result != count){
                    fileContent = fileContent + buff + "\n";
                }
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public void buyButtonFirst(){
        if(isAdded(firstText) != 0){
            try{
                fileContent = fileContent + firstText.getText() + " " + incrementString(last_string) + "\n";
                PrintStream out;
                out = new PrintStream(new FileOutputStream("src/cart.txt"));
                out.append(fileContent);
                fileContent = "";
                last_string = "";
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
        else{
            try{
                fileContent = fileContent + firstText.getText() + " " + "1\n";
                PrintStream out;
                out = new PrintStream(new FileOutputStream("src/cart.txt"));
                out.append(fileContent);
                fileContent = "";
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    public void buyButtonSecond(){
        if(isAdded(secondText) != 0){
            try{
                fileContent = fileContent + secondText.getText() + " " + incrementString(last_string) + "\n";
                PrintStream out;
                out = new PrintStream(new FileOutputStream("src/cart.txt"));
                out.append(fileContent);
                fileContent = "";
                last_string = "";
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
        else{
            try{
                fileContent = fileContent + secondText.getText() + " " + "1\n";
                PrintStream out;
                out = new PrintStream(new FileOutputStream("src/cart.txt"));
                out.append(fileContent);
                fileContent = "";
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    public void buyButtonThird(){
        if(isAdded(thirdText) != 0){
            try{
                fileContent = fileContent + thirdText.getText() + " " + incrementString(last_string) + "\n";
                PrintStream out;
                out = new PrintStream(new FileOutputStream("src/cart.txt"));
                out.append(fileContent);
                fileContent = "";
                last_string = "";
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
        else{
            try{
                fileContent = fileContent + thirdText.getText() + " " + "1\n";
                PrintStream out;
                out = new PrintStream(new FileOutputStream("src/cart.txt"));
                out.append(fileContent);
                fileContent = "";
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL URL, ResourceBundle resourceBundle){
        File f1 = new File("src/Images/front_page_template.jpg");
        Image myImage1 = new Image(f1.toURI().toString());

        File f3 = new File("src/Images/table1.jpg");
        Image myImage3 = new Image(f3.toURI().toString());

        File f5 = new File("src/Images/table3.png");
        Image myImage5 = new Image(f5.toURI().toString());

        File f6 = new File("src/Images/table2.jpg");
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
