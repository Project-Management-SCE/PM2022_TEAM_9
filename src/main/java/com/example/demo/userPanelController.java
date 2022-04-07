package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;



/**
 * Controls the main application screen
 */
public class userPanelController {

    @FXML
    private MenuBar menu;
    @FXML
    private MenuItem logoutButton;


    public void initManager(userPanelManager userPanelManager) {

        logoutButton.setOnAction(actionEvent -> userPanelManager.goLogin());


    }



}