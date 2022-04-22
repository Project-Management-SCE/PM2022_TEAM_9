package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReplyMessageManager {
    private final Scene scene;
    private final static int WINDOW_WIDTH = 665;
    private final static int WINDOW_HEIGHT = 690;

    public ReplyMessageManager(Scene scene) {
        this.scene = scene;
    }

    public void showReplyScreen(MessageModel selectedMessage) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("replyMessage.fxml")
            );
            scene.setRoot(loader.load());
            scene.getWindow().setWidth(WINDOW_WIDTH);
            scene.getWindow().setHeight(WINDOW_HEIGHT);

            ReplyMessageController controller = loader.getController();
            loadMessageData(controller, selectedMessage);
            controller.initManager(this);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadMessageData(ReplyMessageController controller, MessageModel m) {
        controller.message_subject.setText("Reply: " + m.getSubject());
        controller.message_body.setText(" \n" + "--------------------------------------------------------------------------------------------\n" + m.getMessage());
        controller.replying_to.setText(String.format("Reply #%s", m.getSender()));
    }

    public void returnToMessages(){
        MessagesPanelManager messagesPanelManager = new MessagesPanelManager(scene);
        messagesPanelManager.manageMessages();
    }
}
