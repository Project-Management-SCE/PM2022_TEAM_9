package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class manageUserManager {
    private Scene scene;

    public manageUserManager(Scene scene){
        this.scene = scene;
    }

    public void manageUsers(){
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("manageClients.fxml")
            );
            scene.setRoot(loader.load());
            manageUserController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
