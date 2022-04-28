package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.sql.SQLException;

public class EditProfileController {

    @FXML
    private Button submit, back;

    public void initManager(EditProfileManager editProfileManager){
        submit.setOnAction(event -> editProfileManager.initializeScreen());
        back.setOnAction(event -> {
            try {
                editProfileManager.goBack();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

}
