package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class modifyUserManager {
    private Scene scene;

    public modifyUserManager(Scene scene){
        this.scene = scene;
    }

    public void manageUsers(){
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("manageClients.fxml")
            );
            scene.setRoot(loader.load());
            modifyUserController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
