package com.example.aykanberkesandal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class ListPageController{
    public static Stage stage;
    private static Scene scene;
    private static Parent root;

    @FXML
    private AnchorPane apListen;


    @FXML
    private TableView<Patient> patientTable;
    @FXML
    private TableColumn<Patient,Integer> col_UID_patient;
    @FXML
    private TableColumn<Patient,String> col_vorname_patient;
    @FXML
    private TableColumn<Patient,String> col_name_patient;
    @FXML
    private TableColumn<Patient,String> col_telefonnummer_patient;
    @FXML
    private TableColumn<Patient,String> col_adresse_patient;
    @FXML
    private TableColumn<Patient,String> col_ID_patient;

    @FXML
    private TableView<Arzt> arztTable;
    @FXML
    private TableColumn<Arzt,Integer> col_UID_arzt;
    @FXML
    private TableColumn<Arzt,String> col_vorname_arzt;
    @FXML
    private TableColumn<Arzt,String> col_name_arzt;
    @FXML
    private TableColumn<Arzt,String> col_telefonnummer_arzt;
    @FXML
    private TableColumn<Arzt,String> col_adresse_arzt;
    @FXML
    private TableColumn<Arzt,String> col_ID_arzt;
    @FXML
    private TableColumn<Arzt,String> col_SVN_arzt;

    @FXML
    private TableView<Sekreteriat> sekreteriatTable;
    @FXML
    private TableColumn<Sekreteriat,Integer> col_UID_sekreteriat;
    @FXML
    private TableColumn<Sekreteriat,String> col_vorname_sekreteriat;
    @FXML
    private TableColumn<Sekreteriat,String> col_name_sekreteriat;
    @FXML
    private TableColumn<Sekreteriat,String> col_telefonnummer_sekreteriat;
    @FXML
    private TableColumn<Sekreteriat,String> col_adresse_sekreteriat;
    @FXML
    private TableColumn<Sekreteriat,String> col_ID_sekreteriat;
    @FXML
    private TableColumn<Sekreteriat,String> col_SVN_sekreteriat;

    @FXML
    private TableView<Verwaltungspersonal> verwaltungspersonalTable;
    @FXML
    private TableColumn<Verwaltungspersonal,Integer> col_UID_verwaltungspersonal;
    @FXML
    private TableColumn<Verwaltungspersonal,String> col_vorname_verwaltungspersonal;
    @FXML
    private TableColumn<Verwaltungspersonal,String> col_name_verwaltungspersonal;
    @FXML
    private TableColumn<Verwaltungspersonal,String> col_telefonnummer_verwaltungspersonal;
    @FXML
    private TableColumn<Verwaltungspersonal,String> col_adresse_verwaltungspersonal;
    @FXML
    private TableColumn<Verwaltungspersonal,String> col_ID_verwaltungspersonal;
    @FXML
    private TableColumn<Verwaltungspersonal,String> col_SVN_verwaltungspersonal;

    public void clickPatientList(ActionEvent event){
        if(patientTable.isVisible() == false){
            setPatientList(DB.listPatient());
            patientTable.setVisible(true);
            arztTable.setVisible(false);
            sekreteriatTable.setVisible(false);
            verwaltungspersonalTable.setVisible(false);
        }
        else{
            patientTable.setVisible(false);
        }
    }

    public void clickDoctorList(ActionEvent event){
        if(arztTable.isVisible() == false){
            setDoctorList(DB.listDoctor());
            arztTable.setVisible(true);
            patientTable.setVisible(false);
            sekreteriatTable.setVisible(false);
            verwaltungspersonalTable.setVisible(false);
        }
        else{
            arztTable.setVisible(false);
        }
    }

    public void clickSecretaryList(ActionEvent event){
        if(sekreteriatTable.isVisible() == false){
            setSecretaryList(DB.listSecretary());
            sekreteriatTable.setVisible(true);
            arztTable.setVisible(false);
            patientTable.setVisible(false);
            verwaltungspersonalTable.setVisible(false);
        }
        else{
            sekreteriatTable.setVisible(false);
        }
    }

    public void clickManagementPersonnelList(ActionEvent event){
        if(verwaltungspersonalTable.isVisible() == false){
            setManagementPersonnelList(DB.listManagementPersonnel());
            verwaltungspersonalTable.setVisible(true);
            sekreteriatTable.setVisible(false);
            arztTable.setVisible(false);
            patientTable.setVisible(false);
        }
        else{
            verwaltungspersonalTable.setVisible(false);
        }
    }

    public void setPatientList(ObservableList<Patient> oblist) {

        col_UID_patient.setCellValueFactory(new PropertyValueFactory<>("patientID"));
        col_vorname_patient.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        col_name_patient.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_adresse_patient.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        col_telefonnummer_patient.setCellValueFactory(new PropertyValueFactory<>("telefonnummer"));
        col_ID_patient.setCellValueFactory(new PropertyValueFactory<>("ID"));

        patientTable.setItems(oblist);
    }

    public void setDoctorList(ObservableList<Arzt> oblist) {

        col_UID_arzt.setCellValueFactory(new PropertyValueFactory<>("arztID"));
        col_vorname_arzt.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        col_name_arzt.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_adresse_arzt.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        col_telefonnummer_arzt.setCellValueFactory(new PropertyValueFactory<>("telefonnummer"));
        col_ID_arzt.setCellValueFactory(new PropertyValueFactory<>("ID"));
        col_SVN_arzt.setCellValueFactory(new PropertyValueFactory<>("svn"));

        arztTable.setItems(oblist);
    }

    public void setSecretaryList(ObservableList<Sekreteriat> oblist) {

        col_UID_sekreteriat.setCellValueFactory(new PropertyValueFactory<>("sekreteriatID"));
        col_vorname_sekreteriat.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        col_name_sekreteriat.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_adresse_sekreteriat.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        col_telefonnummer_sekreteriat.setCellValueFactory(new PropertyValueFactory<>("telefonnummer"));
        col_ID_sekreteriat.setCellValueFactory(new PropertyValueFactory<>("ID"));
        col_SVN_sekreteriat.setCellValueFactory(new PropertyValueFactory<>("svn"));

        sekreteriatTable.setItems(oblist);
    }

    public void setManagementPersonnelList(ObservableList<Verwaltungspersonal> oblist) {

        col_UID_verwaltungspersonal.setCellValueFactory(new PropertyValueFactory<>("verwaltungspersonalID"));
        col_vorname_verwaltungspersonal.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        col_name_verwaltungspersonal.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_adresse_verwaltungspersonal.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        col_telefonnummer_verwaltungspersonal.setCellValueFactory(new PropertyValueFactory<>("telefonnummer"));
        col_ID_verwaltungspersonal.setCellValueFactory(new PropertyValueFactory<>("ID"));
        col_SVN_verwaltungspersonal.setCellValueFactory(new PropertyValueFactory<>("svn"));

        verwaltungspersonalTable.setItems(oblist);
    }














































    @FXML
    private void loadPatientList(ActionEvent event) {
        loadFunction("PatientListen");
    }


    private void loadFunction(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
            apListen.getChildren().removeAll();
            apListen.getChildren().add(root);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
