package com.example.aykanberkesandal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginController {
    public Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField tfBenutzername;
    @FXML
    private TextField tfPasswort;
    @FXML
    private Button buttonLogin;

    public static String currentUser;



    public void switchToHomepage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Application.class.getResource("Mainpage.fxml"));
        System.out.println(root);
        stage =(Stage)(buttonLogin.getScene().getWindow());
        stage.setTitle("Homepage");
        //stage.setResizable(false); TODO: Decide if you want it resizable
        scene = new Scene(root);
        //stage.hide();  TODO: <-
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void login(ActionEvent event){
        try {
            if(DB.checkLogin(tfBenutzername.getText(),tfPasswort.getText())){
                System.out.println("ok");
                currentUser = tfBenutzername.getText();
                SideBarController.stage =(Stage)(buttonLogin.getScene().getWindow());
                switchToHomepage(event);
            }
            // TODO: else - alert
        }
        catch (Exception e) {
        }
    }

    public static void setCurrentUser(String currentUser) {
        LoginController.currentUser = currentUser;
    }

}