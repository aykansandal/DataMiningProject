package com.example.aykanberkesandal;

public class Arzt extends Personal  {
    private int arztID;

    Arzt(String vorname, String name, String adresse, String telefonnummer, String ID, String svn, String benutzername, String passwort, int arztID){
        super(vorname, name, adresse, telefonnummer, ID, svn, benutzername, passwort);
        this.arztID = arztID;
    }

    public int getArztID() {
        return arztID;
    }
    public void setArztID(int arztID) {
        this.arztID = arztID;
    }
}
