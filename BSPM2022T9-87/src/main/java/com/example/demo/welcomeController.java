package com.example.demo;


import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class welcomeController {

    @FXML
    private Button toLogin;
    @FXML
    private Button loan;


    public void initManager(welcomeManager welcomeManager) {
        toLogin.setOnAction(actionEvent -> {
            welcomeManager.login();
        });

        loan.setOnAction((actionEvent -> welcomeManager.loan()));
    }


}
