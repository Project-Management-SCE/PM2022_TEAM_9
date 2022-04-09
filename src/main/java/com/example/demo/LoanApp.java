package com.example.demo;


import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;


/** Main application class for the login demo application */
public class LoanApp extends Application {

    public static PostgreSQL sql = PostgreSQL.getInstance();

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) throws IOException {
        sql.openConnection();
        Scene scene = new Scene(new StackPane());
        welcomeManager welcomeManager = new welcomeManager(scene);
        welcomeManager.showWelcomeScreen();

        stage.setScene(scene);
        stage.show();


//        sql.closeConnection();

    }


}
