package com.example.aykanberkesandal;

public class Personal extends Person {
    private String svn;
    private String benutzername;
    private String passwort;

    Personal(String vorname, String name, String adresse, String telefonnummer, String ID, String svn, String benutzername, String passwort){
        super(vorname,name,adresse,telefonnummer,ID);
        this.svn = svn;
    }

    Personal(String vorname, String name, String adresse, String telefonnummer, String ID, String svn){
        super(vorname,name,adresse,telefonnummer,ID);
        this.svn = svn;
    }

    public String getSvn() {
        return svn;
    }
    public void setSvn(String svn) {
        this.svn = svn;
    }
    public String getBenutzername() {
        return benutzername;
    }
    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }
    public String getPasswort() {
        return passwort;
    }
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
}
