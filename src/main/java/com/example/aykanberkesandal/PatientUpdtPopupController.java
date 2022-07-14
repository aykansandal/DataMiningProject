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

public class PatientUpdtPopupController {
    public static PatientController patientController;

    @FXML
    private TextField tfPatientUID3;
    @FXML
    private TextField tfPatientUID5;
    @FXML
    private TextField tfPatientVorname3;
    @FXML
    private TextField tfPatientName3;
    @FXML
    private TextField tfPatientTelefonnummer3;
    @FXML
    private TextField tfPatientAdresse3;
    @FXML
    private TextField tfPatientID3;

    @FXML
    public void initialize(){

    }

    @FXML
    public  void clickUpdatePatient(){
        Patient patientToBeUpdated = new Patient(Integer.parseInt(tfPatientUID5.getText()),tfPatientVorname3.getText(),tfPatientName3.getText(),tfPatientTelefonnummer3.getText(),tfPatientAdresse3.getText(),tfPatientID3.getText());
        DBUpdtOps.updatePatient(patientToBeUpdated);
        patientController.setPatientList(DBListOps.listPatient());
    }

    @FXML
    private void clickFindPatient2(){
        String [] arr = DB.findPatient(Integer.parseInt(tfPatientUID5.getText()));
        tfPatientVorname3.setText(arr[0]);
        tfPatientName3.setText(arr[1]);
        tfPatientTelefonnummer3.setText(arr[2]);
        tfPatientAdresse3.setText(arr[3]);
        tfPatientID3.setText(arr[4]);
        tfPatientUID3.setText(tfPatientUID5.getText());
    }

}


