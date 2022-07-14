package com.example.aykanberkesandal;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TerminController {
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
    private TableView<Termin> terminTable;
    @FXML
    private TableColumn<Termin,Integer> col_UID_termin;
    @FXML
    private TableColumn<Termin,String> col_arzt_termin;
    @FXML
    private TableColumn<Termin,String> col_patient_termin;
    @FXML
    private TableColumn<Termin,String> col_datum_termin;

    @FXML
    public void initialize() {
        SidebarController.terminController = this;
    }

    @FXML
    private void loadDelPopup(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("DelPopupTermin.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            Image icon = new Image("minus.png");
            stage.getIcons().add(icon);
            stage.setTitle("Lösche Termin");
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.setScene(scene);
            stage.show();
            TerminDelPopupController.terminController = this;

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void loadUpdtPopup(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("UpdtPopupTermin.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            Image icon = new Image("update.png");
            stage.getIcons().add(icon);
            stage.setTitle("Aktualisiere Termininfo");
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.setScene(scene);
            stage.show();
            TerminUpdtPopupController.terminController = this;

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void loadAddPopup(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AddPopupTermin.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            Image icon = new Image("plus.png");
            stage.getIcons().add(icon);
            stage.setTitle("Termin");
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.setScene(scene);
            stage.show();
            TerminAddPopupController.terminController = this;



        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void setTerminList(ObservableList<Termin> oblist) {
        col_UID_termin.setCellValueFactory(new PropertyValueFactory<>("terminID"));
        col_arzt_termin.setCellValueFactory(new PropertyValueFactory<>("arztName"));
        col_patient_termin.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        col_datum_termin.setCellValueFactory(new PropertyValueFactory<>("datum"));
        terminTable.setItems(oblist);

    }

    public void refreshTable(){
        setTerminList(DBListOps.listTermin());
    }

    public void makeButtonsInvisible(){
        addButton.setVisible(false);
        delButton.setVisible(false);
        updtButton.setVisible(false);
    }

    @FXML
    private void clickListTermin(){
        if(terminTable.isVisible() == false)
            terminTable.setVisible(true);
        else
            terminTable.setVisible(false);
    }

}
