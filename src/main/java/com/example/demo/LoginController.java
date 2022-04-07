package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.*;

import java.sql.SQLException;


/** Controls the login screen */
public class LoginController {
    @FXML
    private TextField user;
    @FXML
    private TextField password;
    @FXML
    private Button loginButton;
    @FXML
    private Button back;
//
//   String name = String.valueOf(user.getText());
//   String pass = String.valueOf(password.getText());

    public void initialize() {
    }

    public void initManager(LoginManager loginManager){
        loginButton.setOnAction(event -> {
            System.out.println("login controller");
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


    }




}

