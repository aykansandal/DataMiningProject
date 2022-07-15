package com.example.aykanberkesandal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;

public class TerminAddPopupController {
    public static TerminController terminController;
    public static Stage stage;
    private static Scene scene;
    private static Parent root;

    @FXML
    private DatePicker dpTermin;
    @FXML
    private TextField tfTerminUID;
    @FXML
    private TextField tfTerminArztName;
    @FXML
    private TextField tfTerminPatientName;

    @FXML
    private void addTermin(ActionEvent event){
        String date = dpTermin.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Termin termin = new Termin(Integer.parseInt(tfTerminUID.getText()),date,tfTerminArztName.getText(),tfTerminPatientName.getText());
        DBAddOps.insertTermin(termin);
        terminController.refreshTable();
        DB.getIncreasedTerminID();
    }

    @FXML
    private void clickGetTerminID(){
        tfTerminUID.setPromptText(String.valueOf(DB.getIncreasedTerminID()));
    }
}
