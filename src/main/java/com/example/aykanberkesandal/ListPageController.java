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
    private TableView<Patient> table;
    @FXML
    private TableColumn<Patient,Integer> col_UID;
    @FXML
    private TableColumn<Patient,String> col_vorname;
    @FXML
    private TableColumn<Patient,String> col_name;
    @FXML
    private TableColumn<Patient,String> col_telefonnummer;
    @FXML
    private TableColumn<Patient,String> col_adresse;
    @FXML
    private TableColumn<Patient,String> col_ID;

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

    public void clickPatientList(ActionEvent event){
        if(table.isVisible() == false){
            setPatientList(DB.listPatient());
            table.setVisible(true);
        }
        else{
            table.setVisible(false);
        }
    }

    public void clickDoctorList(ActionEvent event){
        if(arztTable.isVisible() == false){
            setDoctorList(DB.listDoctor());
            arztTable.setVisible(true);
        }
        else{
            arztTable.setVisible(false);
        }
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

    public void setPatientList(ObservableList<Patient> oblist) {

        col_UID.setCellValueFactory(new PropertyValueFactory<>("patientID"));
        col_vorname.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        col_telefonnummer.setCellValueFactory(new PropertyValueFactory<>("telefonnummer"));
        col_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));

        table.setItems(oblist);
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
