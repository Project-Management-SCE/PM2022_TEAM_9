package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

public class MessagesPanelController implements Initializable {
    private final ObservableList<MessageModel> observable_list = FXCollections.observableArrayList();

    @FXML
    Button view_message, reply_msg, delete_msg;
    @FXML
    private TableView<MessageModel> messages_list;
    @FXML
    TableColumn<MessageModel, String> subject_col, message_col, sender_col;
    @FXML
    TableColumn<MessageModel, Date> time_col;

    public void initManager(MessagesPanelManager messagesPanelManager) {
        controlsConfiguration(messagesPanelManager);
    }

    private void controlsConfiguration(MessagesPanelManager messagesPanelManager) {
        reply_msg.setOnAction(event -> messagesPanelManager.replyMessage(messages_list.getSelectionModel().getSelectedItem()));
        delete_msg.setOnAction(event -> messagesPanelManager.deleteMessage(messages_list));
        view_message.setOnAction(event -> messagesPanelManager.viewMessage(messages_list.getSelectionModel().getSelectedItem()));
    }

    /**
     * Fill table with messages data
     *
     * @return ObservableList (MessageModel).
     */
    private ObservableList<MessageModel> messagesToTable() {
        try {
            String[][] messages = LoanApp.sql.select("mailbox", "*", String.format("receiver=%s", LoginManager.logged_in_user.getInt("userid", LoanApp.USER_NOT_EXIST)));
            for (String[] message : messages) {
                String sender = LoanApp.sql.select("users", "username", String.format("id=%s", message[1]))[0][0];
                observable_list.add(new MessageModel(Integer.parseInt(message[0]), message[3], message[4], message[5], sender));
            }
            return observable_list;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        subject_col.setCellValueFactory(new PropertyValueFactory<>("Subject"));
        message_col.setCellValueFactory(new PropertyValueFactory<>("Message"));
        time_col.setCellValueFactory(new PropertyValueFactory<>("Time"));
        sender_col.setCellValueFactory(new PropertyValueFactory<>("Sender"));
        messages_list.setItems(messagesToTable());
    }
}
