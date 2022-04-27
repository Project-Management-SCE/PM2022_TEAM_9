package com.example.demo;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditProfileManager {
    private final Scene scene;

    public EditProfileManager(Scene scene){
        this.scene = scene;
    }

    public void initializeScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("editProfile.fxml")
            );
            scene.setRoot(loader.load());
            EditProfileController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * go back function from edit profile panel to ither user panel or manager panel
     */
    public void goBack() throws SQLException {
        int role = LoginManager.logged_in_user.getInt("role", -1);
        if (role == 0){
            UserPanelManager userPanelManager = new UserPanelManager(scene);
            userPanelManager.initializeScreen();
        }
        else if(role == 2){
            ManagerPanelManager managerPanelManager = new ManagerPanelManager(scene);
            managerPanelManager.initializeScreen();
        }

    }



}
