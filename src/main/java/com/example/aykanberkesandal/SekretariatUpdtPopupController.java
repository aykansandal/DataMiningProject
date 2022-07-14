package com.example.aykanberkesandal;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SekretariatUpdtPopupController {
    public static SekretariatController sekretariatController;
    @FXML
    private TextField tfSekretariatUID2;
    @FXML
    private TextField tfSekretariatUID;
    @FXML
    private TextField tfSekretariatVorname;
    @FXML
    private TextField tfSekretariatName;
    @FXML
    private TextField tfSekretariatTelefonnummer;
    @FXML
    private TextField tfSekretariatAdresse;
    @FXML
    private TextField tfSekretariatID;
    @FXML
    private TextField tfSekretariatSVN;
    @FXML
    private TextField tfSekretariatBenutzername;
    @FXML
    private TextField tfSekretariatPasswort;

    @FXML
    public  void clickUpdateSecretary(){
        Sekretariat secretaryToBeUpdated = new Sekretariat(Integer.parseInt(tfSekretariatUID.getText()),tfSekretariatVorname.getText(),tfSekretariatName.getText(),tfSekretariatTelefonnummer.getText(),tfSekretariatAdresse.getText(),tfSekretariatID.getText(),tfSekretariatSVN.getText(),tfSekretariatBenutzername.getText(),tfSekretariatPasswort.getText());
        DBUpdtOps.updateSekretariat(secretaryToBeUpdated);
        sekretariatController.refreshTable();
    }

    @FXML
    private void clickFindSecretary(){
        String [] arr = DB.findSekretariat(Integer.parseInt(tfSekretariatUID2.getText()));
        tfSekretariatVorname.setText(arr[0]);
        tfSekretariatName.setText(arr[1]);
        tfSekretariatTelefonnummer.setText(arr[2]);
        tfSekretariatAdresse.setText(arr[3]);
        tfSekretariatID.setText(arr[4]);
        tfSekretariatSVN.setText(arr[5]);
        tfSekretariatBenutzername.setText(arr[6]);
        tfSekretariatPasswort.setText(arr[7]);
        tfSekretariatUID.setText(tfSekretariatUID2.getText());
    }
}
