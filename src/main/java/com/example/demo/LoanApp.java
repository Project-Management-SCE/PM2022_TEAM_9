package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;


/** Main application class for the login demo application */
public class LoanApp extends Application {

    public static PostgreSQL sql = PostgreSQL.getInstance();
    public final static int USER_NOT_EXIST = -999;
    public final static String USERNAME_NOT_EXIST = "USERNAME_NOT_EXIST";

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) {
        sql.openConnection();
        Scene scene = new Scene(new StackPane());
        WelcomeManager welcomeManager = new WelcomeManager(scene);
        welcomeManager.showWelcomeScreen();

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
//        sql.closeConnection();

    }


}
