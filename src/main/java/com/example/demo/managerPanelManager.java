package com.example.demo;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.util.Duration;

import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

public class managerPanelManager {
    private final Scene scene;
    private final Preferences data;
    private final static int WINDOW_WIDTH = 650;
    private final static int WINDOW_HEIGHT = 650;

    private PropertyChangeSupport notifier;


    public managerPanelManager(Scene scene, Preferences data){
        this.scene = scene;
        this.data = data;
        this.notifier = new PropertyChangeSupport(this);
    }


    public void showManagerPanel() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("managerPanel.fxml"));
            scene.setRoot(loader.load());
            scene.getWindow().setWidth(WINDOW_WIDTH);
            scene.getWindow().setHeight(WINDOW_HEIGHT);

            managerPanelController controller = loader.getController();
            notifier.addPropertyChangeListener(controller); // to notify controller
            controller.initManager(this);

            // Infinity Thread worker to check for new messages
            //--------------------------------
            fetchMessages();
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
                try {
                    fetchMessages();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
            //--------------------------------

        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void goLogin() {
        LoginManager loginManager = new LoginManager(scene);
        loginManager.showLoginScreen();
    }

    public void edit(){
        editProfileManager editProfileManager = new editProfileManager(scene,data);
        editProfileManager.editProfile();
    }

    public void manageClients(){
        manageUserManager manageUserManager = new manageUserManager(scene);
        manageUserManager.manageUsers();
    }

    private void fetchMessages() throws SQLException {
        //LoanApp.sql.insert("mailbox","1, 1, 1, 'Hello', 'Hi', TO_DATE('17/12/2015', 'DD/MM/YYYY'), CAST(0 AS BIT)");
        String [][] unread_messages = LoanApp.sql.select("mailbox", "read", "read=CAST(0 AS BIT)");
        if (unread_messages.length>0)
            notifier.firePropertyChange("NEW_MESSAGE", 0,unread_messages.length);
        if (unread_messages.length==0)
            notifier.firePropertyChange("NO_NEW_MESSAGES", -1,unread_messages.length);
    }
}
