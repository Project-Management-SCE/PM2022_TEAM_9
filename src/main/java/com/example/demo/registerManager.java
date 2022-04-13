package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class registerManager {
    private Scene scene;
    Alert error = new Alert(Alert.AlertType.ERROR);

    public registerManager(Scene scene) {
        this.scene = scene;
    }

    public void showRegistration() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("register.fxml")
            );
            System.out.println("register manager");
            scene.setRoot(loader.load());
            registerController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void goWelcome() {
        welcomeManager welcomeManager = new welcomeManager(scene);
        welcomeManager.showWelcomeScreen();
    }


    public void authorize(TextField pass, TextField re_pass, TextField email, TextField username) {
        if (pass.getText().toString().equals("") || re_pass.getText().toString().equals("") || email.getText().toString().equals("") || username.getText().toString().equals("")) {
            error.setContentText("fill all the fields");
            error.showAndWait();
        }
        if (!Objects.equals(pass.getText(), re_pass.getText())) {
            error.setContentText("Passwords Do Not Match");
            error.showAndWait();
        }

    }

}
