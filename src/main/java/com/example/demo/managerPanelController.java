package com.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.util.Duration;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;


public class managerPanelController implements PropertyChangeListener {
    private static final String NEW_MESSAGE = "New Messages!";
    private static int TIMELINE_OFFSET = 0;
    private int NEW_MESSAGE_INDEX = 0;
    private static final int TEXT_SPEED = 120;

    private Boolean isMessageUnread = false;


    @FXML
    private MenuItem logoutButton, editProfileButton, manage_clients;

    @FXML
    private Label new_messages, new_messages_quantity;

    public void initManager(managerPanelManager managerPanelManager) throws SQLException {
        controlsConfiguration(managerPanelManager);
    }


    private void controlsConfiguration(managerPanelManager managerPanelManager) {
        logoutButton.setOnAction(actionEvent -> managerPanelManager.goLogin());
        editProfileButton.setOnAction(event -> managerPanelManager.edit());
        manage_clients.setOnAction(event -> managerPanelManager.manageClients());

        // new messages animation
        new_messages.textProperty().addListener((observable, oldValue, newValue) -> {
            if (new_messages.getText().compareTo(NEW_MESSAGE) == 0) {
                TIMELINE_OFFSET = 0;
                NEW_MESSAGE_INDEX = 0;
                new_messages.setText("");
                new_messages_notifier(Integer.parseInt(new_messages_quantity.getText().replaceAll("[()]", "")));
            }
        });
    }

    private void new_messages_notifier(int amount) {
        if (isMessageUnread) {
            TIMELINE_OFFSET += TEXT_SPEED;
            new Timeline(new KeyFrame(Duration.millis(TIMELINE_OFFSET), ignore -> new_messages.setText((new_messages.getText() + NEW_MESSAGE.charAt(NEW_MESSAGE_INDEX++))))).play();

            if (TIMELINE_OFFSET != TEXT_SPEED * 13) {
                new_messages_quantity.setText("(" + amount + ")");
                new_messages_notifier(amount);

            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().compareTo("NEW_MESSAGE") == 0) { // if new message arrived
            if (isMessageUnread && new_messages.getText().compareTo("")!=0) // if "new messages" text still running
                new_messages_quantity.setText("(" + evt.getNewValue() + ")");
            else { //run "new messages" text
                new_messages_notifier((Integer) evt.getNewValue());
                isMessageUnread = true;
            }
        }

        if (evt.getPropertyName().compareTo("NO_NEW_MESSAGES") == 0) { // if no new message arrived
            if (isMessageUnread) {
                isMessageUnread = false;
                new_messages_quantity.setText("(" + evt.getNewValue() + ")");
            }
        }
    }
}
