package com.example.aykanberkesandal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TerminDelPopupController {
    public static TerminController terminController;
    @FXML
    private TextField tfTerminUID2;
    @FXML
    private TextField tfTerminUID;
    @FXML
    private TextField tfTerminDatum;
    @FXML
    private TextField tfTerminArztName;
    @FXML
    private TextField tfTerminPatientName;

    @FXML
    private void deleteTermin(ActionEvent event){
        Termin appointmentToBeRemoved = new Termin(Integer.parseInt(tfTerminUID.getText()),"","","");
        DBDelOps.deleteTermin(appointmentToBeRemoved);
        terminController.refreshTable();
        DB.decreaseTerminID();
    }

    @FXML
    private void clickFindTermin(){
        String [] arr = DB.findTermin(Integer.parseInt(tfTerminUID2.getText()));
        tfTerminUID.setText(tfTerminUID2.getText());
        tfTerminDatum.setText(arr[0]);
        tfTerminArztName.setText(arr[1]);
        tfTerminPatientName.setText(arr[2]);
    }
}
