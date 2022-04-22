package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class welcomeController {

    @FXML
    private Button toLogin,loan,register;


    public void initManager(welcomeManager welcomeManager) {
        toLogin.setOnAction(actionEvent -> {
            welcomeManager.login();
        });

        loan.setOnAction((actionEvent -> welcomeManager.loan()));

        register.setOnAction(actionEvent-> welcomeManager.register());


    }


}
