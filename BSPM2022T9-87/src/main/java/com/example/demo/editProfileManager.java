package com.example.demo;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

import static com.example.demo.LoanApp.sql;

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

    /**
     * go back function from edit profile panel to ither user panel or manager panel
     * @throws SQLException
     */
    public void goBack() throws SQLException {
        int role = Integer.parseInt(getRole());
        if (role == 0){
            userPanelManager userPanelManager = new userPanelManager(scene);
            userPanelManager.showUserPanel();
        }
        else if(role == 2){
            managerPanelManager managerPanelManager = new managerPanelManager(scene);
            managerPanelManager.showManagerPanel();
        }

    }


    public String getRole() throws SQLException {
        Preferences userPrefrencesRole = Preferences.userRoot();
        String x = userPrefrencesRole.get("role","-1");
        String[][] y = sql.select("users","role",String.format("id='%s'", x));
        System.out.println("ROLE " + y[0][0]);
        return y[0][0];
    }
}
