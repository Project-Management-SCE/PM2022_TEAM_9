package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;


public class userPanelManager {
    private  Scene scene;
    private Preferences data;

    public userPanelManager(Scene scene, Preferences data) {
        this.scene = scene;
        this.data = data;
    }

    public void showUserPanel() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("userPanel.fxml")
            );
            System.out.println("show user panel");
            scene.setRoot(loader.load());
            userPanelController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void goLogin() {
        LoginManager loginManager = new LoginManager(scene);
        loginManager.showLoginScreen();
    }

    public  void edit(){
        editProfileManager editProfileManager = new editProfileManager(scene, data);
        editProfileManager.editProfile();
    }


}
