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

    public static void connect() {
        try {
            // DB Parameter
            String url = "jdbc:sqlite:C:\\Users\\Aykan\\IdeaProjects\\190503012_AykanBerkeSandal\\sqlite3\\DB.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            checkDBStatus();

            /*Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Person");
            while(res.next()){
                System.out.println("PersonID: "+res.getString("PersonID") + "Bruh:" + res.getString("Field2"));
            }*/
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
                System.out.println("Database is connected.");
            }
            else{
                System.out.println("Database is not connected.");
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




    /*public boolean checkLogin(String benutzername, String passwort){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String query = "SELECT benutzername, passwort FROM Person WHERE benutzername = ? AND passwort = ?";
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,benutzername);
            preparedStatement.setString(2,passwort);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
                return true;
            else
                return false;
        }
        catch (Exception e){
            return false;
        }
        finally {
            preparedStatement.close();
            resultSet.close();
        }
    }*/

    /*public static boolean checkLogin(String benutzername, String passwort){
        String query = "SELECT benutzername, passwort FROM Person WHERE benutzername = ? AND passwort = ?;";
        PreparedStatement.setString(1, benutzername);
        PreparedStatement.setString(2, passwort);

        ResultSet res = stmt.executeQuery(query);
        while(res.next()) {
            System.out.println("Login erfolgreich");
            return true;
        }
        return false;
    }*/

}
