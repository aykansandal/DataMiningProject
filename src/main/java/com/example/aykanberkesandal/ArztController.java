package com.example.aykanberkesandal;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ArztController {
    public static Stage stage;

    @FXML
    public Button addButton;
    @FXML
    public Button delButton;
    @FXML
    public Button updtButton;
    @FXML
    public TableView<Arzt> arztTable;
    @FXML
    public TableColumn<Arzt,Integer> col_UID_arzt;
    @FXML
    public TableColumn<Arzt,String> col_vorname_arzt;
    @FXML
    public TableColumn<Arzt,String> col_name_arzt;
    @FXML
    public TableColumn<Arzt,String> col_telefonnummer_arzt;
    @FXML
    public TableColumn<Arzt,String> col_adresse_arzt;
    @FXML
    public TableColumn<Arzt,String> col_ID_arzt;
    @FXML
    public TableColumn<Arzt,String> col_SVN_arzt;

    @FXML
    public void initialize() {
        SidebarController.arztController = this;
    }

    @FXML
    private void loadDelPopup(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("DelPopupArzt.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setResizable(false);
            Image icon = new Image("minus.png");
            stage.getIcons().add(icon);
            stage.setTitle("Lösche Arzt");
            stage.setAlwaysOnTop(true);
            stage.setScene(scene);
            stage.show();
            ArztDelPopupController.arztController = this;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void loadUpdtPopup(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("UpdtPopupArzt.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            Image icon = new Image("update.png");
            stage.getIcons().add(icon);
            stage.setTitle("Aktualisiere Arztinfo");
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.setScene(scene);
            stage.show();
            ArztUpdtPopupController.arztController = this;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void loadAddPopup(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AddPopupArzt.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            Image icon = new Image("plus.png");
            stage.getIcons().add(icon);
            stage.setTitle("Hinzufüge Arzt");
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.setScene(scene);
            stage.show();
            ArztAddPopupController.arztController = this;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void setArztList(ObservableList<Arzt> oblist) {
        col_UID_arzt.setCellValueFactory(new PropertyValueFactory<>("arztID"));
        col_vorname_arzt.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        col_name_arzt.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_adresse_arzt.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        col_telefonnummer_arzt.setCellValueFactory(new PropertyValueFactory<>("telefonnummer"));
        col_ID_arzt.setCellValueFactory(new PropertyValueFactory<>("ID"));
        col_SVN_arzt.setCellValueFactory(new PropertyValueFactory<>("svn"));
        arztTable.setItems(oblist);

    }

    public void refreshTable(){
        setArztList(DBListOps.listArzt());
    }

    public void makeButtonsInvisible(){
        addButton.setVisible(false);
        delButton.setVisible(false);
        updtButton.setVisible(false);
    }
}
