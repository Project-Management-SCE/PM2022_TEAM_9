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

    public void showRegistration(){
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


    public int authorize(TextField pass, TextField re_pass, TextField email, TextField name) {
        if (email.getText().isEmpty() || name.getText().isEmpty() || pass.getText().isEmpty() || re_pass.getText().isEmpty()){
            error.setHeaderText("Input all the Fields");
            error.showAndWait();

            if(Objects.equals(pass.getText(), re_pass.getText())){
                //for now we wont put into data base because we will implement this after the user
                // had asked for a loan, so this would be moved to after the submission to loan
                return 1;
            }
            else {
                error.setHeaderText("password not match!");
                error.showAndWait();

                System.out.println("not match");
                return 0;
            }

        }

        error.setHeaderText("Registered Successfully");
        error.showAndWait();
        return 1;


    }


}
