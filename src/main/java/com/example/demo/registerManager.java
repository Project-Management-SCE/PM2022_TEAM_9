package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class registerManager {
    private Scene scene;

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


    public int authorize(TextField pass, TextField re_pass) {

        if(Objects.equals(pass.getText(), re_pass.getText())){
            showRegistration();
            return 1;
        }
        else
            return 0;



    }



}
