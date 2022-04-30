package com.example.aykanberkesandal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class SideBarController implements Initializable {
    private Stage stage;
    private static Scene scene;
    private static Parent root;
    public static PreparedStatement pstmt;
    public static ResultSet rs;
    @FXML
    private HBox hboxAddieren;
    @FXML
    private HBox hboxListen;
    @FXML
    private HBox hboxLoeschen;
    @FXML
    private AnchorPane apScreen;
    @Override
    public void initialize(URL url, ResourceBundle rb){

    }

    @FXML
    private void loadHomepage(ActionEvent event){

        stage.setTitle("Homepage");
        loadPage("homepage");
    }

    @FXML
    private void loadListpage(ActionEvent event){
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Listen");
        loadPage("Listen");
    }

    @FXML
    private void loadAddpage(ActionEvent event){
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Addieren");
        loadPage("Addieren");
    }

    @FXML
    private void loadDeletepage(ActionEvent event){
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Löschen");
        loadPage("Loeschen");
    }

    private void loadPage(String page){
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

}
