package com.example.aykanberkesandal;

public class Person {
    private static String vorname;
    private static String name;
    private static String adresse;
    private static String telefonnummer;
    private static String ID;

    public Person(String vorname, String name, String adresse, String telefonnummer, String ID) {
        this.vorname = vorname;
        this.name = name;
        this.adresse = adresse;
        this.telefonnummer = telefonnummer;
        this.ID = ID;
    }

    public static String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public static String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public static String getTelefonnummer() {
        return telefonnummer;
    }
    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public static String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
}
