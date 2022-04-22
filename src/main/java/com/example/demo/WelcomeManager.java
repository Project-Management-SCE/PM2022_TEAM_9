package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WelcomeManager {
    private final Scene scene;

    public WelcomeManager(Scene scene) {
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
        LoanManager loanManager = new LoanManager(scene);
        loanManager.showLoanScreen();
    }

    public void register(){
        RegisterManager registerManager = new RegisterManager(scene);
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
            WelcomeController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException e) {
            Logger.getLogger(WelcomeManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }


}
