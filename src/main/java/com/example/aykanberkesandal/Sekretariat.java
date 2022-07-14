package com.example.aykanberkesandal;

public class Sekretariat extends Personal  {
    private  int sekretariatID;

    Sekretariat(int sekretariatID, String vorname, String name, String adresse, String telefonnummer, String ID, String svn, String benutzername, String passwort){
        super(vorname, name, adresse, telefonnummer, ID, svn, benutzername, passwort);
        this.sekretariatID = sekretariatID;
    }

    Sekretariat(int sekretariatID, String vorname, String name, String adresse, String telefonnummer, String ID, String svn){
        super(vorname, name, adresse, telefonnummer, ID, svn);
        this.sekretariatID = sekretariatID;
    }

    public  int getSekretariatID() {
        return sekretariatID;
    }
    public void setSekretariatID(int sekreteriatID) {
        this.sekretariatID = sekretariatID;
    }
}

