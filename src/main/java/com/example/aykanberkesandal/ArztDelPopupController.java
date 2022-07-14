package com.example.aykanberkesandal;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ArztDelPopupController {
    public static ArztController arztController;

    @FXML
    private TextField tfArztUID2;
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
    private void deleteDoctor(){
        Arzt doctorToBeRemoved = new Arzt(Integer.parseInt(tfArztUID2.getText()),"","","","","","","","");
        DBDelOps.deleteDoctor(doctorToBeRemoved);
        arztController.refreshTable();
        DB.decreaseDoctorID();

    }

    @FXML
    private void clickFindDoctor(){
        String [] arr = DB.findArzt(Integer.parseInt(tfArztUID2.getText()));
        tfArztVorname.setText(arr[0]);
        tfArztName.setText(arr[1]);
        tfArztTelefonnummer.setText(arr[2]);
        tfArztAdresse.setText(arr[3]);
        tfArztID.setText(arr[4]);
        tfArztSVN.setText(arr[5]);
        tfArztBenutzername.setText(arr[6]);
        tfArztPasswort.setText(arr[7]);
        tfArztUID.setText(tfArztUID2.getText());
    }
}
