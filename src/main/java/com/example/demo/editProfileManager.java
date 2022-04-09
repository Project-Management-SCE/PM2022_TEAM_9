package com.example.demo;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class editProfileManager {

    private Scene scene;

    public editProfileManager(Scene scene){
        this.scene = scene;
    }

    public void editProfile() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("editProfile.fxml")
            );
            scene.setRoot(loader.load());
            editProfileController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void goBack(){
        userPanelManager userPanelManager = new userPanelManager(scene);
        userPanelManager.showUserPanel();
    }
}
