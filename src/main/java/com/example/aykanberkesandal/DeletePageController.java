package com.example.aykanberkesandal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DeletePageController {
    public static Stage stage;
    private static Scene scene;
    private static Parent root;

    @FXML
    private AnchorPane apLoeschen;

    @FXML
    private void loadPatientDelete(ActionEvent event) {
        //stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        loadFunction("PatientLoeschen");
        //Parent root = null;
        /*try {
            root = FXMLLoader.load(getClass().getResource("PatientAddieren.fxml"));
            apAddieren.getChildren().removeAll();
            apAddieren.getChildren().add(root);
        }
        catch (IOException e) {
            e.printStackTrace();
        }*/
    }


    private void loadFunction(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
            apLoeschen.getChildren().removeAll();
            apLoeschen.getChildren().add(root);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
