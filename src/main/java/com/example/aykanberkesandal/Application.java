package com.example.aykanberkesandal;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        /*Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        Scene scene = new Scene(root);

        //String css = this.getClass().getResource("application.css").toExternalForm();
        //scene.getStylesheets().add(css);
        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();*/

        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("LoginScreen.fxml"));
        //Scene scene = new Scene(fxmlLoader.load());
        Scene scene = new Scene(root);

        stage.setTitle("Login");
        stage.setResizable(false);
        Image icon = new Image("logo.png");
        stage.getIcons().add(icon);

        stage.setScene(scene);
        stage.show();

        /*Group root = new Group();
        Scene scene = new Scene(root,Color.LIGHTSKYBLUE);

        Image icon = new Image("C:\\Users\\Aykan\\IdeaProjects\\190503012_AykanBerkeSandal\\src\\icon.png");
        stage.getIcons().add(icon);
        stage.setWidth(750);
        stage.setHeight(750);
        stage.setResizable(false);
        //stage.setX(100);
        //stage.setY(100);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("Drücken Sie f, um den Vollbildmodus zu verlassen.");
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("f"));

        Image arzt = new Image("C:\\Users\\Aykan\\IdeaProjects\\190503012_AykanBerkeSandal\\src\\arzt.png");
        ImageView imageView = new ImageView(arzt);
        imageView.setX(1050);
        imageView.setY(400);

        root.getChildren().add(imageView);
        stage.setTitle("Zahnarztklinik GUI Demo");
        stage.setScene(scene);
        stage.show();*/
        DB db = new DB();
        db.connect();
    }

    public static void main(String[] args) {
        launch(args);
    }
}