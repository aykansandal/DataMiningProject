package com.example.aykanberkesandal;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TerminUpdtPopupController {
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
    public  void clickUpdateTermin(){
        Termin appointmentToBeUpdated = new Termin(Integer.parseInt(tfTerminUID.getText()),tfTerminDatum.getText(),tfTerminArztName.getText(),tfTerminPatientName.getText());
        DBUpdtOps.updateTermin(appointmentToBeUpdated);
        terminController.refreshTable();
        //patientController.setPatientList(DBListOps.listPatient());
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
