package com.example.aykanberkesandal;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.*;


public class AddPageController {
    public static Stage stage;
    private static Scene scene;
    private static Parent root;
    public static Connection conn = null;
    public static Statement stmt;
    public  static PreparedStatement pstmt;
    public  static ResultSet rs;

    @FXML
    private TextField tfPatientUID;
    @FXML
    private TextField tfPatientVorname;
    @FXML
    private TextField tfPatientName;
    @FXML
    private TextField tfPatientTelefonnummer;
    @FXML
    private TextField tfPatientAdresse;
    @FXML
    private TextField tfPatientSVN;
    @FXML
    private TextField tfPatientID;
    @FXML
    private TextField tfPatientBenutzername;
    @FXML
    private TextField tfPatientPasswort;
    @FXML
    private AnchorPane apPatientAddieren;

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
    private TextField tfArztSVN;
    @FXML
    private TextField tfArztID;
    @FXML
    private TextField tfArztBenutzername;
    @FXML
    private TextField tfArztPasswort;
    @FXML
    private AnchorPane apArztAddieren;

    @FXML
    private TextField tfSekreteriatUID;
    @FXML
    private TextField tfSekreteriatVorname;
    @FXML
    private TextField tfSekreteriatName;
    @FXML
    private TextField tfSekreteriatTelefonnummer;
    @FXML
    private TextField tfSekreteriatAdresse;
    @FXML
    private TextField tfSekreteriatSVN;
    @FXML
    private TextField tfSekreteriatID;
    @FXML
    private TextField tfSekreteriatBenutzername;
    @FXML
    private TextField tfSekreteriatPasswort;
    @FXML
    private AnchorPane apSekreteriatAddieren;

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
    private TextField tfVerwaltungspersonalSVN;
    @FXML
    private TextField tfVerwaltungspersonalID;
    @FXML
    private TextField tfVerwaltungspersonalBenutzername;
    @FXML
    private TextField tfVerwaltungspersonalPasswort;
    @FXML
    private AnchorPane apVerwaltungspersonalAddieren;

