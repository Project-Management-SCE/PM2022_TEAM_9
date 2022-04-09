package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class managerPanelManager {
    private Scene scene;

    public managerPanelManager(Scene scene){
        this.scene = scene;
    }

    public void showManagerPanel() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("managerPanel.fxml")
            );
            System.out.println("show manager panel");
            scene.setRoot(loader.load());
            managerPanelController controller = loader.getController();
            controller.initManager(this);
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
        editProfileManager editProfileManager = new editProfileManager(scene);
        editProfileManager.editProfile();
    }
}
