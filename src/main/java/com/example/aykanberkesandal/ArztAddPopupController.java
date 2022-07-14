package com.example.aykanberkesandal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ArztAddPopupController {
    public static ArztController arztController;
    @FXML
    private TextField tfArztUID;
    @FXML
    private TextField tfArztVorname;
    @FXML
    private TextField tfArztName;
    @FXML
    private TextField tfArztTelefonnummer;
    @FXML
    private TextField tfArztAdresse;
    @FXML
    private TextField tfArztID;
    @FXML
    private TextField tfArztSVN;
    @FXML
    private TextField tfArztBenutzername;
    @FXML
    private TextField tfArztPasswort;

    @FXML
    private void addDoctor(ActionEvent event){
        Arzt arzt = new Arzt(Integer.parseInt(tfArztUID.getText()),tfArztVorname.getText(),tfArztName.getText(),tfArztTelefonnummer.getText(),tfArztAdresse.getText(),tfArztID.getText(),tfArztSVN.getText(),tfArztBenutzername.getText(),tfArztPasswort.getText());
        DBAddOps.insertDoctor(arzt);
        DBAddOps.insertDoctorBP(arzt);
        arztController.refreshTable();

    }

    @FXML
    private void clickGetArztID(){
        tfArztUID.setPromptText(String.valueOf(DB.getIncreasedArztID()));
    }
}
