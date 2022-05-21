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
