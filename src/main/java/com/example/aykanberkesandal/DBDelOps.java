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

public class DBDelOps {
    public static Statement stmt;
    public  static PreparedStatement pstmt;
    public  static ResultSet rs;

    /*public static void deletePatient(int patientID) {
        //insertDecreasedPatientID();
        String query = "DELETE FROM Patient WHERE PatientID = ?";

        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, patientID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/

    public static void deletePatient(Patient patient) {
        //insertDecreasedPatientID();
        String query = "DELETE FROM Patient WHERE PatientID = ?";

        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, patient.getPatientID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteDoctor(Arzt arzt) {
        //insertDecreasedDoctorID();
        String query = "DELETE FROM Arzt WHERE ArztID = ?";

        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, arzt.getArztID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteSecretary(Sekretariat sekretariat) {
        //insertDecreasedSecretaryID();
        String query = "DELETE FROM Sekretariat WHERE SekretariatID = ?";

        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, sekretariat.getSekretariatID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteManagementPersonnel(Verwaltungspersonal verwaltungspersonal) {
        //insertDecreasedManagementPesonnelID();
        String query = "DELETE FROM Verwaltungspersonal WHERE VerwaltungspersonalID = ?";

        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, verwaltungspersonal.getVerwaltungspersonalID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteTermin(Termin termin) {
        String query = "DELETE FROM Termin WHERE TerminID = ?";

        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, termin.getTerminID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
