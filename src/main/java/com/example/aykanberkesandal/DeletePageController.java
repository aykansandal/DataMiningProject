package com.example.aykanberkesandal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DeletePageController {
    public static Stage stage;
    private static Scene scene;
    private static Parent root;

    @FXML
    private TextField tfPatientPersonID;
    @FXML
    private AnchorPane apPatientLoeschen;


    @FXML
    private void clickPatientLoeschen(ActionEvent event) {
        apPatientLoeschen.setVisible(true);
    }

    @FXML
    private void deletePatient(ActionEvent event){
        DB.printPersonInfo(Integer.parseInt(tfPatientPersonID.getText()));
        DB.deletePerson(Integer.parseInt(tfPatientPersonID.getText()));
        System.out.println("Patient wurde vom Datenbank geloescht.");
    }

}
