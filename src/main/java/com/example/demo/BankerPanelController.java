package com.example.demo;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.util.Duration;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;


public class BankerPanelController implements PropertyChangeListener {
    @FXML
    private MenuItem logoutButton, editProfileButton, todolistButton, aboutButton, modifyAccountButton, homeButton;
    @FXML
    private Label new_messages_quantity, message_icon;

    private Timeline msg_flasher;
    private Boolean isUserNotified = false;

    public void initManager(BankerPanelManager bankerPanelManager) throws SQLException {
        controlsConfiguration(bankerPanelManager);
    }

    private void controlsConfiguration(BankerPanelManager bankerPanelManager) {
        logoutButton.setOnAction(actionEvent -> bankerPanelManager.goLogin());
        editProfileButton.setOnAction(event -> bankerPanelManager.edit());
        todolistButton.setOnAction(event -> bankerPanelManager.showTodoList());
        message_icon.setOnMouseClicked(event -> bankerPanelManager.manageMessages());
        aboutButton.setOnAction(event -> System.out.println("TODO!"));

        homeButton.setOnAction(event -> {
            bankerPanelManager.initializeScreen();
        });

        modifyAccountButton.setOnAction(event -> {
            ModifyAccountManager modifyAccountManager = new ModifyAccountManager(bankerPanelManager.getScene());
            modifyAccountManager.initializeScreen();
        });

        aboutButton.setOnAction(event -> {
            AboutManager aboutManager = new AboutManager(bankerPanelManager.getScene());
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

    public MenuItem getLogoutButton() {
        return logoutButton;
    }

    public MenuItem getEditProfileButton() {
        return editProfileButton;
    }

    public MenuItem getTodolistButton() {
        return todolistButton;
    }

    public MenuItem getAboutButton() {
        return aboutButton;
    }

    public MenuItem getModifyAccountButton() {
        return modifyAccountButton;
    }

    public MenuItem getHomeButton() {
        return homeButton;
    }

    public Label getNew_messages_quantity() {
        return new_messages_quantity;
    }

    public Label getMessage_icon() {
        return message_icon;
    }

    public Timeline getMsg_flasher() {
        return msg_flasher;
    }

    public Boolean getUserNotified() {
        return isUserNotified;
    }
}
