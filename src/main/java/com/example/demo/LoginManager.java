package com.example.demo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.TextField;

import java.util.prefs.Preferences;

import static com.example.demo.LoanApp.sql;


/**
 * Manages control flow for logins
 */
public class LoginManager {
    private  Scene scene;

    public LoginManager(Scene scene) {
        this.scene = scene;
    }


//    public void login() {
//        showLoginScreen();
//    }
    public void showLoginScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("login.fxml")
            );
            System.out.println("login manager");
            scene.setRoot(loader.load());
            LoginController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * show user panel
     */
    public void userPanel(Preferences data) {
        userPanelManager userPanelManager = new userPanelManager(scene, data);
        userPanelManager.showUserPanel();
    }

    public void ManagerPanel(Preferences data){
        managerPanelManager managerPanelManager = new managerPanelManager(scene,data);
        managerPanelManager.showManagerPanel();
    }
    /**
     * back button to go back to welcome screen
     */
    public void goWelcome() {
        welcomeManager welcomeManager = new welcomeManager(scene);
        welcomeManager.showWelcomeScreen();
    }

    /**
     * Check authorization.
     */
    public int authorize(TextField user, TextField pass) throws SQLException {

        String[][] fetch = sql.select("users", "*", String.format("username='%s',password='%s'", user.getText(), pass.getText()));
        if(fetch.length ==0)
            return -1;
        Preferences user_data = Preferences.userRoot().node("LOGIN PANEL");
        user_data.putInt("userid", Integer.parseInt(fetch[0][0])); // keep id in userPrefrences
        user_data.put("username", fetch[0][1]);
        user_data.put("password", fetch[0][2]);
        user_data.put("email", fetch[0][3]);
        user_data.putInt("role", Integer.parseInt(fetch[0][4]));
        user_data.put("last_login", fetch[0][5]);

        if (user_data.getInt("role", -1) == 0) {
            userPanel(user_data);
            return 0;
        }
        else if(user_data.getInt("role",-1) == 2){
            ManagerPanel(user_data);
            return 0;
        }
        else
            System.out.println("Error!!!!!!");
        return 0;
    }

    /**
     * forgot password
     */
    public void goFP(){
        forgotPassManager forgotPassManager = new forgotPassManager(scene);
        forgotPassManager.forgotPassword();
    }


}