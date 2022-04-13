package com.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.Objects;

public class registerController {

    @FXML
    private Button submit, back;
    @FXML
    private TextField username, email, pass, re_pass;
    @FXML
    private TextFlow error;

    final Label message = new Label("");


    public void initManager(registerManager registerManager){

        submit.setOnAction(event -> registerManager.authorize(pass,re_pass,email,username));


        back.setOnAction(event -> registerManager.goWelcome());
    }



}
