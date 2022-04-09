package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.*;

import java.sql.SQLException;


/** Controls the login screen */
public class LoginController {
    @FXML
    private TextField user,password;

    @FXML
    private Button loginButton,back,forgotPss;

    public void initialize() {}

    /**
     * init button in login scene
     * @param loginManager
     */
    public void initManager(LoginManager loginManager){
        loginButton.setOnAction(event -> {
            try {
                loginManager.showLoginScreen();
                loginManager.authorize(user, password);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        });


         back.setOnAction(actionEvent -> {
             System.out.println("login controller go back");
             loginManager.goWelcome();
         });

         forgotPss.setOnAction(actionEvent -> loginManager.goFP());


    }




}

