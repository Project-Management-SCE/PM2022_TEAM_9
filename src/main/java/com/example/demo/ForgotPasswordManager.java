package com.example.demo;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;

import java.util.prefs.Preferences;

import static com.example.demo.LoanApp.sql;


/**
 * Manages control flow for logins
 */
public class ForgotPasswordManager {
    private final Scene scene;
    private final static int WINDOW_WIDTH = 366;
    private final static int WINDOW_HEIGHT = 436;

    protected final static Preferences logged_in_user = Preferences.userRoot().node("AUTHORIZED_USER");
    ;

    public ForgotPasswordManager(Scene scene) {
        this.scene = scene;
    }

    public void initializeScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("forgotPassword.fxml")
            );
            scene.setRoot(loader.load());
            this.scene.getWindow().setWidth(WINDOW_WIDTH);
            this.scene.getWindow().setHeight(WINDOW_HEIGHT);
            this.scene.setUserData(loader);

            ForgotPasswordController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * back button to go back to welcome screen
     */
    public void goWelcome() {
        WelcomeManager welcomeManager = new WelcomeManager(scene);
        welcomeManager.initializeScreen();
    }

    /**
     * Check authorization.
     */
    public boolean authorize(String username, String phone) throws SQLException {

        String[][] fetch_user = sql.select("users", "id", String.format("username='%s'", username));
        if (fetch_user.length == 0)
            return false;

        String[][] fetch_phone = sql.select("clients", "id", String.format("phone='%s', id=%s", phone, fetch_user[0][0]));
        return fetch_phone.length != 0;
    }

    protected void updatePassword(String password) {
        //Update user password
        sql.update("users", "password", String.format("password='%s'", password));
    }

    public Scene getScene() {
        return scene;
    }
}