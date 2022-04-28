package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import static com.example.demo.LoanApp.sql;

import java.sql.SQLException;
import java.util.prefs.Preferences;


/**
 * Controls the main application screen
 */
public class UserPanelController {

    @FXML
    private TextFlow balance, accountName;
    @FXML
    private MenuItem logoutButton, editProfileButton, contactusButton;


    public void initManager(UserPanelManager userPanelManager) throws SQLException {
        Text loan = new Text(getLoan());
        Text account = new Text("David shalomov");
        balance.getChildren().add(loan); // print loan amount to user panel
        accountName.getChildren().add(account);
        logoutButton.setOnAction(actionEvent -> userPanelManager.goLogin());
        editProfileButton.setOnAction(event -> userPanelManager.edit());
        contactusButton.setOnAction(event -> userPanelManager.sendMessageBanker());

    }


    public String getLoan() throws SQLException {
        return sql.select("loans", "*", String.format("user_id=%s", LoginManager.logged_in_user.getInt("userid", LoanApp.USER_NOT_EXIST)))[0][2];
    }

}