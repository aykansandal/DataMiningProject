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

public class PatientDelPopupController {
    public static PatientController patientController;

    @FXML
    private TextField tfPatientUID2;
    @FXML
    private TextField tfPatientVorname2;
    @FXML
    private TextField tfPatientName2;
    @FXML
    private TextField tfPatientTelefonnummer2;
    @FXML
    private TextField tfPatientAdresse2;
    @FXML
    private TextField tfPatientID2;


    @FXML
    private TextField tfPatientUID4;

    @FXML
    private void deletePatient(){
        Patient patientToBeRemoved = new Patient(Integer.parseInt(tfPatientUID2.getText()),"","","","","");
        DBDelOps.deletePatient(patientToBeRemoved);
        patientController.refreshTable();
        DB.decreasePatientID();

    }

    @FXML
    private void clickFindPatient1(){
        String [] arr = DB.findPatient(Integer.parseInt(tfPatientUID4.getText()));
        tfPatientVorname2.setText(arr[0]);
        tfPatientName2.setText(arr[1]);
        tfPatientTelefonnummer2.setText(arr[2]);
        tfPatientAdresse2.setText(arr[3]);
        tfPatientID2.setText(arr[4]);
        tfPatientUID2.setText(tfPatientUID4.getText());
    }
}
