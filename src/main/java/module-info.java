module com.example.aykanberkesandal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.aykanberkesandal to javafx.fxml;
    exports com.example.aykanberkesandal;
}