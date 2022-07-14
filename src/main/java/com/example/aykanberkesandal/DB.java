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

    public static String giveRoleOfCurrentUser(){
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
                        return "Verwaltungspersonal";
                    else if(i == 2)
                        return "Arzt";
                    else if(i == 3)
                        return  "Sekretariat";
                    else
                        return"ERROR";

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(i);

        return "ERROR";
    }

    public static int getUserID(){
        String query = "SELECT seq FROM sqlite_sequence WHERE name ='Benutzer'";
        int patientID = 0;
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()){
                patientID = rs.getInt("seq") + 1;

            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return patientID;
    }

    public static int getPatientID(){
        String query = "SELECT seq FROM sqlite_sequence WHERE name ='Patient'";
        int patientID = 0;
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()){
                patientID = rs.getInt("seq");

            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return patientID;
    }

    public static int getIncreasedPatientID(){
        String query = "SELECT seq FROM sqlite_sequence WHERE name ='Patient'";
        int patientID = 0;
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()){
                patientID = rs.getInt("seq") + 1;

            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return patientID;
    }

    public static int decreasePatientID(){
        String query = "SELECT seq FROM sqlite_sequence WHERE name ='Patient'";
        int patientID = 0;
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()){
                patientID = rs.getInt("seq") - 1;

            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return patientID;
    }

    public static int getTerminID(){
        String query = "SELECT seq FROM sqlite_sequence WHERE name ='Termin'";
        int terminID = 0;
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()){
                terminID = rs.getInt("seq");

            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return terminID;
    }

    public static int getIncreasedTerminID(){
        String query = "SELECT seq FROM sqlite_sequence WHERE name ='Termin'";
        int terminID = 0;
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()){
                terminID = rs.getInt("seq") + 1;

            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return terminID;
    }

    public static int decreaseTerminID(){
        String query = "SELECT seq FROM sqlite_sequence WHERE name ='Termin'";
        int terminID = 0;
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()){
                terminID = rs.getInt("seq") - 1;

            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return terminID;
    }

    public static int getArztID(){
        String query = "SELECT seq FROM sqlite_sequence WHERE name ='Arzt'";
        int arztID = 0;
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()){
                arztID = rs.getInt("seq");

            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return arztID;
    }

    public static int getIncreasedArztID(){
        String query = "SELECT seq FROM sqlite_sequence WHERE name ='Arzt'";
        int arztID = 0;
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()){
                arztID = rs.getInt("seq") + 1;

            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return arztID;
    }

    public static int decreaseArztID(){
        String query = "SELECT seq FROM sqlite_sequence WHERE name ='Arzt'";
        int arztID = 0;
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()){
                arztID = rs.getInt("seq") - 1;

            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return arztID;
    }

    public static int getSekretariatID(){
        String query = "SELECT seq FROM sqlite_sequence WHERE name ='Sekretariat'";
        int sekretariatID = 0;
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()){
                sekretariatID = rs.getInt("seq");

            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return sekretariatID;
    }

    public static int getIncreasedSekretariatID(){
        String query = "SELECT seq FROM sqlite_sequence WHERE name ='Sekretariat'";
        int sekretariatID = 0;
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()){
                sekretariatID = rs.getInt("seq") + 1;

            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return sekretariatID;
    }

    public static int decreaseSekretariatID(){
        String query = "SELECT seq FROM sqlite_sequence WHERE name ='Sekretariat'";
        int sekretariatID = 0;
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()){
                sekretariatID = rs.getInt("seq") - 1;

            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return sekretariatID;
    }

    public static int getVerwaltungspersonalID(){
        String query = "SELECT seq FROM sqlite_sequence WHERE name ='Verwaltungspersonal'";
        int verwaltungspersonalID = 0;
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()){
                verwaltungspersonalID = rs.getInt("seq");

            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return verwaltungspersonalID;
    }

    public static int getIncreasedVerwaltungspersonalID(){
        String query = "SELECT seq FROM sqlite_sequence WHERE name ='Verwaltungspersonal'";
        int verwaltungspersonalID = 0;
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()){
                verwaltungspersonalID = rs.getInt("seq") + 1;

            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return verwaltungspersonalID;
    }

    public static int decreaseVerwaltungspersonalID(){
        String query = "SELECT seq FROM sqlite_sequence WHERE name ='Verwaltungspersonal'";
        int verwaltungspersonalID = 0;
        try {
            pstmt = DB.conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()){
                verwaltungspersonalID = rs.getInt("seq") - 1;

            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return verwaltungspersonalID;
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
        String query = "UPDATE sqlite_sequence SET seq = ? WHERE name = 'Sekretariat'";
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
        String query = "SELECT seq FROM sqlite_sequence WHERE name = 'Sekretariat'";

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

    public static String[] findPatient(int patientID2){
        String vorname = "", name = "",telefonnummer = "", adresse ="", ID = "", SVN = "";

        try {
            String query = "SELECT * FROM Patient WHERE PatientID = ?";

                pstmt = DB.conn.prepareStatement(query);
                pstmt.setInt(1,patientID2);
                rs = pstmt.executeQuery();

                while(rs.next()){
                    vorname = rs.getString("Vorname");
                    name = rs.getString("Name");
                    telefonnummer = rs.getString("Telefonnummer");
                    adresse = rs.getString("Adresse");
                    ID = rs.getString("ID");
                    SVN = rs.getString("SVN");
                }

        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return new String[]{vorname,name,telefonnummer,adresse,ID,SVN};
    }

    public static String[] findTermin(int terminID2){
        String datum = "", arztName = "",patientName = "";

        try {
            String query = "SELECT * FROM Termin WHERE TerminID = ?";

            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1,terminID2);
            rs = pstmt.executeQuery();

            while(rs.next()){
                datum = rs.getString("Datum");
                arztName = rs.getString("ArztName");
                patientName = rs.getString("PatientName");
            }

        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return new String[]{datum,arztName,patientName};
    }

    public static String[] findArzt(int arztID2){
        String vorname = "", name = "",telefonnummer = "", adresse ="", ID = "", SVN = "", benutzername = "", passwort = "";

        try {
            String query = "SELECT * FROM Arzt WHERE ArztID = ?";

            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1,arztID2);
            rs = pstmt.executeQuery();

            while(rs.next()){
                vorname = rs.getString("Vorname");
                name = rs.getString("Name");
                telefonnummer = rs.getString("Telefonnummer");
                adresse = rs.getString("Adresse");
                ID = rs.getString("ID");
                SVN = rs.getString("SVN");
                benutzername = rs.getString("Benutzername");
                passwort = rs.getString("Passwort");
            }

        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return new String[]{vorname, name, telefonnummer, adresse, ID, SVN, benutzername, passwort};
    }

    public static String[] findSekretariat(int sekretariatID2){
        String vorname = "", name = "",telefonnummer = "", adresse ="", ID = "", SVN = "", benutzername = "", passwort = "";

        try {
            String query = "SELECT * FROM Sekretariat WHERE SekretariatID = ?";

            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1,sekretariatID2);
            rs = pstmt.executeQuery();

            while(rs.next()){
                vorname = rs.getString("Vorname");
                name = rs.getString("Name");
                telefonnummer = rs.getString("Telefonnummer");
                adresse = rs.getString("Adresse");
                ID = rs.getString("ID");
                SVN = rs.getString("SVN");
                benutzername = rs.getString("Benutzername");
                passwort = rs.getString("Passwort");
            }

        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return new String[]{vorname, name, telefonnummer, adresse, ID, SVN, benutzername, passwort};
    }

    public static String[] findVerwaltungspersonal(int verwaltungspersonalID2){
        String vorname = "", name = "",telefonnummer = "", adresse ="", ID = "", SVN = "", benutzername = "", passwort = "";

        try {
            String query = "SELECT * FROM Verwaltungspersonal WHERE VerwaltungspersonalID = ?";

            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1,verwaltungspersonalID2);
            rs = pstmt.executeQuery();

            while(rs.next()){
                vorname = rs.getString("Vorname");
                name = rs.getString("Name");
                telefonnummer = rs.getString("Telefonnummer");
                adresse = rs.getString("Adresse");
                ID = rs.getString("ID");
                SVN = rs.getString("SVN");
                benutzername = rs.getString("Benutzername");
                passwort = rs.getString("Passwort");
            }

        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return new String[]{vorname, name, telefonnummer, adresse, ID, SVN, benutzername, passwort};
    }


}
