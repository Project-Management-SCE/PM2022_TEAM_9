package com.example.demo;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

public class editProfileManager {

    private Scene scene;
    private Preferences data;

    public editProfileManager(Scene scene,Preferences data){
        this.scene = scene;
        this.data = data;
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

    /**
     * go back function from edit profile panel to ither user panel or manager panel
     * @throws SQLException
     */
    public void goBack() throws SQLException {
        int role = data.getInt("role", -1);
        if (role == 0){
            userPanelManager userPanelManager = new userPanelManager(scene, data);
            userPanelManager.showUserPanel();
        }
        else if(role == 2){
            ManagerPanelManager managerPanelManager = new ManagerPanelManager(scene, data);
            managerPanelManager.showManagerPanel();
        }

    }



}
