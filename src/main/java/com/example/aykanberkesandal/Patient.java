package com.example.aykanberkesandal;

public class Patient extends Person {
    private int patientID;
    //adi degistirebilirsin.
    private boolean zustand;
    // true -> aktiver Patient
    // false -> nicht aktiver Patient

    Patient(String vorname, String name, String adresse, String telefonnummer, String ID, int patientID, boolean zustand){
        super(vorname,name,adresse,telefonnummer,ID);
        this.patientID = patientID;
        this.zustand = zustand;
    }

    public int getPatientID() {
        return patientID;
    }
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public boolean getZustand() {
        return zustand;
    }
    public void setZustand(boolean zustand) {
        this.zustand = zustand;
    }
}
