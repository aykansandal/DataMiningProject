package com.example.aykanberkesandal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SekretariatAddPopupController {
    public static SekretariatController sekretariatController;
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
    private void addSecretary(ActionEvent event){
        Sekretariat sekretariat = new Sekretariat(Integer.parseInt(tfSekretariatUID.getText()),tfSekretariatVorname.getText(),tfSekretariatName.getText(),tfSekretariatTelefonnummer.getText(),tfSekretariatAdresse.getText(),tfSekretariatID.getText(),tfSekretariatSVN.getText(),tfSekretariatBenutzername.getText(),tfSekretariatPasswort.getText());
        DBAddOps.insertSecretary(sekretariat);
        DBAddOps.insertSecretaryBP(sekretariat);
        sekretariatController.refreshTable();
        DB.getIncreasedSekretariatID();

    }

    @FXML
    private void clickGetSekretariatID(){
        tfSekretariatUID.setPromptText(String.valueOf(DB.getIncreasedSekretariatID()));
    }
}
