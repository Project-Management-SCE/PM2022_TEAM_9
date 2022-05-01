package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class EditProfileController {

    @FXML
    private Button updateButton, cancelButton;
    @FXML
    private TextField firstname, lastname, address, city, zipcode, country, phone, bank_number;

    public void initManager(EditProfileManager editProfileManager){
        updateButton.setOnAction(event -> editProfileManager.updateFormData(this));

        cancelButton.setOnAction(event -> {
            try {
                editProfileManager.goBack();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }

    public Button getUpdateButton() {
        return updateButton;
    }

    public TextField getFirstname() {
        return firstname;
    }

    public TextField getLastname() {
        return lastname;
    }

    public TextField getAddress() {
        return address;
    }

    public TextField getCity() {
        return city;
    }

    public TextField getZipcode() {
        return zipcode;
    }

    public TextField getCountry() {
        return country;
    }

    public TextField getPhone() {
        return phone;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public TextField getBank_number() {
        return bank_number;
    }
}
