package com.example.aykanberkesandal;
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
        String query = "SELECT benutzername, passwort FROM Person WHERE benutzername = ? AND passwort = ?";
        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setString(1, benutzername);
            pstmt.setString(2, passwort);
            rs = pstmt.executeQuery();
            if(rs.next())
                return true;
        }
        catch (Exception e) {

        }
        return false;
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

    public static void insertDoctor(int ArztID,String Vorname, String Name, String Telefonnummer, String Adresse, String ID, String SVN, String Benutzername, String Passwort) {
        String query = "INSERT INTO Arzt(ArztID,Vorname,Name,Telefonnummer,Adresse,ID,SVN,Benutzername,Passwort) VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, ArztID);
            pstmt.setString(2, Vorname);
            pstmt.setString(3, Name);
            pstmt.setString(4, Telefonnummer);
            pstmt.setString(5, Adresse);
            pstmt.setString(6, ID);
            pstmt.setString(7, SVN);
            pstmt.setString(8, Benutzername);
            pstmt.setString(9, Passwort);


            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteDoctor(int doctorID) {
        String query = "DELETE FROM Person WHERE ArztID = ?";

        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, doctorID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertSecretary(int SekreteriatID,String Vorname, String Name, String Telefonnummer, String Adresse, String ID, String SVN, String Benutzername, String Passwort) {
        String query = "INSERT INTO Sekreteriat(SekreteriatID,Vorname,Name,Telefonnummer,Adresse,ID,SVN,Benutzername,Passwort) VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, SekreteriatID);
            pstmt.setString(2, Vorname);
            pstmt.setString(3, Name);
            pstmt.setString(4, Telefonnummer);
            pstmt.setString(5, Adresse);
            pstmt.setString(6, ID);
            pstmt.setString(7, SVN);
            pstmt.setString(8, Benutzername);
            pstmt.setString(9, Passwort);


            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteSecretary(int secretaryID) {
        String query = "DELETE FROM Person WHERE SekreteriatID = ?";

        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, secretaryID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertManagementPersonnel(int VerwaltungspersonalID,String Vorname, String Name, String Telefonnummer, String Adresse, String ID, String SVN, String Benutzername, String Passwort) {
        String query = "INSERT INTO Verwaltungspersonal(VerwaltungspersonalID,Vorname,Name,Telefonnummer,Adresse,ID,SVN,Benutzername,Passwort) VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, VerwaltungspersonalID);
            pstmt.setString(2, Vorname);
            pstmt.setString(3, Name);
            pstmt.setString(4, Telefonnummer);
            pstmt.setString(5, Adresse);
            pstmt.setString(6, ID);
            pstmt.setString(7, SVN);
            pstmt.setString(8, Benutzername);
            pstmt.setString(9, Passwort);


            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteManagementPersonnel(int secretaryID) {
        String query = "DELETE FROM Person WHERE VerwaltungspersonalID = ?";

        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, secretaryID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
}
