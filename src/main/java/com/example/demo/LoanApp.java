package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


/**
 * Main application class for the login demo application
 */
public class LoanApp extends Application {

    public static PostgreSQL sql = PostgreSQL.getInstance();
    public final static int USER_NOT_EXIST = -999;
    public final static String USERNAME_NOT_EXIST = "USERNAME_NOT_EXIST";


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        sql.openConnection();
        Scene scene = new Scene(new StackPane());
        WelcomeManager welcomeManager = new WelcomeManager(scene);
        welcomeManager.initializeScreen();

        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.getIcons().add(new Image(String.format("file:%s\\src\\main\\resources\\com\\example\\demo\\img\\app_icon.jpg", System.getProperty("user.dir"))));
        stage.show();
//        sql.closeConnection();

    }


}
