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
    private final Scene scene;
    protected final static Preferences logged_in_user = Preferences.userRoot().node("AUTHORIZED_USER");;

    public LoginManager(Scene scene) {
        this.scene = scene;
    }

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
        UserPanelManager userPanelManager = new UserPanelManager(scene);
        userPanelManager.showUserPanel();
    }

    public void ManagerPanel(){
        ManagerPanelManager managerPanelManager = new ManagerPanelManager(scene);
        managerPanelManager.showManagerPanel();
    }
    /**
     * back button to go back to welcome screen
     */
    public void goWelcome() {
        WelcomeManager welcomeManager = new WelcomeManager(scene);
        welcomeManager.showWelcomeScreen();
    }

    /**
     * Check authorization.
     */
    public int authorize(TextField user, TextField pass) throws SQLException {

        String[][] fetch = sql.select("users", "*", String.format("username='%s',password='%s'", user.getText(), pass.getText()));
        if(fetch.length ==0)
            return -1;
        logged_in_user.putInt("userid", Integer.parseInt(fetch[0][0])); // keep id in userPrefrences
        logged_in_user.put("username", fetch[0][1]);
        logged_in_user.put("password", fetch[0][2]);
        logged_in_user.put("email", fetch[0][3]);
        logged_in_user.putInt("role", Integer.parseInt(fetch[0][4]));
        logged_in_user.put("last_login", fetch[0][5]);

        if (logged_in_user.getInt("role", -1) == 0) {
            userPanel();
            return 0;
        }
        else if(logged_in_user.getInt("role",LoanApp.USER_NOT_EXIST) == 2){
            ManagerPanel();
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
        ForgotPassManager forgotPassManager = new ForgotPassManager(scene);
        forgotPassManager.forgotPassword();
    }


}