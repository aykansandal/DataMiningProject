package com.example.aykanberkesandal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    /*@FXML
    private Label welcomeText;*/

    public void switchToHomepage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("GUI Demo");
        stage.setResizable(false);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToLoginScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Login");
        stage.setResizable(false);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /*@FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    public void myPrint(){
        System.out.println("Hello World" + "?");
    }*/
}