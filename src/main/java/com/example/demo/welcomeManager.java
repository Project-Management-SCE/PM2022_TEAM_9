package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class welcomeManager {
    private final Scene scene;

    public welcomeManager(Scene scene) {
        this.scene = scene;
    }

    /**
     * go from welcome page to login page
     */
    public void login() {
        LoginManager log = new LoginManager(scene);
        log.showLoginScreen();
    }

    /**
     * go from welcome page to loan page
     */
    public void loan() {
        loanManager loanManager = new loanManager(scene);
        loanManager.showLoanScreen();
    }

    public void register(){
        registerManager registerManager = new registerManager(scene);
        registerManager.showRegistration();
    }
    /**
     * show welcome screen
     */
    public void showWelcomeScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("welcome.fxml"));
            System.out.println("welcome screen");
            scene.setRoot(loader.load());
            welcomeController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException e) {
            Logger.getLogger(welcomeManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }


}
