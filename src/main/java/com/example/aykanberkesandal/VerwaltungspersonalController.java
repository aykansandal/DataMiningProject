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

public class VerwaltungspersonalController {
    public static Stage stage;

    @FXML
    public Button addButton;
    @FXML
    public Button delButton;
    @FXML
    public Button updtButton;
    @FXML
    public TableView<Verwaltungspersonal> verwaltungspersonalTable;
    @FXML
    public TableColumn<Verwaltungspersonal,Integer> col_UID_verwaltungspersonal;
    @FXML
    public TableColumn<Verwaltungspersonal,String> col_vorname_verwaltungspersonal;
    @FXML
    public TableColumn<Verwaltungspersonal,String> col_name_verwaltungspersonal;
    @FXML
    public TableColumn<Verwaltungspersonal,String> col_telefonnummer_verwaltungspersonal;
    @FXML
    public TableColumn<Verwaltungspersonal,String> col_adresse_verwaltungspersonal;
    @FXML
    public TableColumn<Verwaltungspersonal,String> col_ID_verwaltungspersonal;
    @FXML
    public TableColumn<Verwaltungspersonal,String> col_SVN_verwaltungspersonal;

    @FXML
    public void initialize() {
        SidebarController.verwaltungspersonalController = this;
    }

    @FXML
    private void loadDelPopup(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("DelPopupVerwaltungspersonal.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setResizable(false);
            Image icon = new Image("minus.png");
            stage.getIcons().add(icon);
            stage.setTitle("Lösche Verwaltungspersonal");
            stage.setAlwaysOnTop(true);
            stage.setScene(scene);
            stage.show();
            VerwaltungspersonalDelPopupController.verwaltungspersonalController = this;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void loadUpdtPopup(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("UpdtPopupVerwaltungspersonal.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            Image icon = new Image("update.png");
            stage.getIcons().add(icon);
            stage.setTitle("Aktualisiere Verwaltungspersonalinfo");
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.setScene(scene);
            stage.show();
            VerwaltungspersonalUpdtPopupController.verwaltungspersonalController = this;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void loadAddPopup(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AddPopupVerwaltungspersonal.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            Image icon = new Image("plus.png");
            stage.getIcons().add(icon);
            stage.setTitle("Hinzufüge Verwaltungspersonal");
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.setScene(scene);
            stage.show();
            VerwaltungspersonalAddPopupController.verwaltungspersonalController = this;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void setVerwaltungspersonalList(ObservableList<Verwaltungspersonal> oblist) {
        col_UID_verwaltungspersonal.setCellValueFactory(new PropertyValueFactory<>("verwaltungspersonalID"));
        col_vorname_verwaltungspersonal.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        col_name_verwaltungspersonal.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_adresse_verwaltungspersonal.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        col_telefonnummer_verwaltungspersonal.setCellValueFactory(new PropertyValueFactory<>("telefonnummer"));
        col_ID_verwaltungspersonal.setCellValueFactory(new PropertyValueFactory<>("ID"));
        col_SVN_verwaltungspersonal.setCellValueFactory(new PropertyValueFactory<>("svn"));
        verwaltungspersonalTable.setItems(oblist);
    }

    public void refreshTable(){
        setVerwaltungspersonalList(DBListOps.listVerwaltungspersonal());
    }

    public void makeButtonsInvisible(){
        addButton.setVisible(false);
        delButton.setVisible(false);
        updtButton.setVisible(false);
    }

    @FXML
    private void clickListVerwaltungspersonal(){
        if(verwaltungspersonalTable.isVisible() == false)
            verwaltungspersonalTable.setVisible(true);
        else
            verwaltungspersonalTable.setVisible(false);
    }
}
