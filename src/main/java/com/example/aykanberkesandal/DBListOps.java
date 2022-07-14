package com.example.aykanberkesandal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.String;

import java.sql.*;
import java.sql.SQLException;

public class DBListOps {
    public static Statement stmt;
    public  static PreparedStatement pstmt;
    public  static ResultSet rs;


    /*public static ObservableList<Patient> listPatient(){
        ObservableList<Patient> oblist = FXCollections.observableArrayList();
        String query ="SELECT PatientID,Vorname,Name,Telefonnummer,Adresse,ID  FROM Patient";
        PreparedStatement pstmt;
        ResultSet rs;
        try{
            pstmt = DB.conn.prepareStatement(query);
            //rs = conn.createStatement().executeQuery("SELECT PatientID,Vorname,Name,Telefonnummer,Adresse,ID  FROM Patient");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                oblist.add(new Patient(rs.getInt("PatientID"), rs.getString("Vorname"), rs.getString("Name"), rs.getString("Telefonnummer"), rs.getString("Adresse"), rs.getString("ID")));
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return oblist;
    }*/
    public static ObservableList<Patient> listPatient(){
        String query = "SELECT * FROM Patient";
        ObservableList<Patient> oblist = FXCollections.observableArrayList();

        try{
            Statement statement = DB.conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                //System.out.println(rs.getString("Vorname"));
                Patient patient = new Patient(rs.getInt("PatientID"), rs.getString("Vorname"), rs.getString("Name"), rs.getString("Telefonnummer"), rs.getString("Adresse"), rs.getString("ID"));
                oblist.add(patient);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return oblist;
    }

    public static ObservableList<Termin> listTermin(){
        String query = "SELECT * FROM Termin";
        ObservableList<Termin> oblist = FXCollections.observableArrayList();

        try{

            Statement statement = DB.conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                Termin termin = new Termin(rs.getInt("TerminID"), rs.getString("ArztName"), rs.getString("PatientName"), rs.getString("Datum"));
                oblist.add(termin);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return oblist;
    }

    public static ObservableList<Arzt> listArzt(){
        ObservableList<Arzt> oblist = FXCollections.observableArrayList();
        String query ="SELECT ArztID,Vorname,Name,Telefonnummer,Adresse,ID,SVN FROM Arzt";
        try{
            pstmt = DB.conn.prepareStatement(query);
            //rs = conn.createStatement().executeQuery("SELECT PatientID,Vorname,Name,Telefonnummer,Adresse,ID  FROM Patient");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                oblist.add(new Arzt(rs.getInt("ArztID"), rs.getString("Vorname"), rs.getString("Name"), rs.getString("Telefonnummer"), rs.getString("Adresse"), rs.getString("ID"), rs.getString("SVN")));
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return oblist;
    }

    public static ObservableList<Sekretariat> listSekretariat(){
        ObservableList<Sekretariat> oblist = FXCollections.observableArrayList();
        String query ="SELECT SekretariatID,Vorname,Name,Telefonnummer,Adresse,ID,SVN FROM Sekretariat";
        try{
            pstmt = DB.conn.prepareStatement(query);
            //rs = conn.createStatement().executeQuery("SELECT PatientID,Vorname,Name,Telefonnummer,Adresse,ID  FROM Patient");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                oblist.add(new Sekretariat(rs.getInt("SekretariatID"), rs.getString("Vorname"), rs.getString("Name"), rs.getString("Telefonnummer"), rs.getString("Adresse"), rs.getString("ID"), rs.getString("SVN")));
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return oblist;
    }


    public static ObservableList<Verwaltungspersonal> listVerwaltungspersonal(){
        ObservableList<Verwaltungspersonal> oblist = FXCollections.observableArrayList();
        String query ="SELECT VerwaltungspersonalID,Vorname,Name,Telefonnummer,Adresse,ID,SVN FROM Verwaltungspersonal";
        try{
            pstmt = DB.conn.prepareStatement(query);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                oblist.add(new Verwaltungspersonal(rs.getInt("VerwaltungspersonalID"), rs.getString("Vorname"), rs.getString("Name"), rs.getString("Telefonnummer"), rs.getString("Adresse"), rs.getString("ID"), rs.getString("SVN")));
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return oblist;
    }
}
