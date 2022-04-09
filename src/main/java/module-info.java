module com.example.aykanberkesandal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aykanberkesandal to javafx.fxml;
    exports com.example.aykanberkesandal;
}