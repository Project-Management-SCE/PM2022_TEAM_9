package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.example.demo.LoanApp.sql;

public class ForgotPassManager {
    public final Scene scene;

    public ForgotPassManager(Scene scene) {
        this.scene = scene;
    }

    /**
     *
     */
    public void forgotPassword(){
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("forgot.fxml")
            );
            scene.setRoot(loader.load());
            ForgotPassController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void goBack(){
        LoginManager loginManager = new LoginManager(scene);
        loginManager.showLoginScreen();
    }

    public void authorize(TextField user , TextField email, TextField new_pass) throws SQLException {
        System.out.println("authorization forgot password");
        String[][] check = sql.select("users", "username,email", String.format("username='%s',email='%s'",user.getText(), email.getText()));
        PostgreSQL.prettyPrint(check);

        if(check.length >0)
            sql.update("users", "password", new_pass.getText(),String.format("username='%s' , email='%s'",user.getText(), email.getText()));

        else
            System.out.println("Error!");

    }
}
