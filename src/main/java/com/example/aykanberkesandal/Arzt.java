package com.example.aykanberkesandal;

public class Arzt extends Personal  {
    private int arztID;

    Arzt(String vorname, String name, String adresse, String telefonnummer, String ID, String svn, int patientID, boolean zustand, int arztID){
        super(vorname,name,adresse,telefonnummer,ID, svn);
        this.arztID = arztID;
    }

    public int getArztID() {
        return arztID;
    }
    public void setArztID(int arztID) {
        this.arztID = arztID;
    }
}
