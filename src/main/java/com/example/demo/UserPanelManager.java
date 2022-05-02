package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserPanelManager {
    private final Scene scene;
    private final static int WINDOW_WIDTH = 650;
    private final static int WINDOW_HEIGHT = 650;
    public UserPanelManager(Scene scene) {
        this.scene = scene;
    }

    public void initializeScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("userPanel.fxml")
            );
            scene.setRoot(loader.load());
            scene.getWindow().setWidth(WINDOW_WIDTH);
            scene.getWindow().setHeight(WINDOW_HEIGHT);
            scene.setUserData(loader);
            UserPanelController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void goLogin() {
        LoginManager loginManager = new LoginManager(scene);
        loginManager.initializeScreen();
    }

    public  void edit(){
        EditProfileManager editProfileManager = new EditProfileManager(scene);
        editProfileManager.initializeScreen();
    }

    protected void sendMessageBanker(){
        SendMessageManager sendMessageManager = new SendMessageManager(scene);
        sendMessageManager.initializeScreen();
    }

    public Scene getScene() {
        return scene;
    }
}
