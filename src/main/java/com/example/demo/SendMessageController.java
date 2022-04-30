package com.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.util.Duration;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;

import static com.example.demo.LoanApp.sql;

public class SendMessageController implements PropertyChangeListener {

    @FXML
    private Button send_message, exit_message;
    @FXML
    private TextField message_subject;
    @FXML
    private TextArea message_body;
    @FXML
    private Label message_sent_popup;
    @FXML
    private ComboBox<String> bankers_list;
    @FXML
    MenuItem logoutButton, editProfileButton, aboutButton, contactusButton, homeButton;


    public void initManager(SendMessageManager sendMessageManager) throws SQLException {
        sendMessageManager.getNotifier().addPropertyChangeListener(this);
        bankers_list.setItems(fetchBankers());
        bankers_list.getSelectionModel().select(0);
        message_sent_popup.setVisible(false);//hide success message sent

        logoutButton.setOnAction(event -> {
            LoginManager loginManager = new LoginManager(sendMessageManager.getScene());
            loginManager.initializeScreen();
        });

        homeButton.setOnAction(event -> {
            UserPanelManager userPanelManager = new UserPanelManager(sendMessageManager.getScene());
            userPanelManager.initializeScreen();
        });

        editProfileButton.setOnAction(event -> {
            EditProfileManager editProfileManager = new EditProfileManager(sendMessageManager.getScene());
            editProfileManager.initializeScreen();
        });

        aboutButton.setOnAction(event -> System.out.println("TODO!"));

        contactusButton.setOnAction(event -> {
            sendMessageManager.initializeScreen();
        });


        exit_message.setOnAction(event -> sendMessageManager.returnToMessages());
        send_message.setOnAction(event -> sendMessageManager.sendMessage(message_subject.getText(), message_body.getText(), bankers_list.getSelectionModel().getSelectedItem()));
    }

    public ObservableList<String> fetchBankers() throws SQLException {
        ObservableList<String> bankers_list = FXCollections.observableArrayList();
        String[][] fetched_bankers = sql.select("users", "email", "role=1");
        for (String[] banker : fetched_bankers)
            bankers_list.add(banker[0]);
        return bankers_list;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().compareTo("MESSAGE") == 0 && evt.getNewValue() instanceof Scene) {
            exit_message.setDisable(true);
            send_message.setDisable(true);
            ((Scene) (evt.getNewValue())).getRoot().setEffect(new BoxBlur(5.0, 5.0, 1));
            message_sent_popup.setVisible(true);
            new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                UserPanelManager userPanelManager = new UserPanelManager((Scene) (evt.getNewValue()));
                userPanelManager.initializeScreen();
            })).play();
        }
    }
}
