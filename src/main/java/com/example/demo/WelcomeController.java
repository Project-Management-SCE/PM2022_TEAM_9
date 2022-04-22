package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class WelcomeController {

    @FXML
    private Button toLogin,loan,register;


    public void initManager(WelcomeManager welcomeManager) {
        toLogin.setOnAction(actionEvent -> {
            welcomeManager.login();
        });

        loan.setOnAction((actionEvent -> welcomeManager.loan()));

        register.setOnAction(actionEvent-> welcomeManager.register());


    }


}
