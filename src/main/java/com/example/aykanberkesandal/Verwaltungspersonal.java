package com.example.aykanberkesandal;

public class Verwaltungspersonal extends Personal  {
    private int verwaltungspersonalID;

    Verwaltungspersonal(int verwaltungspersonalID, String vorname, String name, String adresse, String telefonnummer, String ID, String svn, String benutzername, String passwort){
        super(vorname, name, adresse, telefonnummer, ID, svn, benutzername, passwort);
        this.verwaltungspersonalID = verwaltungspersonalID;
    }

    Verwaltungspersonal(int verwaltungspersonalID, String vorname, String name, String adresse, String telefonnummer, String ID, String svn){
        super(vorname, name, adresse, telefonnummer, ID, svn);
        this.verwaltungspersonalID = verwaltungspersonalID;
    }

    public static int getVerwaltungspersonalID() {
        return verwaltungspersonalID;
    }
    public void setVerwaltungspersonalID(int verwaltungspersonalID) {
        this.verwaltungspersonalID = verwaltungspersonalID;
    }
}
