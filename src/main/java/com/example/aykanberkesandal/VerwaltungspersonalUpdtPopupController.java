package com.example.aykanberkesandal;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class VerwaltungspersonalUpdtPopupController {
    public static VerwaltungspersonalController verwaltungspersonalController;
    @FXML
    private TextField tfVerwaltungspersonalUID2;
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
    public  void clickUpdateManagementPersonnel(){
        Verwaltungspersonal managementPersonnelToBeUpdated = new Verwaltungspersonal(Integer.parseInt(tfVerwaltungspersonalUID.getText()),tfVerwaltungspersonalVorname.getText(),tfVerwaltungspersonalName.getText(),tfVerwaltungspersonalTelefonnummer.getText(),tfVerwaltungspersonalAdresse.getText(),tfVerwaltungspersonalID.getText(),tfVerwaltungspersonalSVN.getText(),tfVerwaltungspersonalBenutzername.getText(),tfVerwaltungspersonalPasswort.getText());
        DBUpdtOps.updateVerwaltungspersonal(managementPersonnelToBeUpdated);
        verwaltungspersonalController.refreshTable();
    }

    @FXML
    private void clickFindManagementPersonnel(){
        String [] arr = DB.findVerwaltungspersonal(Integer.parseInt(tfVerwaltungspersonalUID2.getText()));
        tfVerwaltungspersonalVorname.setText(arr[0]);
        tfVerwaltungspersonalName.setText(arr[1]);
        tfVerwaltungspersonalTelefonnummer.setText(arr[2]);
        tfVerwaltungspersonalAdresse.setText(arr[3]);
        tfVerwaltungspersonalID.setText(arr[4]);
        tfVerwaltungspersonalSVN.setText(arr[5]);
        tfVerwaltungspersonalBenutzername.setText(arr[6]);
        tfVerwaltungspersonalPasswort.setText(arr[7]);
        tfVerwaltungspersonalUID.setText(tfVerwaltungspersonalUID2.getText());
    }
}
