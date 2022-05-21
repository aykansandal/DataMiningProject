package com.example.aykanberkesandal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ListPageController {
    public static Stage stage;
    private static Scene scene;
    private static Parent root;

    @FXML
    private AnchorPane apListen;

    @FXML
    private void loadPatientList(ActionEvent event) {
        loadFunction("PatientListen");
    }


    private void loadFunction(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
            apListen.getChildren().removeAll();
            apListen.getChildren().add(root);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
