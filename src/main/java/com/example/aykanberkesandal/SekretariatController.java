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

public class SekretariatController {
    public static Stage stage;
    @FXML
    public Button addButton;
    @FXML
    public Button delButton;
    @FXML
    public Button updtButton;


    @FXML
    public TableView<Sekretariat> sekretariatTable;
    @FXML
    public TableColumn<Sekretariat,Integer> col_UID_sekretariat;
    @FXML
    public TableColumn<Sekretariat,String> col_vorname_sekretariat;
    @FXML
    public TableColumn<Sekretariat,String> col_name_sekretariat;
    @FXML
    public TableColumn<Sekretariat,String> col_telefonnummer_sekretariat;
    @FXML
    public TableColumn<Sekretariat,String> col_adresse_sekretariat;
    @FXML
    public TableColumn<Sekretariat,String> col_ID_sekretariat;
    @FXML
    public TableColumn<Sekretariat,String> col_SVN_sekretariat;

    @FXML
    public void initialize() {
        SidebarController.sekretariatController = this;
    }

    @FXML
    private void loadDelPopup(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("DelPopupSekretariat.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setResizable(false);
            Image icon = new Image("minus.png");
            stage.getIcons().add(icon);
            stage.setTitle("Lösche Sekretariat");
            stage.setAlwaysOnTop(true);
            stage.setScene(scene);
            stage.show();
            SekretariatDelPopupController.sekretariatController = this;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void loadUpdtPopup(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("UpdtPopupSekretariat.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            Image icon = new Image("update.png");
            stage.getIcons().add(icon);
            stage.setTitle("Aktualisiere Sekretariatinfo");
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.setScene(scene);
            stage.show();
            SekretariatUpdtPopupController.sekretariatController = this;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void loadAddPopup(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AddPopupSekretariat.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            Image icon = new Image("plus.png");
            stage.getIcons().add(icon);
            stage.setTitle("Hinzufüge Sekretariat");
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.setScene(scene);
            stage.show();
            SekretariatAddPopupController.sekretariatController = this;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void setSekretariatList(ObservableList<Sekretariat> oblist) {
        col_UID_sekretariat.setCellValueFactory(new PropertyValueFactory<>("sekretariatID"));
        col_vorname_sekretariat.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        col_name_sekretariat.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_adresse_sekretariat.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        col_telefonnummer_sekretariat.setCellValueFactory(new PropertyValueFactory<>("telefonnummer"));
        col_ID_sekretariat.setCellValueFactory(new PropertyValueFactory<>("ID"));
        col_SVN_sekretariat.setCellValueFactory(new PropertyValueFactory<>("svn"));
        sekretariatTable.setItems(oblist);
    }

    public void refreshTable(){
        setSekretariatList(DBListOps.listSekretariat());
    }

    public void makeButtonsInvisible(){
        addButton.setVisible(false);
        delButton.setVisible(false);
        updtButton.setVisible(false);
    }


}
