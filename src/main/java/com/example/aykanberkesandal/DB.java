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

public class DB {
    public static Connection conn = null;
    public static Statement stmt;
    public  static PreparedStatement pstmt;
    public  static ResultSet rs;

    //TODO:Update-delete-insert

    public static void connect() {
        try {
            // DB Parameter
            String url = "jdbc:sqlite:C:\\Users\\Aykan\\IdeaProjects\\190503012_AykanBerkeSandal\\sqlite3\\DB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            checkDBStatus();


        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isDBconnected() {
        try{
            if(!conn.isClosed()){
                return true;
            }
            else{
                return false;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public static void checkDBStatus(){
        try{
            if(!conn.isClosed()){
                System.out.println("Die Datenbank ist verbunden.");
            }
            else{
                System.out.println("Die Datenbank is nicht verbunden.");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static Boolean checkLogin(String benutzername, String passwort) {
        String query = "SELECT Benutzername, Passwort FROM Benutzer WHERE Benutzername = ? AND Passwort = ?";
        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setString(1, benutzername);
            pstmt.setString(2, passwort);
            rs = pstmt.executeQuery();
            if(rs.next())
                return true;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static  String giveRoleOfCurrentUser(){
        String query = "SELECT Benutzername, Passwort, Rolle FROM Benutzer WHERE Benutzername = ? AND Passwort = ?";
        int i = 0;
        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setString(1, rs.getString("Benutzername"));
            pstmt.setString(2, rs.getString("Passwort"));
            rs = pstmt.executeQuery();
            while(rs.next())
                i = rs.getInt("Rolle");
                    if(i == 1)
                        return "Patient";
                    else if(i == 2)
                        return "Arzt";
                    else if(i == 3)
                        return  "Sekreteriat";
                    else if(i == 4)
                        return "Verwaltungspersonal";
                    else
                        return"ERROR";

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(i);

        return "ERROR";
    }


    public static void insertPerson(int personID, String benutzername, String passwort) {
        String query = "INSERT INTO Person(PersonID,Benutzername,Passwort) VALUES(?,?,?)";

        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, personID);
            pstmt.setString(2, benutzername);
            pstmt.setString(3, passwort);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deletePerson(int personID) {
        String query = "DELETE FROM Person WHERE personID = ?";

        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, personID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    public static void insertPatientUsernamePassword(int BenutzerID, String Benutzername, String Passwort){


        try {
            String query =  "INSERT INTO Benutzer(BenutzerID,Benutzername,Passwort,Rolle) VALUES (?,?,?,?)";
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, BenutzerID);
            pstmt.setString(2, Benutzername);
            pstmt.setString(3, Passwort);
            pstmt.setInt(4, 1);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void insertDecreasedPatientID(){
        int patientID = decreasePatientID();
        String query = "UPDATE sqlite_sequence SET seq = ? WHERE name = 'Patient'";
        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, patientID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public static int decreasePatientID(){
        int id = 0;
        String query = "SELECT seq FROM sqlite_sequence WHERE name = 'Patient'";

        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while(rs.next()){
            id = rs.getInt("seq") - 1;

            }

        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }






    public static void insertDecreasedDoctorID(){
        int doctorID = decreaseDoctorID();
        String query = "UPDATE sqlite_sequence SET seq = ? WHERE name = 'Arzt'";
        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, doctorID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public static int decreaseDoctorID(){
        int id = 0;
        String query = "SELECT seq FROM sqlite_sequence WHERE name = 'Arzt'";

        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while(rs.next()){
                id = rs.getInt("seq") - 1;

            }

        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }





    public static void insertDecreasedSecretaryID(){
        int secretaryID = decreaseSecretaryID();
        String query = "UPDATE sqlite_sequence SET seq = ? WHERE name = 'Sekreteriat'";
        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, secretaryID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public static int decreaseSecretaryID(){
        int id = 0;
        String query = "SELECT seq FROM sqlite_sequence WHERE name = 'Sekreteriat'";

        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while(rs.next()){
                id = rs.getInt("seq") - 1;

            }

        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }





    public static void insertDecreasedManagementPesonnelID(){
        int managementPersonnelID = decreaseManagementPesonnelID();
        String query = "UPDATE sqlite_sequence SET seq = ? WHERE name = 'Verwaltungspersonal'";
        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, managementPersonnelID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public static int decreaseManagementPesonnelID(){
        int id = 0;
        String query = "SELECT seq FROM sqlite_sequence WHERE name = 'Verwaltungspersonal'";

        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while(rs.next()){
                id = rs.getInt("seq") - 1;

            }

        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }



    public static void printPersonInfo(int personID) {
        String query = "SELECT * FROM Person WHERE personID = ?";

        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, personID);
            rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.println("PersonID:" + rs.getInt("personID") + "|" + "Benutzername:" + rs.getString("benutzername") + "|" + "Passwort:" + rs.getString("passwort"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }











    public static String[] findPatient(int PatientID2){
        String Vorname = "", Name = "",Telefonnummer = "", Adresse ="", ID = "", SVN = "", Benutzername = "", Passwort = "";

        try {
            String query = "SELECT * FROM Patient WHERE PatientID = ?";

                pstmt = DB.conn.prepareStatement(query);
                pstmt.setInt(1,PatientID2);
                rs = pstmt.executeQuery();

                while(rs.next()){
                    Vorname = rs.getString("Vorname");
                    Name = rs.getString("Name");
                    Telefonnummer = rs.getString("Telefonnummer");
                    Adresse = rs.getString("Adresse");
                    ID = rs.getString("ID");
                    SVN = rs.getString("SVN");
                    Benutzername = rs.getString("Benutzername");
                    Passwort = rs.getString("Passwort");
                }

        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return new String[]{Vorname,Name,Telefonnummer,Adresse,ID,SVN,Benutzername,Passwort};
    }


}
