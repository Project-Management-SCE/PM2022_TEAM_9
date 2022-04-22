package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessagesPanelManager {
    private final Scene scene;
    private final static int WINDOW_WIDTH = 665;
    private final static int WINDOW_HEIGHT = 690;

    public MessagesPanelManager(Scene scene) {
        this.scene = scene;
    }

    public void manageMessages() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("managerMessagesPanel.fxml")
            );
            scene.setRoot(loader.load());
            scene.getWindow().setWidth(WINDOW_WIDTH);
            scene.getWindow().setHeight(WINDOW_HEIGHT);

            MessagesPanelController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void viewMessage(MessageModel selectedMessage) {
        if (selectedMessage != null) {
            ViewMessageManager viewMessageManager = new ViewMessageManager(scene);
            viewMessageManager.showMessageScreen(selectedMessage);
        }
    }

    public void replyMessage(MessageModel selectedMessage) {
        if (selectedMessage != null) {
            ReplyMessageManager replyMessageManager = new ReplyMessageManager(scene);
            replyMessageManager.showReplyScreen(selectedMessage);
        }
    }

    public void deleteMessage(TableView<MessageModel> messages_list) {
        if (messages_list.getSelectionModel().getSelectedItem() != null) {
            LoanApp.sql.delete("mailbox", String.format("id=%s", messages_list.getSelectionModel().getSelectedItem().getID()));
            messages_list.getItems().remove(messages_list.getSelectionModel().getSelectedItem());
        }
    }
}
