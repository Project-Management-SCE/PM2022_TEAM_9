package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class WithdrawController {


    @FXML
    private Button withdrawButton, cancelButton;
    @FXML
    private TextField acc_num, branch, bank_name,full_name, amount;


    public void initManager(WithdrawManager withdrawManager) {
        withdrawButton.setOnAction(event -> withdrawManager.withdrawRequest(acc_num, branch, bank_name,full_name, amount));
        cancelButton.setOnAction(event -> withdrawManager.goBack());

    }
}
