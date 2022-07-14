package com.example.aykanberkesandal;

import java.util.ArrayList;

public class Arzt extends Personal  {
    private  int arztID;


    Arzt(int arztID, String vorname, String name, String adresse, String telefonnummer, String ID, String svn, String benutzername, String passwort){
        super(vorname, name, adresse, telefonnummer, ID, svn, benutzername, passwort);
        this.arztID = arztID;
    }

    Arzt(int arztID, String vorname, String name, String adresse, String telefonnummer, String ID, String svn){
        super(vorname, name, adresse, telefonnummer, ID, svn);
        this.arztID = arztID;
    }

    public  int getArztID() {
        return arztID;
    }
    public void setArztID(int arztID) {
        this.arztID = arztID;
    }
}
