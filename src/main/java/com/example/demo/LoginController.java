package com.example.demo;

import javafx.animation.Animation;
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
public class LoginController {
    @FXML
    private TextField user, password;
    @FXML
    private Button loginButton, back, forgot_password;
    @FXML
    private Label login_status;

    /**
     * init button in login scene
     */
    public void initManager(LoginManager loginManager) {
        login_status.setVisible(false);

        loginButton.setOnAction(event -> {
            try {
                if (loginManager.authorize(user.getText(), password.getText()) == LoanApp.USER_NOT_EXIST)
                    incorrectLogin();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        password.setOnAction(event -> {
            try {
                if (loginManager.authorize(user.getText(), password.getText()) == LoanApp.USER_NOT_EXIST)
                    incorrectLogin();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        user.setOnAction(event -> {
            try {
                if (loginManager.authorize(user.getText(), password.getText()) == LoanApp.USER_NOT_EXIST)
                    incorrectLogin();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        back.setOnAction(actionEvent -> {
            loginManager.goWelcome();
        });
        forgot_password.setOnAction(actionEvent -> loginManager.forgotPassword());
    }

    protected void incorrectLogin() {
        Timeline msg_flasher = new Timeline(
                new KeyFrame(Duration.seconds(0.2), e -> {
                    login_status.setVisible(true);
                }),
                new KeyFrame(Duration.seconds(3.0), e -> {
                    login_status.setVisible(false);
                }));
        msg_flasher.setCycleCount(1);
        msg_flasher.play();
    }

    public TextField getUser() {
        return user;
    }

    public TextField getPassword() {
        return password;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public Button getBack() {
        return back;
    }
}

