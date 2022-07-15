package com.example.aykanberkesandal;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.*;


public class SidebarController {
    public static Stage stage;
    private static Scene scene;
    private static Parent root;
    public static Connection conn = null;
    public static Statement stmt;
    public  static PreparedStatement pstmt;
    public  static ResultSet rs;
    public static PatientController patientController;
    public static TerminController terminController;
    public static ArztController arztController;
    public static SekretariatController sekretariatController;
    public static VerwaltungspersonalController verwaltungspersonalController;

    String User = LoginController.currentUser;
    String userRolle = LoginController.userRolle;

    @FXML
    private Label lErrorMessage;
    public FadeTransition ft = new FadeTransition(Duration.millis(1900));

    @FXML
    private ImageView ivVerwaltungspersonal;
    @FXML
    private ImageView ivArzt;
    @FXML
    private ImageView ivSekretariat;
    @FXML
    private AnchorPane apScreen;
    @FXML
    public Label lCurrentUser;
    @FXML
    public Label lRoleOfCurrentUser;
    @FXML
    public Label lVpersonal;
    @FXML
    public Label lArzt;
    @FXML
    public Label lSekretariat;


    @FXML
    public void initialize() {
        lCurrentUser.setText(User);
        //lRoleOfCurrentUser.setText(DB.giveRoleOfCurrentUser());
        loadPage("Homepage");
        ft.setNode(lErrorMessage);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);

        if(userRolle.equals("Verwaltungspersonal")) {
            lVpersonal.setVisible(true);
            ivVerwaltungspersonal.setVisible(true);
        }
        else if(userRolle.equals("Sekretariat")){
            lSekretariat.setVisible(true);
            ivSekretariat.setVisible(true);
        }
        else{
            lArzt.setVisible(true);
            ivArzt.setVisible(true);
        }


    }

    @FXML
    private void loadHomepage(ActionEvent event) {
        stage.setTitle("Startseite");
        loadPage("Homepage");
    }

    @FXML
    private void loadPatientPage() {
        Parent root = null;
        try {
            if(userRolle.equals("Verwaltungspersonal")) {
                root = FXMLLoader.load(getClass().getResource("Patient.fxml"));
                apScreen.getChildren().removeAll();
                apScreen.getChildren().add(root);
                stage.setTitle("Patient");
                patientController.refreshTable();
            }
            else if(userRolle.equals("Sekretariat") || userRolle.equals("Arzt")){
                root = FXMLLoader.load(getClass().getResource("Patient.fxml"));
                apScreen.getChildren().removeAll();
                apScreen.getChildren().add(root);
                patientController.refreshTable();
                stage.setTitle("Patient");
                patientController.makeButtonsInvisible();
            }
            else{
                lErrorMessage.setVisible(true);
                ft.play();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void loadAppointmentPage() {
        Parent root = null;
        try {
            if(userRolle.equals("Verwaltungspersonal") || userRolle.equals("Sekretariat") ){
                root = FXMLLoader.load(getClass().getResource( "Termin.fxml"));
                apScreen.getChildren().removeAll();
                apScreen.getChildren().add(root);
                stage.setTitle("Termin");
                terminController.refreshTable();
            }
            else if(userRolle.equals("Arzt")){
                root = FXMLLoader.load(getClass().getResource( "Termin.fxml"));
                apScreen.getChildren().removeAll();
                apScreen.getChildren().add(root);
                stage.setTitle("Termin");
                terminController.refreshTable();
                terminController.makeButtonsInvisible();
            }
            else{
                lErrorMessage.setVisible(true);
                ft.play();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void loadDoctorPage() {
        Parent root = null;
        try {
            if(userRolle.equals("Verwaltungspersonal")){
                root = FXMLLoader.load(getClass().getResource( "Arzt.fxml"));
                apScreen.getChildren().removeAll();
                apScreen.getChildren().add(root);
                stage.setTitle("Arzt");
                arztController.refreshTable();
            }
            else if(userRolle.equals("Sekretariat")){
                root = FXMLLoader.load(getClass().getResource( "Arzt.fxml"));
                apScreen.getChildren().removeAll();
                apScreen.getChildren().add(root);
                stage.setTitle("Arzt");
                arztController.refreshTable();
                arztController.makeButtonsInvisible();
            }
            else{
                lErrorMessage.setVisible(true);
                ft.play();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void loadSecretaryPage() {
        Parent root = null;
        try {
            if(userRolle.equals("Verwaltungspersonal")){
                root = FXMLLoader.load(getClass().getResource( "Sekretariat.fxml"));
                apScreen.getChildren().removeAll();
                apScreen.getChildren().add(root);
                stage.setTitle("Sekretariat");
                sekretariatController.refreshTable();
            }
            else if(userRolle.equals("Sekretariat")){
                root = FXMLLoader.load(getClass().getResource( "Sekretariat.fxml"));
                apScreen.getChildren().removeAll();
                apScreen.getChildren().add(root);
                stage.setTitle("Sekretariat");
                sekretariatController.refreshTable();
                sekretariatController.makeButtonsInvisible();
            }
            else{
                lErrorMessage.setVisible(true);
                ft.play();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void loadManagementPersonnelPage() {
        Parent root = null;
        try {
            if(userRolle.equals("Verwaltungspersonal")){
                root = FXMLLoader.load(getClass().getResource( "Verwaltungspersonal.fxml"));
                apScreen.getChildren().removeAll();
                apScreen.getChildren().add(root);
                stage.setTitle("Verwaltungspersonal");
                verwaltungspersonalController.refreshTable();
            }
            else if(userRolle.equals("Sekretariat")){
                root = FXMLLoader.load(getClass().getResource( "Verwaltungspersonal.fxml"));
                apScreen.getChildren().removeAll();
                apScreen.getChildren().add(root);
                stage.setTitle("Verwaltungspersonal");
                verwaltungspersonalController.refreshTable();
                verwaltungspersonalController.makeButtonsInvisible();
            }
            else{
                lErrorMessage.setVisible(true);
                ft.play();
            }


        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void loadPage(String page) {
        //Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
            apScreen.getChildren().removeAll();
            apScreen.getChildren().add(root);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void switchToLoginScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Login");
        LoginController.currentUser = "";
        stage.setResizable(false);
        scene = new Scene(root);
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }
}
