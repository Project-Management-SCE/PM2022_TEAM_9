package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

public class ViewMessageController {
    @FXML
    Button exit_message;
    @FXML
    TextField message_subject;
    @FXML
    TextArea message_body;
    @FXML
    Label sender_username;
    @FXML
    MenuItem homeButton, manageUsersButton, editProfileButton, modifyAccountButton, logoutButton;

    public void initManager(ViewMessageManager viewMessageManager) throws SQLException {
        exit_message.setOnAction(event -> viewMessageManager.returnToMessages());

        modifyAccountButton.setOnAction(event -> {
            ModifyAccountManager modifyAccountManager = new ModifyAccountManager(viewMessageManager.getScene());
            modifyAccountManager.initializeScreen();
        });

        homeButton.setOnAction(event -> {
            viewMessageManager.goBack();
        });

        manageUsersButton.setOnAction(event -> {
            ManageUsersManager manageUsersManager = new ManageUsersManager(viewMessageManager.getScene());
            manageUsersManager.initializeScreen();
        });

        editProfileButton.setOnAction(event -> {
            EditProfileManager editProfileManager = new EditProfileManager(viewMessageManager.getScene());
            editProfileManager.initializeScreen();
        });

        logoutButton.setOnAction(event -> {
            LoginManager loginManager = new LoginManager(viewMessageManager.getScene());
            loginManager.initializeScreen();
        });

        if (LoginManager.logged_in_user.getInt("role", LoanApp.USER_NOT_EXIST) == 2)
            editProfileButton.setVisible(false);

        if (LoginManager.logged_in_user.getInt("role", LoanApp.USER_NOT_EXIST) != 2)
            manageUsersButton.setVisible(false);


    }


}
