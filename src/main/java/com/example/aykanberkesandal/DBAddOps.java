package com.example.aykanberkesandal;

import java.lang.String;

import java.sql.*;
import java.sql.SQLException;

public class DBAddOps {
    public static Statement stmt;
    public  static PreparedStatement pstmt;
    public  static ResultSet rs;



    /*public static void insertDoctor(int ArztID,String Vorname, String Name, String Telefonnummer, String Adresse, String ID, String SVN, String Benutzername, String Passwort) {
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
    }*/
    public static void insertPatient(Patient patient) {

        try {
            String query = "INSERT INTO Patient(PatientID,Vorname,Name,Telefonnummer,Adresse,ID) VALUES(?,?,?,?,?,?)";
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, patient.getPatientID());
            pstmt.setString(2, patient.getVorname());
            pstmt.setString(3, patient.getName());
            pstmt.setString(4, patient.getTelefonnummer());
            pstmt.setString(5, patient.getAdresse());
            pstmt.setString(6, patient.getID());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertTermin(Termin termin) {

        try {
            String query = "INSERT INTO Termin(TerminID,Datum,ArztName,PatientName) VALUES(?,?,?,?)";
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, termin.getTerminID());
            pstmt.setString(2, termin.getDatum());
            pstmt.setString(3, termin.getArztName());
            pstmt.setString(4, termin.getPatientName());


            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertDoctor(Arzt arzt) {

        try {
            String query = "INSERT INTO Arzt(ArztID,Vorname,Name,Telefonnummer,Adresse,ID,SVN,Benutzername,Passwort) VALUES(?,?,?,?,?,?,?,?,?)";
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, arzt.getArztID());
            pstmt.setString(2, arzt.getVorname());
            pstmt.setString(3, arzt.getName());
            pstmt.setString(4, arzt.getTelefonnummer());
            pstmt.setString(5, arzt.getAdresse());
            pstmt.setString(6, arzt.getID());
            pstmt.setString(7, arzt.getSvn());
            pstmt.setString(8, arzt.getBenutzername());
            pstmt.setString(9, arzt.getPasswort());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertDoctorBP(Arzt arzt) {

        try {
            String query = "INSERT INTO Benutzer(BenutzerID,Benutzername,Passwort,Rolle) VALUES(?,?,?,?)";
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, DB.getUserID()); //TODO HALLET BRO
            pstmt.setString(2, arzt.getBenutzername());
            pstmt.setString(3, arzt.getPasswort());
            pstmt.setInt(4, 2);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertSecretary(Sekretariat sekretariat) {
        try {
            String query = "INSERT INTO Sekretariat(SekretariatID,Vorname,Name,Telefonnummer,Adresse,ID,SVN,Benutzername,Passwort) VALUES(?,?,?,?,?,?,?,?,?)";
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, sekretariat.getSekretariatID());
            pstmt.setString(2, sekretariat.getVorname());
            pstmt.setString(3, sekretariat.getName());
            pstmt.setString(4, sekretariat.getTelefonnummer());
            pstmt.setString(5, sekretariat.getAdresse());
            pstmt.setString(6, sekretariat.getID());
            pstmt.setString(7, sekretariat.getSvn());
            pstmt.setString(8, sekretariat.getBenutzername());
            pstmt.setString(9, sekretariat.getPasswort());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertSecretaryBP(Sekretariat sekretariat) {

        try {
            String query = "INSERT INTO Benutzer(BenutzerID,Benutzername,Passwort,Rolle) VALUES(?,?,?,?)";
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, DB.getUserID()); //TODO HALLET BRO
            pstmt.setString(2, sekretariat.getBenutzername());
            pstmt.setString(3, sekretariat.getPasswort());
            pstmt.setInt(4, 3);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*public static void insertManagementPersonnel(int VerwaltungspersonalID,String Vorname, String Name, String Telefonnummer, String Adresse, String ID, String SVN, String Benutzername, String Passwort) {
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
    }*/

    public static void insertManagementPersonnel(Verwaltungspersonal verwaltungspersonal) {
        String query = "INSERT INTO Verwaltungspersonal(VerwaltungspersonalID,Vorname,Name,Telefonnummer,Adresse,ID,SVN,Benutzername,Passwort) VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, verwaltungspersonal.getVerwaltungspersonalID());
            pstmt.setString(2, verwaltungspersonal.getVorname());
            pstmt.setString(3, verwaltungspersonal.getName());
            pstmt.setString(4, verwaltungspersonal.getTelefonnummer());
            pstmt.setString(5, verwaltungspersonal.getAdresse());
            pstmt.setString(6, verwaltungspersonal.getID());
            pstmt.setString(7, verwaltungspersonal.getSvn());
            pstmt.setString(8, verwaltungspersonal.getBenutzername());
            pstmt.setString(9, verwaltungspersonal.getPasswort());


            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertManagementPersonnelBP(Verwaltungspersonal verwaltungspersonal) {

        try {
            String query = "INSERT INTO Benutzer(BenutzerID,Benutzername,Passwort,Rolle) VALUES(?,?,?,?)";
            pstmt = DB.conn.prepareStatement(query);
            pstmt.setInt(1, DB.getUserID()); //TODO HALLET BRO
            pstmt.setString(2, verwaltungspersonal.getBenutzername());
            pstmt.setString(3, verwaltungspersonal.getPasswort());
            pstmt.setInt(4, 1);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
