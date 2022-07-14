package com.example.aykanberkesandal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
import java.util.concurrent.TimeUnit;

public class PatientController {
    public static Stage stage;
    private static Scene scene;
    private static Parent root;
    @FXML
    public Button addButton;
    @FXML
    public Button delButton;
    @FXML
    public Button updtButton;
    @FXML
    public TableView<Patient> patientTable;
    @FXML
    public TableColumn<Patient,Integer> col_UID_patient;
    @FXML
    public TableColumn<Patient,String> col_vorname_patient;
    @FXML
    public TableColumn<Patient,String> col_name_patient;
    @FXML
    public TableColumn<Patient,String> col_telefonnummer_patient;
    @FXML
    public TableColumn<Patient,String> col_adresse_patient;
    @FXML
    public TableColumn<Patient,String> col_ID_patient;

    @FXML
    public void initialize() {
        SidebarController.patientController = this;
    }

    /*private void loadPopup(String page) {

        try {
            FXMLLoader fl = new FXMLLoader(getClass().getResource(page+".fxml"));
            scene = new Scene(fl.load());
            stage = new Stage();

            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }*/




    @FXML
    private void loadDelPopup(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("DelPopupPatient.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setResizable(false);
            Image icon = new Image("minus.png");
            stage.getIcons().add(icon);
            stage.setTitle("Lösche Patient");
            stage.setAlwaysOnTop(true);
            stage.setScene(scene);
            stage.show();
            PatientDelPopupController.patientController = this;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void loadUpdtPopup(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("UpdtPopupPatient.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            Image icon = new Image("update.png");
            stage.getIcons().add(icon);
            stage.setTitle("Aktualisiere Patientinfo");
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.setScene(scene);
            stage.show();
            PatientUpdtPopupController.patientController = this;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void loadAddPopup(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AddPopupPatient.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            Image icon = new Image("plus.png");
            stage.getIcons().add(icon);
            stage.setTitle("Hinzufüge Patient");
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.setScene(scene);
            stage.show();
            PatientAddPopupController.patientController = this;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
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

    public void refreshTable(){
        setPatientList(DBListOps.listPatient());
    }

    @FXML
    public void clickListPatient(){
        setPatientList(DBListOps.listPatient());

        /*if(patientTable.isVisible() == false){
            patientTable.setVisible(true);

        }
        else{
            patientTable.setVisible(false);
        }*/
    }

    public void makeButtonsInvisible(){
        addButton.setVisible(false);
        delButton.setVisible(false);
        updtButton.setVisible(false);
    }

    /*public void clickPatientList(ActionEvent event){
        //if(patientTable.isVisible() == false){
            //setPatientList(DBListOps.listPatient());
            //patientTable.setVisible(true);
            arztTable.setVisible(false);
            sekreteriatTable.setVisible(false);
            verwaltungspersonalTable.setVisible(false);
        }
        //else{
            //patientTable.setVisible(false);
        }
    }*/

}
