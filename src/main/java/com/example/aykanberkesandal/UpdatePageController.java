package com.example.aykanberkesandal;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.*;

public class UpdatePageController {
    public static Stage stage;
    private static Scene scene;
    private static Parent root;
    public static Connection conn = null;
    public static Statement stmt;
    public  static PreparedStatement pstmt;
    public  static ResultSet rs;

    @FXML
    private  TextField tfPatientUID;
    @FXML
    private  TextField tfPatientUID2;
    @FXML
    private  TextField tfPatientVorname;
    @FXML
    private  TextField tfPatientName;
    @FXML
    private  TextField tfPatientTelefonnummer;
    @FXML
    private TextField tfPatientAdresse;
    @FXML
    private  TextField tfPatientSVN;
    @FXML
    private TextField tfPatientID;
    @FXML
    private TextField tfPatientBenutzername;
    @FXML
    private TextField tfPatientPasswort;
    @FXML
    private AnchorPane apPatientAktualisieren;

    /*public  void clickUpdatePatient(){
        DBUpdtOps.updatePatient(tfPatientVorname.getText(),tfPatientName.getText(),tfPatientTelefonnummer.getText(),tfPatientAdresse.getText(),tfPatientID.getText(),tfPatientSVN.getText(),tfPatientBenutzername.getText(),tfPatientPasswort.getText(),Integer.parseInt(tfPatientUID2.getText()));
    }*/

    public void clickFindPatient(){
        String [] arr = DB.findPatient(Integer.parseInt(tfPatientUID2.getText()));
        tfPatientVorname.setText(arr[0]);
        tfPatientName.setText(arr[1]);
        tfPatientTelefonnummer.setText(arr[2]);
        tfPatientAdresse.setText(arr[3]);
        tfPatientID.setText(arr[4]);
        tfPatientSVN.setText(arr[5]);
        tfPatientBenutzername.setText(arr[6]);
        tfPatientPasswort.setText(arr[7]);
        tfPatientUID.setText(tfPatientUID2.getText());

    }

    public void clickAktualisierePatient(){
        if(apPatientAktualisieren.isVisible() == false){
            apPatientAktualisieren.setVisible(true);
        }
        else{
            apPatientAktualisieren.setVisible(false);
        }
    }



}
