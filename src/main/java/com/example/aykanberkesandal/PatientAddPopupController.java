package com.example.aykanberkesandal;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PatientAddPopupController {
    public static PatientController patientController;
    @FXML
    private TextField tfPatientUID;
    @FXML
    private TextField tfPatientVorname;
    @FXML
    private TextField tfPatientName;
    @FXML
    private TextField tfPatientTelefonnummer;
    @FXML
    private TextField tfPatientAdresse;
    @FXML
    private TextField tfPatientID;

    @FXML
    private void addPatient(ActionEvent event){
        Patient patient = new Patient(Integer.parseInt(tfPatientUID.getText()),tfPatientVorname.getText(),tfPatientName.getText(),tfPatientTelefonnummer.getText(),tfPatientAdresse.getText(),tfPatientID.getText());
        DBAddOps.insertPatient(patient);
        DB.getIncreasedPatientID();
        patientController.refreshTable();

    }

    @FXML
    private void clickGetPatientID(){
        tfPatientUID.setPromptText(String.valueOf(DB.getIncreasedPatientID()));
    }

}
