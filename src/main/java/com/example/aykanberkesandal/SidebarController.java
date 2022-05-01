package com.example.aykanberkesandal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;
import java.io.IOException;


public class SidebarController {
    public static Stage stage;
    private static Scene scene;
    private static Parent root;
    String User = LoginController.currentUser;
    @FXML
    private AnchorPane apScreen;
    @FXML
    public Label lCurrentUser;



    @FXML
    public void initialize() {
        lCurrentUser.setText(User);
        loadPage("Homepage");

    }

    @FXML
    private void loadHomepage(ActionEvent event) {
        stage.setTitle("Startzeite");
        loadPage("Homepage");
    }

    @FXML
    private void loadListpage(ActionEvent event) {
        //stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Listen");
        loadPage("Listen");
    }

    @FXML
    private void loadAddpage(ActionEvent event) {
        //stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Addieren");
        loadPage("Addieren");
    }

    @FXML
    private void loadDeletepage(ActionEvent event) {
        //stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Löschen");
        loadPage("Loeschen");
    }

    private void loadPage(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
            apScreen.getChildren().removeAll();
            apScreen.getChildren().add(root);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchToLoginScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Login");
        LoginController.currentUser = "";
        stage.setResizable(false);
        scene = new Scene(root);
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }
}
