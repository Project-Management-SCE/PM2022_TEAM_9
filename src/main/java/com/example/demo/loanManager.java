package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class loanManager {
    private Scene scene;

    public loanManager(Scene scene) {
        this.scene = scene;
    }

    /**
     * show loan screen
     */
    public void showLoanScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("loan.fxml"));
            System.out.println("Loan screen");
            scene.setRoot(loader.load());
            loanController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException e) {
            Logger.getLogger(welcomeManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * go back from loan page to welcome page
     */
    public void goBack() {
        welcomeManager welcomeManager = new welcomeManager(scene);
        welcomeManager.showWelcomeScreen();
    }


    public void nextPage(int pageIndex) {

        if (pageIndex == 2) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("loan2.fxml"));
                scene.setRoot(loader.load());
                loanController controller = loader.getController();
                controller.initManager(this);
            } catch (IOException e) {
                Logger.getLogger(welcomeManager.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        if (pageIndex == 3) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("loan3.fxml"));
                scene.setRoot(loader.load());
                loanController controller = loader.getController();
                controller.initManager(this);
            } catch (IOException e) {
                Logger.getLogger(welcomeManager.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        if (pageIndex == 4) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("loan4.fxml"));
                scene.setRoot(loader.load());
                loanController controller = loader.getController();
                controller.initManager(this);
            } catch (IOException e) {
                Logger.getLogger(welcomeManager.class.getName()).log(Level.SEVERE, null, e);
            }

        }
    }

}
