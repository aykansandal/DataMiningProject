package com.example.aykanberkesandal;


import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;



public class LoginController {
    public Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField tfBenutzername;
    @FXML
    private TextField tfPasswort;
    @FXML
    private Button buttonLogin;
    @FXML
    private Label lErrorMessage;
    @FXML
    private Label lErrorMessage2;
    @FXML
    private Label lErrorMessage3;
    @FXML
    private Label lErrorMessage4;


    public static String currentUser;

    public FadeTransition ft = new FadeTransition(Duration.millis(3000));
    public FadeTransition ft2 = new FadeTransition(Duration.millis(3000));
    public FadeTransition ft3 = new FadeTransition(Duration.millis(3000));
    public FadeTransition ft4 = new FadeTransition(Duration.millis(3000));

    @FXML
    public void initialize(){
        //TODO: Kod tekrarını engelle
        ft.setNode(lErrorMessage);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);

        ft2.setNode(lErrorMessage2);
        ft2.setFromValue(1.0);
        ft2.setToValue(0.0);
        ft2.setCycleCount(1);
        ft2.setAutoReverse(false);

        ft3.setNode(lErrorMessage3);
        ft3.setFromValue(1.0);
        ft3.setToValue(0.0);
        ft3.setCycleCount(1);
        ft3.setAutoReverse(false);

        ft4.setNode(lErrorMessage4);
        ft4.setFromValue(1.0);
        ft4.setToValue(0.0);
        ft4.setCycleCount(1);
        ft4.setAutoReverse(false);
    }

    public void switchToHomepage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Application.class.getResource("Mainpage.fxml"));
        System.out.println(root);
        stage =(Stage)(buttonLogin.getScene().getWindow());
        stage.setTitle("Homepage");
        //stage.setResizable(false); TODO: Decide if you want it resizable
        scene = new Scene(root);
        //stage.hide();  TODO: <-
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void login(ActionEvent event){
        lErrorMessage.setVisible(false);
        try {
            if(DB.checkLogin(tfBenutzername.getText(),tfPasswort.getText())){
                System.out.println("ok");
                currentUser = tfBenutzername.getText();
                SidebarController.stage =(Stage)(buttonLogin.getScene().getWindow());
                switchToHomepage(event);
            }
            else if(tfBenutzername.getText().isEmpty() && tfPasswort.getText().isEmpty()){
                //TODO: Art arda tıklanınca animasyonların birbirine karışması durumunu engellemeye çalış
                lErrorMessage2.setVisible(true);
                ft2.play();
            }
            else if(tfBenutzername.getText().isEmpty() && !tfPasswort.getText().isEmpty()){
                lErrorMessage3.setVisible(true);
                ft3.play();
            }
            else if(!tfBenutzername.getText().isEmpty() && tfPasswort.getText().isEmpty()){
                lErrorMessage4.setVisible(true);
                ft4.play();
            }
            else{
                lErrorMessage.setVisible(true);
                ft.play();
            }
            // TODO: else - alert
        }
        catch (Exception e) {
        }
    }

    public static void setCurrentUser(String currentUser) {
        LoginController.currentUser = currentUser;
    }

}