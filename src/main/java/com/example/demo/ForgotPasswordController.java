package com.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.util.Duration;

import java.sql.SQLException;


/**
 * Controls the login screen
 */
public class ForgotPasswordController {
    @FXML
    private TextField username, phone;
    @FXML
    private Button validateButton, homeButton;
    @FXML
    private Label resetStatus;

    /**
     * init button in login scene
     */
    public void initManager(ForgotPasswordManager forgotPasswordManager) {

        resetStatus.setVisible(false);

        validateButton.setOnAction(event -> {
            try {
                if (username.getText().length() == 0 || phone.getText().length() == 0)
                    incorrectDetails();
                if (!forgotPasswordManager.authorize(username.getText(), phone.getText()))
                    incorrectDetails();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        homeButton.setOnAction(actionEvent -> {
            forgotPasswordManager.goWelcome();
        });
        validateButton.setOnAction(actionEvent -> {
            try {
                if(forgotPasswordManager.authorize(username.getText(), phone.getText())){
                    username.setText("Password: ");
                    phone.setText("Repeat Password: ");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    protected void incorrectDetails() {
        Timeline msg_flasher = new Timeline(
                new KeyFrame(Duration.seconds(0.2), e -> {
                    resetStatus.setVisible(true);
                }),
                new KeyFrame(Duration.seconds(3.0), e -> {
                    resetStatus.setVisible(false);
                }));
        msg_flasher.setCycleCount(1);
        msg_flasher.play();
    }
}

