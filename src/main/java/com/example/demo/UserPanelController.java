package com.example.demo;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

import static com.example.demo.LoanApp.sql;


/**
 * Controls the main application screen
 */
public class UserPanelController implements PropertyChangeListener {
    @FXML
    private Label accountLabel, balanceLabel;
    @FXML
    private MenuItem withdraw, complaint,logoutButton, editProfileButton, contactusButton, aboutButton, modifyAccountButton, homeButton;
    @FXML
    private Label new_messages_quantity, message_icon;

    private Timeline msg_flasher;
    private Boolean isUserNotified = false;


    public void initManager(UserPanelManager userPanelManager) throws SQLException {
        logoutButton.setOnAction(actionEvent -> userPanelManager.goLogin());
        editProfileButton.setOnAction(event -> userPanelManager.edit());
        contactusButton.setOnAction(event -> userPanelManager.sendMessageBanker());
        complaint.setOnAction(event -> userPanelManager.goComplaint());
        withdraw.setOnAction(event -> userPanelManager.Withdraw());
        modifyAccountButton.setOnAction(event -> {
            ModifyAccountManager modifyAccountManager = new ModifyAccountManager(userPanelManager.getScene());
            modifyAccountManager.initializeScreen();
        });

        homeButton.setOnAction(event -> {
            userPanelManager.initializeScreen();
        });

        accountLabel.setText(AccountFullName());
        balanceLabel.setText("$" + latestLoanAmount());

        aboutButton.setOnAction(event -> {
            AboutManager aboutManager = new AboutManager(userPanelManager.getScene());
            aboutManager.initializeScreen();
        });

        // new message icon blinker
        msg_flasher = new Timeline(
                new KeyFrame(Duration.seconds(0.8), e -> message_icon.setVisible(false)),
                new KeyFrame(Duration.seconds(1.6), e -> message_icon.setVisible(true)));
        msg_flasher.setCycleCount(Animation.INDEFINITE);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().compareTo("NEW_MESSAGE") == 0) { // if new message arrived
            if (isUserNotified) // if mailbox still blinking running
                new_messages_quantity.setText("(" + evt.getNewValue() + ")");
            else {
                msg_flasher.play();
                isUserNotified = true;
                new_messages_quantity.setText("(" + evt.getNewValue() + ")");
            }
        }

        if (evt.getPropertyName().compareTo("NO_NEW_MESSAGES") == 0) { // if no new message arrived
            msg_flasher.stop();
            isUserNotified = false;
            new_messages_quantity.setText("(" + evt.getNewValue() + ")");
            message_icon.setVisible(true);
        }
    }

    private String latestLoanAmount() throws SQLException {
        return sql.select("loans", "*", String.format("user_id=%s", LoginManager.logged_in_user.getInt("userid", LoanApp.USER_NOT_EXIST)))[0][2];
    }

    private String AccountFullName() throws SQLException {
        String[] loan_ids = sql.select("loans", "id", String.format("user_id=%s", LoginManager.logged_in_user.getInt("userid", LoanApp.USER_NOT_EXIST)))[0];
        String latest_loan = "0";
        for (int i = 0; i < loan_ids.length; i++) {
            if (Integer.parseInt(loan_ids[0]) > Integer.parseInt(latest_loan))
                latest_loan = loan_ids[0];
        }
        String[] fetch_name = sql.select("loan_form_data", "first_name, last_name", String.format("id=%s", latest_loan))[0];
        return fetch_name[0] + " " + fetch_name[1];
    }

}