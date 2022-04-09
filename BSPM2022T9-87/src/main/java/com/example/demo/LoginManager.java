package com.example.demo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
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
    public void userPanel() {
        userPanelManager userPanelManager = new userPanelManager(scene);
        userPanelManager.showUserPanel();
    }

    public void ManagerPanel(){
        managerPanelManager managerPanelManager = new managerPanelManager(scene);
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
    public void authorize(TextField user, TextField pass) throws SQLException {
        String[][] x = sql.select("users", "username, password", String.format("username='%s',password='%s'", user.getText(), pass.getText()));
        String[][] r = sql.select("users", "role",String.format("username='%s',password='%s'", user.getText(), pass.getText()));
        String[][] id = sql.select("users", "id", String.format("username='%s'", user.getText()));
        int role = Integer.parseInt(r[0][0]); // get role number

        Preferences userPrefrences = Preferences.userRoot();
        userPrefrences.put("userid",id[0][0]); // keep id in userPrefrences

        Preferences userPrefrencesRole = Preferences.userRoot();
        userPrefrencesRole.put("role",r[0][0]); // keep role in userPrefrences
        if (x.length > 0 && role == 0) {
            userPanel();
        }
        else if(role == 2){
            ManagerPanel();
        }
        else
            System.out.println("Error!!!!!!");
    }

    /**
     * forgot password
     */
    public void goFP(){
        forgotPassManager forgotPassManager = new forgotPassManager(scene);
        forgotPassManager.forgotPassword();
    }


}