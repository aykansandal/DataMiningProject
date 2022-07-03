package com.example.aykanberkesandal;

public class Personal extends Person {
    private static String svn;
    private static String benutzername;
    private static String passwort;

    Personal(String vorname, String name, String adresse, String telefonnummer, String ID, String svn, String benutzername, String passwort){
        super(vorname,name,adresse,telefonnummer,ID);
        this.svn = svn;
    }

    Personal(String vorname, String name, String adresse, String telefonnummer, String ID, String svn){
        super(vorname,name,adresse,telefonnummer,ID);
        this.svn = svn;
    }

    public static String getSVN() {
        return svn;
    }
    public void setSVN(String svn) {
        this.svn = svn;
    }
    public static String getBenutzername() {
        return benutzername;
    }
    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }
    public static String getPasswort() {
        return passwort;
    }
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
}
