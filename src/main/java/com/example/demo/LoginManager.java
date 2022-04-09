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
    private final Scene scene;


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
        PostgreSQL.prettyPrint(x);
        if (x.length > 0) {
            String[][] id = sql.select("users", "id", String.format("username='%s'", user.getText()));
//            System.out.println(id[0][0]);
            Preferences userPrefrences = Preferences.userRoot();
            userPrefrences.put("username",id[0][0]);
            userPanel();
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