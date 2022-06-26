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
    private TextField tfPatientID;
    @FXML
    private AnchorPane apPatientLoeschen;

    @FXML
    private TextField tfArztID;
    @FXML
    private AnchorPane apArztLoeschen;

    @FXML
    private TextField tfSekreteriatID;
    @FXML
    private AnchorPane apSekreteriatLoeschen;

    @FXML
    private TextField tfVerwaltungspersonalID;
    @FXML
    private AnchorPane apVerwaltungspersonalLoeschen;


    @FXML
    private void clickPatientLoeschen(ActionEvent event) {
        if(apPatientLoeschen.isVisible() == false){
            apPatientLoeschen.setVisible(true);
            apArztLoeschen.setVisible(false);
            apSekreteriatLoeschen.setVisible(false);
            apVerwaltungspersonalLoeschen.setVisible(false);
        }
        else
            apPatientLoeschen.setVisible(false);

    }

    @FXML
    private void clickArztLoeschen(ActionEvent event) {
        if(apArztLoeschen.isVisible() == false){
            apArztLoeschen.setVisible(true);
            apPatientLoeschen.setVisible(false);
            apSekreteriatLoeschen.setVisible(false);
            apVerwaltungspersonalLoeschen.setVisible(false);
        }
        else
            apArztLoeschen.setVisible(false);

    }

    @FXML
    private void clickSekreteriatLoeschen(ActionEvent event) {
        if(apSekreteriatLoeschen.isVisible() == false){
            apSekreteriatLoeschen.setVisible(true);
            apArztLoeschen.setVisible(false);
            apPatientLoeschen.setVisible(false);
            apVerwaltungspersonalLoeschen.setVisible(false);
        }
        else
            apSekreteriatLoeschen.setVisible(false);

    }

    @FXML
    private void clickVerwaltungspersonalLoeschen(ActionEvent event) {
        if(apVerwaltungspersonalLoeschen.isVisible() == false){
            apVerwaltungspersonalLoeschen.setVisible(true);
            apArztLoeschen.setVisible(false);
            apPatientLoeschen.setVisible(false);
            apSekreteriatLoeschen.setVisible(false);
        }
        else
            apVerwaltungspersonalLoeschen.setVisible(false);

    }

    @FXML
    private void deletePatient(ActionEvent event){
        //System.out.println("----------------------------------------------------------\n" + "Informationen zur Person, die von der Datenbank geloescht wurde:");
       // DB.printPersonInfo(Integer.parseInt(tfPatientPersonID.getText()));
        DB.deletePatient(Integer.parseInt(tfPatientID.getText()));
        //System.out.println("----------------------------------------------------------");
    }

    @FXML
    private void deleteDoctor(ActionEvent event){
        //System.out.println("----------------------------------------------------------\n" + "Informationen zur Person, die von der Datenbank geloescht wurde:");
        // DB.printPersonInfo(Integer.parseInt(tfPatientPersonID.getText()));
        DB.deleteDoctor(Integer.parseInt(tfArztID.getText()));
        //System.out.println("----------------------------------------------------------");
    }

    @FXML
    private void deleteSecretary(ActionEvent event){
        //System.out.println("----------------------------------------------------------\n" + "Informationen zur Person, die von der Datenbank geloescht wurde:");
        // DB.printPersonInfo(Integer.parseInt(tfPatientPersonID.getText()));
        DB.deleteSecretary(Integer.parseInt(tfSekreteriatID.getText()));
        //System.out.println("----------------------------------------------------------");
    }

    @FXML
    private void deleteManagementPersonnel(ActionEvent event){
        //System.out.println("----------------------------------------------------------\n" + "Informationen zur Person, die von der Datenbank geloescht wurde:");
        // DB.printPersonInfo(Integer.parseInt(tfPatientPersonID.getText()));
        DB.deleteManagementPersonnel(Integer.parseInt(tfVerwaltungspersonalID.getText()));
        //System.out.println("----------------------------------------------------------");
    }

}
