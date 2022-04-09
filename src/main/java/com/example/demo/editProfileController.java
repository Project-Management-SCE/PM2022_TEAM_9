package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class editProfileController {



    @FXML
    private Button submit, back;

    public void initManager(editProfileManager editProfileManager){
        submit.setOnAction(event -> editProfileManager.editProfile());
        back.setOnAction(event -> editProfileManager.goBack());
    }

}
