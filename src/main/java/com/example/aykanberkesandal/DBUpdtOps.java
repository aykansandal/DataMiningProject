package com.example.aykanberkesandal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.lang.String;

import java.io.IOException;
import java.sql.*;
import java.util.Set;
import java.sql.SQLException;

public class DBUpdtOps {
    public static Statement stmt;
    public  static PreparedStatement pstmt;
    public  static ResultSet rs;

    public static void updatePatient(Patient patient){
        try {
            String query = "UPDATE Patient SET Vorname = ?, Name = ?, Telefonnummer = ?, Adresse = ?, ID = ? WHERE PatientID = ?";
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setString(1, patient.getVorname());
            pstmt.setString(2, patient.getName());
            pstmt.setString(3, patient.getTelefonnummer());
            pstmt.setString(4, patient.getAdresse());
            pstmt.setString(5, patient.getID());
            pstmt.setInt(6,patient.getPatientID());
            pstmt.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateTermin(Termin termin){
        try {
            String query = "UPDATE Termin SET Datum = ?, ArztName = ?, PatientName = ? WHERE TerminID = ?";
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setString(1, termin.getDatum());
            pstmt.setString(2, termin.getArztName());
            pstmt.setString(3, termin.getPatientName());
            pstmt.setInt(4,termin.getTerminID());
            pstmt.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateArzt(Arzt arzt){
        try {
            String query = "UPDATE Arzt SET Vorname = ?, Name = ?, Telefonnummer = ?, Adresse = ?, ID = ?, SVN = ?, Benutzername = ?, Passwort = ? WHERE ArztID = ?";
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setString(1, arzt.getVorname());
            pstmt.setString(2, arzt.getName());
            pstmt.setString(3, arzt.getTelefonnummer());
            pstmt.setString(4, arzt.getAdresse());
            pstmt.setString(5, arzt.getID());
            pstmt.setString(6, arzt.getSvn());
            pstmt.setString(7, arzt.getBenutzername());
            pstmt.setString(8, arzt.getPasswort());
            pstmt.setInt(9,arzt.getArztID());
            pstmt.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*public static void updateArztBP(Arzt arzt){
        try {
            String query = "UPDATE Benutzer SET Benutzername = ?, Passwort = ? WHERE (SELECT ArztID  = ?)";
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setString(1, arzt.getVorname());
            pstmt.setString(2, arzt.getName());
            pstmt.setInt(3,);
            pstmt.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/

    public static void updateSekretariat(Sekretariat sekretariat){
        try {
            String query = "UPDATE Sekretariat SET Vorname = ?, Name = ?, Telefonnummer = ?, Adresse = ?, ID = ?, SVN = ?, Benutzername = ?, Passwort = ? WHERE SekretariatID = ?";
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setString(1, sekretariat.getVorname());
            pstmt.setString(2, sekretariat.getName());
            pstmt.setString(3, sekretariat.getTelefonnummer());
            pstmt.setString(4, sekretariat.getAdresse());
            pstmt.setString(5, sekretariat.getID());
            pstmt.setString(6, sekretariat.getSvn());
            pstmt.setString(7, sekretariat.getBenutzername());
            pstmt.setString(8, sekretariat.getPasswort());
            pstmt.setInt(9,sekretariat.getSekretariatID());
            pstmt.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateVerwaltungspersonal(Verwaltungspersonal verwaltungspersonal){
        try {
            String query = "UPDATE Verwaltungspersonal SET Vorname = ?, Name = ?, Telefonnummer = ?, Adresse = ?, ID = ?, SVN = ?, Benutzername = ?, Passwort = ? WHERE VerwaltungspersonalID = ?";
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setString(1, verwaltungspersonal.getVorname());
            pstmt.setString(2, verwaltungspersonal.getName());
            pstmt.setString(3, verwaltungspersonal.getTelefonnummer());
            pstmt.setString(4, verwaltungspersonal.getAdresse());
            pstmt.setString(5, verwaltungspersonal.getID());
            pstmt.setString(6, verwaltungspersonal.getSvn());
            pstmt.setString(7, verwaltungspersonal.getBenutzername());
            pstmt.setString(8, verwaltungspersonal.getPasswort());
            pstmt.setInt(9,verwaltungspersonal.getVerwaltungspersonalID());
            pstmt.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*public static void updatePatient(String Vorname, String Name, String Telefonnummer, String Adresse, String ID, String SVN, String Benutzername, String Passwort, int PatientID2){
        try {
            String query = "UPDATE Patient SET Vorname = ?, Name = ?, Telefonnummer = ?, Adresse = ?, ID = ?, SVN = ?, Benutzername = ?, Passwort = ? WHERE PatientID = ?";
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setString(1, Vorname);
            pstmt.setString(2, Name);
            pstmt.setString(3, Telefonnummer);
            pstmt.setString(4, Adresse);
            pstmt.setString(5, ID);
            pstmt.setString(6, SVN);
            pstmt.setString(7,Benutzername);
            pstmt.setString(8,Passwort);
            pstmt.setInt(9,PatientID2);
            pstmt.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/
}