    @FXML
    public void getIncreasedPatientID(){
        String query = "SELECT * FROM sqlite_sequence WHERE name = 'Patient'";
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while(rs.next()){
                String str = Integer.toString(rs.getInt("seq") + 1);
                tfPatientUID.setText(str);
            }

        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void getPatientID(){
        String query = "SELECT * FROM Patient ORDER BY PatientID DESC LIMIT 1";
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while(rs.next()){
                String str = Integer.toString(rs.getInt("PatientID") + 1);
                tfPatientUID.setText(str);
            }

        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void clickPatientHinzufuegen(ActionEvent event) {
            getPatientID();
            if(apPatientAddieren.isVisible() == false){
                apPatientAddieren.setVisible(true);
                apArztAddieren.setVisible(false);
                apSekreteriatAddieren.setVisible(false);
                apVerwaltungspersonalAddieren.setVisible(false);
            }
            else
                apPatientAddieren.setVisible(false);
    }

    @FXML
    public void getIncreasedArztID(){
        String query = "SELECT * FROM sqlite_sequence WHERE name = 'Arzt'";
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while(rs.next()){
                String str = Integer.toString(rs.getInt("seq") + 1);
                tfArztUID.setText(str);
            }

        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void getArztID(){
        String query = "SELECT * FROM sqlite_sequence WHERE name = 'Arzt'";
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while(rs.next()){
                String str = Integer.toString(rs.getInt("seq"));
                tfArztUID.setText(str);
            }

        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void clickArztHinzufuegen(ActionEvent event) {
        getArztID();
        if(apArztAddieren.isVisible() == false){
            apArztAddieren.setVisible(true);
            apPatientAddieren.setVisible(false);
            apSekreteriatAddieren.setVisible(false);
            apVerwaltungspersonalAddieren.setVisible(false);
        }
        else
            apArztAddieren.setVisible(false);
    }

    @FXML
    public void getIncreasedSekreteriatID(){
        String query = "SELECT * FROM sqlite_sequence WHERE name = 'Sekretariat'";
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while(rs.next()){
                String str = Integer.toString(rs.getInt("seq") + 1);
                tfSekreteriatUID.setText(str);
            }

        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void getSekreteriatID(){
        String query = "SELECT * FROM sqlite_sequence WHERE name = 'Sekretariat'";
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while(rs.next()){
                String str = Integer.toString(rs.getInt("seq"));
                tfSekreteriatUID.setText(str);
            }

        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void clickSekreteriatHinzufuegen(ActionEvent event) {
        getSekreteriatID();
        if(apSekreteriatAddieren.isVisible() == false){
            apSekreteriatAddieren.setVisible(true);
            apPatientAddieren.setVisible(false);
            apArztAddieren.setVisible(false);
            apVerwaltungspersonalAddieren.setVisible(false);
        }
        else
            apSekreteriatAddieren.setVisible(false);
    }

    @FXML
    public void getIncreasedVerwaltungspersonalID(){
        String query = "SELECT * FROM sqlite_sequence WHERE name = 'Verwaltungspersonal'";
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while(rs.next()){
                String str = Integer.toString(rs.getInt("seq") + 1);
                tfVerwaltungspersonalUID.setText(str);
            }

        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void getVerwaltungspersonalID(){
        String query = "SELECT * FROM sqlite_sequence WHERE name = 'Verwaltungspersonal'";
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while(rs.next()){
                String str = Integer.toString(rs.getInt("seq"));
                tfVerwaltungspersonalUID.setText(str);
            }

        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void clickVerwaltungspersonalHinzufuegen(ActionEvent event) {
        getVerwaltungspersonalID();
        if(apVerwaltungspersonalAddieren.isVisible() == false){
            apVerwaltungspersonalAddieren.setVisible(true);
            apSekreteriatAddieren.setVisible(false);
            apPatientAddieren.setVisible(false);
            apArztAddieren.setVisible(false);
        }
        else
            apVerwaltungspersonalAddieren.setVisible(false);
    }

    //@FXML
    /*private void addPatient(ActionEvent event){
        getIncreasedPatientID();
        DBAddOps.insertPatient(Integer.parseInt(tfPatientUID.getText()),tfPatientVorname.getText(),tfPatientName.getText(),tfPatientTelefonnummer.getText(),tfPatientAdresse.getText(),tfPatientID.getText());
        DB.insertPatientUsernamePassword(Integer.parseInt(tfPatientUID.getText()),tfPatientBenutzername.getText(),tfPatientPasswort.getText());
        //DB.
        //System.out.println("----------------------------------------------------------\n" + "Informationen zur Person, die zur Datenbank addiert wurde:");
        //DB.printPersonInfo(Integer.parseInt(tfPatientPersonID.getText()));
        //System.out.println("----------------------------------------------------------");
    }*/

    @FXML
    private void addDoctor(ActionEvent event){
        //getIncreasedArztID();
        Arzt arzt = new Arzt(0,tfArztVorname.getText(),tfArztName.getText(),tfArztTelefonnummer.getText(),tfArztAdresse.getText(),tfArztID.getText(),tfArztSVN.getText(),tfArztBenutzername.getText(),tfArztPasswort.getText());
        DBAddOps.insertDoctor(arzt);

    }

    @FXML
    private void addSecretary(ActionEvent event) {
        //getIncreasedSekreteriatID();
        Sekretariat sekretariat = new Sekretariat(0, tfSekreteriatVorname.getText(), tfSekreteriatName.getText(), tfSekreteriatTelefonnummer.getText(), tfSekreteriatAdresse.getText(), tfSekreteriatID.getText(), tfSekreteriatSVN.getText(), tfSekreteriatBenutzername.getText(), tfSekreteriatPasswort.getText());
        DBAddOps.insertSecretary(sekretariat);
    }

    @FXML
    private void addManagementPersonnel(ActionEvent event){
        //getIncreasedVerwaltungspersonalID();
        Verwaltungspersonal verwaltungspersonal = new Verwaltungspersonal(0,tfVerwaltungspersonalVorname.getText(),tfVerwaltungspersonalName.getText(),tfVerwaltungspersonalTelefonnummer.getText(),tfVerwaltungspersonalAdresse.getText(),tfVerwaltungspersonalID.getText(),tfVerwaltungspersonalSVN.getText(),tfVerwaltungspersonalBenutzername.getText(),tfVerwaltungspersonalPasswort.getText());
        DBAddOps.insertManagementPersonnel(verwaltungspersonal);
        //DBAddOps.insertManagementPersonnel(Integer.parseInt(tfVerwaltungspersonalUID.getText()),tfVerwaltungspersonalVorname.getText(),tfVerwaltungspersonalName.getText(),tfVerwaltungspersonalTelefonnummer.getText(),tfVerwaltungspersonalAdresse.getText(),tfVerwaltungspersonalID.getText(),tfVerwaltungspersonalSVN.getText(),tfVerwaltungspersonalBenutzername.getText(),tfVerwaltungspersonalPasswort.getText());

    }


    /*@FXML
    private void loadPatientAdd(ActionEvent event) {
        loadFunction("PatientAddieren");
    }


    private void loadFunction(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
            apAddieren.getChildren().removeAll();
            apAddieren.getChildren().add(root);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}
