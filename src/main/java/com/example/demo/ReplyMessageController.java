package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class ReplyMessageController {
    @FXML
    Button send_message, exit_message;
    @FXML
    TextField message_subject;
    @FXML
    TextArea message_body;
    @FXML
    Label replying_to;

    public void initManager(ReplyMessageManager replyMessageManager) throws SQLException {
        exit_message.setOnAction(event -> replyMessageManager.returnToMessages());
    }


}
