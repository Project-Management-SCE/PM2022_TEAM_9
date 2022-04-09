package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

import java.sql.SQLException;


public class managerPanelController {

    @FXML
    private MenuItem logoutButton, editProfileButton;

    public void initManager(managerPanelManager managerPanelManager) throws SQLException {
        System.out.println("init manager panel");
        logoutButton.setOnAction(actionEvent -> managerPanelManager.goLogin());
        editProfileButton.setOnAction(event -> managerPanelManager.edit());
    }




}
