package main.java.com.example.demo;

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


public class ManagerPanelController implements PropertyChangeListener {
    private Boolean isUserNotified = false;
    private Timeline msg_flasher;
    @FXML
    private MenuItem logoutButton, editProfileButton, manage_clients;
    @FXML
    private Label new_messages_quantity, message_icon;

    public void initManager(ManagerPanelManager managerPanelManager) throws SQLException {
        controlsConfiguration(managerPanelManager);
    }

    private void controlsConfiguration(ManagerPanelManager managerPanelManager) {
        ////menu buttons
        logoutButton.setOnAction(actionEvent -> managerPanelManager.goLogin());
        editProfileButton.setOnAction(event -> managerPanelManager.edit());
        manage_clients.setOnAction(event -> managerPanelManager.manageClients());
        ///
        message_icon.setOnMouseClicked(event -> managerPanelManager.manageMessages());

        // new message icon blinker
        msg_flasher = new Timeline(
                new KeyFrame(Duration.seconds(0.8), e -> {message_icon.setVisible(false);}),
                new KeyFrame(Duration.seconds(1.6), e -> {message_icon.setVisible(true);}));
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

}
