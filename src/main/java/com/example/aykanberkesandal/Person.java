package com.example.aykanberkesandal;

public class Person {
    private String vorname;
    private String name;
    private String adresse;
    private String telefonnummer;
    private String ID;

    public Person(String vorname, String name, String adresse, String telefonnummer, String ID) {
        this.vorname = vorname;
        this.name = name;
        this.adresse = adresse;
        this.telefonnummer = telefonnummer;
        this.ID = ID;
    }

    public String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }
    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
}
