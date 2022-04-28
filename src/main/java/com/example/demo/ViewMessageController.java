package main.java.com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class ViewMessageController {
    @FXML
    Button exit_message;
    @FXML
    TextField message_subject;
    @FXML
    TextArea message_body;
    @FXML
    Label sender_username;

    public void initManager(ViewMessageManager viewMessageManager) throws SQLException {
        exit_message.setOnAction(event -> viewMessageManager.returnToMessages());
    }


}
