package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModifyUserManager {
    private final Scene scene;
    private final static int WINDOW_WIDTH = 665;
    private final static int WINDOW_HEIGHT = 690;

    public ModifyUserManager(Scene scene) {
        this.scene = scene;
    }

    public void manageUsers() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("manageClients.fxml"));
            scene.setRoot(loader.load());
            scene.getWindow().setWidth(WINDOW_WIDTH);
            scene.getWindow().setHeight(WINDOW_HEIGHT);

            ModifyUserController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteItem(TableView<ClientsModel> items_list) {
        if (items_list.getSelectionModel().getSelectedItem() != null) {
            LoanApp.sql.delete("users", String.format("id=%s", items_list.getSelectionModel().getSelectedItem().getId()));
            items_list.getItems().remove(items_list.getSelectionModel().getSelectedItem());
        }
    }

    public void commitChange(TableView<ClientsModel> items_list, TableColumn.CellEditEvent<ClientsModel, String > modified_data) {
//        if (items_list.getSelectionModel().getSelectedItem() != null) { // if row selected
//
//            if (modified_data.getNewValue().compareTo(modified_data.getOldValue()) != 0) { // if value did change
//                int note_id = items_list.getSelectionModel().getSelectedItem().getId();
//                String item_data = items_list.getSelectionModel().getSelectedItem().getItem();
//                String item_status = items_list.getSelectionModel().getSelectedItem().getStatus();
//                String columns = "user_id, item, status";
//
//                if (items_list.getFocusModel().getFocusedCell().getColumn() == 0) { //if To-do column selected
//                    if (note_id == BRAND_NEW_NOTE) // if new note inserted
//                        LoanApp.sql.insert("todolist", String.format("%s", columns), String.format("%s, '%s', '%s'", LoginManager.logged_in_user.getInt("userid", LoanApp.USER_NOT_EXIST), modified_data.getNewValue(), item_status));
//                    else
//                        LoanApp.sql.update("todolist", "item", String.format("%s", modified_data.getNewValue()), String.format("id=%s", note_id));
//                }
//
//                if (items_list.getFocusModel().getFocusedCell().getColumn() == 1) { //if Status column selected
//                    if (note_id == BRAND_NEW_NOTE) // if new note inserted
//                        LoanApp.sql.insert("todolist", String.format("%s", columns), String.format("%s, '%s', '%s'", LoginManager.logged_in_user.getInt("userid", LoanApp.USER_NOT_EXIST), item_data, modified_data.getNewValue()));
//                    else
//                        LoanApp.sql.update("todolist", "status", String.format("%s", modified_data.getNewValue()), String.format("id=%s", note_id));
//                }
//
//            }
//        }
//    }
        return;
    }

    protected void filterUsers(TableView<ClientsModel> clients_list, TextField search_criterion, ObservableList<ClientsModel> c){
        String keyword = search_criterion.getText();
        if (keyword.equals("")) {
            clients_list.getItems().removeAll();
            clients_list.setItems(c);
        } else {
            ObservableList<ClientsModel> filteredData = FXCollections.observableArrayList();
            for (ClientsModel client : clients_list.getItems()) {
                if(client.getUsername().contains(keyword))
                    filteredData.add(client);
            }
            clients_list.setItems(filteredData);
        }
    }

}
