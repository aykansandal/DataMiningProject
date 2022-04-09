package com.example.aykanberkesandal;

public class Verwaltungspersonal extends Personal  {
    private int verwaltungspersonalID;

    Verwaltungspersonal(String vorname, String name, String adresse, String telefonnummer, String ID, String svn, int patientID, boolean zustand, int verwaltungspersonalID){
        super(vorname, name, adresse, telefonnummer, ID, svn);
        this.verwaltungspersonalID = verwaltungspersonalID;
    }

    public int getVerwaltungspersonalID() {
        return verwaltungspersonalID;
    }
    public void setVerwaltungspersonalID(int verwaltungspersonalID) {
        this.verwaltungspersonalID = verwaltungspersonalID;
    }
}
