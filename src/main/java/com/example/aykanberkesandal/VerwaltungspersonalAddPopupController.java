package com.example.aykanberkesandal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class VerwaltungspersonalAddPopupController {
    public static VerwaltungspersonalController verwaltungspersonalController;
    @FXML
    private TextField tfVerwaltungspersonalUID;
    @FXML
    private TextField tfVerwaltungspersonalVorname;
    @FXML
    private TextField tfVerwaltungspersonalName;
    @FXML
    private TextField tfVerwaltungspersonalTelefonnummer;
    @FXML
    private TextField tfVerwaltungspersonalAdresse;
    @FXML
    private TextField tfVerwaltungspersonalID;
    @FXML
    private TextField tfVerwaltungspersonalSVN;
    @FXML
    private TextField tfVerwaltungspersonalBenutzername;
    @FXML
    private TextField tfVerwaltungspersonalPasswort;

    @FXML
    private void addManagementPersonnel(ActionEvent event){
        Verwaltungspersonal verwaltungspersonal = new Verwaltungspersonal(Integer.parseInt(tfVerwaltungspersonalUID.getText()),tfVerwaltungspersonalVorname.getText(),tfVerwaltungspersonalName.getText(),tfVerwaltungspersonalTelefonnummer.getText(),tfVerwaltungspersonalAdresse.getText(),tfVerwaltungspersonalID.getText(),tfVerwaltungspersonalSVN.getText(),tfVerwaltungspersonalBenutzername.getText(),tfVerwaltungspersonalPasswort.getText());
        DBAddOps.insertManagementPersonnel(verwaltungspersonal);
        DBAddOps.insertManagementPersonnelBP(verwaltungspersonal);
        verwaltungspersonalController.refreshTable();

    }

    @FXML
    private void clickGetVerwaltungspersonalID(){
        tfVerwaltungspersonalUID.setPromptText(String.valueOf(DB.getIncreasedVerwaltungspersonalID()));
    }
}
