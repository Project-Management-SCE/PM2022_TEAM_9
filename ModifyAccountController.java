package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.sql.SQLException;

public class ModifyAccountController {

    @FXML
    private Button updateButton, cancelButton;
    @FXML
    private TextField username, email, password;

    public void initManager(ModifyAccountManager modifyAccountManager) {
        updateButton.setOnAction(event -> modifyAccountManager.updateFormData(this));
        cancelButton.setOnAction(event -> {
            try {
                modifyAccountManager.goBack();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }

    public Button getUpdateButton() {
        return updateButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public TextField getUsername() {
        return username;
    }

    public TextField getEmail() {
        return email;
    }

    public TextField getPassword() {
        return password;
    }
}
