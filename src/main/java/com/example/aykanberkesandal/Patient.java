package com.example.aykanberkesandal;

public class Patient extends Person {
    private int patientID;
    //adi degistirebilirsin.
    private boolean zustand;
    // true -> aktiver Patient
    // false -> nicht aktiver Patient

    Patient(int patientID, String vorname, String name, String adresse, String telefonnummer, String ID){
        super(vorname,name,adresse,telefonnummer,ID);
        this.patientID = patientID;

    }

    public int getPatientID() {
        return patientID;
    }
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }
    //TODO: BAK
    /*public boolean getZustand() {
        return zustand;
    }
    public void setZustand(boolean zustand) {
        this.zustand = zustand;
    }*/
}
