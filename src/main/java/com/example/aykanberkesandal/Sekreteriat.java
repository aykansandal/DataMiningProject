package com.example.aykanberkesandal;

public class Sekreteriat extends Personal  {
    private int sekreteriatID;

    Sekreteriat(int sekreteriatID, String vorname, String name, String adresse, String telefonnummer, String ID, String svn, String benutzername, String passwort){
        super(vorname, name, adresse, telefonnummer, ID, svn, benutzername, passwort);
        this.sekreteriatID = sekreteriatID;
    }

    public int getSekreteriatID() {
        return sekreteriatID;
    }
    public void setSekreteriatID(int sekreteriatID) {
        this.sekreteriatID = sekreteriatID;
    }
}

