package com.example.aykanberkesandal;
import java.sql.Time;
import java.util.Date;

public class Termin {
    private int terminID;
    private String datum;
    private String arztName;
    private String patientName;

    public Termin(int terminID, String datum, String arztName, String patientName) {
        this.terminID = terminID;
        this.datum = datum;
        this.arztName = arztName;
        this.patientName = patientName;
    }

    public int getTerminID() {
        return terminID;
    }

    public  void setTerminID(int terminID) {
        this.terminID = terminID;
    }

    public  String getDatum() {
        return datum;
    }

    public  void setDatum(String datum) {
        this.datum = datum;
    }

    public  String getArztName() {
        return arztName;
    }

    public  void setArztName(String arztName) {
        this.arztName = arztName;
    }

    public  String getPatientName() {
        return patientName;
    }

    public  void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
