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
    Button send_new_msg, reply_msg, delete_msg;
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
        //TODO
    }

    private ObservableList<MessageModel> messagesToTable() {
        try {
            String[][] messages = LoanApp.sql.select("mailbox", "*", String.format("receiver=%s", LoginManager.logged_in_user.getInt("userid",LoanApp.USER_NOT_EXIST)));
            for (String[] message : messages)
                observable_list.add(new MessageModel(message[3], message[4], message[5], message[1]));
            return observable_list;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        subject_col.setCellValueFactory(new PropertyValueFactory<>("Subject"));
        message_col.setCellValueFactory(new PropertyValueFactory<>("Message"));
        time_col.setCellValueFactory(new PropertyValueFactory<>("Time"));
        sender_col.setCellValueFactory(new PropertyValueFactory<>("Sender"));
        //add your data to the table here.
        messages_list.setItems(messagesToTable());
    }
}
