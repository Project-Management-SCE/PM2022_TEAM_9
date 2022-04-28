package main.java.com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ForgotPassController {

    @FXML
    private Button reset, back;
    @FXML
    private TextField email, user, new_pass;



    public void initManager(ForgotPassManager forgotPassManager){
        reset.setOnAction(event -> {
            try{
                forgotPassManager.authorize(user, email, new_pass);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        back.setOnAction(event -> forgotPassManager.goBack());
    }
}
