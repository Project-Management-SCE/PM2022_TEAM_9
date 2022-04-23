package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TodoListManager {
    private final Scene scene;
    private final static int WINDOW_WIDTH = 665;
    private final static int WINDOW_HEIGHT = 690;
    public final static int BRAND_NEW_NOTE = -1;

    public TodoListManager(Scene scene) {
        this.scene = scene;
    }

    public void manageTodoList() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("todoList.fxml")
            );
            scene.setRoot(loader.load());
            scene.getWindow().setWidth(WINDOW_WIDTH);
            scene.getWindow().setHeight(WINDOW_HEIGHT);

            TodoListController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void deleteItem(TableView<TodoListModel> items_list) {
        if (items_list.getSelectionModel().getSelectedItem() != null) {
            LoanApp.sql.delete("todolist", String.format("id=%s", items_list.getSelectionModel().getSelectedItem().getId()));
            items_list.getItems().remove(items_list.getSelectionModel().getSelectedItem());
        }
    }

    public void commitChange(TableView<TodoListModel> items_list) {
        if (items_list.getSelectionModel().getSelectedItem() != null) {
            String columns = "user_id, item, status";
            String todo_item = items_list.getSelectionModel().getSelectedItem().getItem();
            String status = items_list.getSelectionModel().getSelectedItem().getStatus();
            int note_id = items_list.getSelectionModel().getSelectedItem().getId();
            int bit_status;

            if (status.compareTo("NOT DONE") == 0)
                bit_status = 0;
            else
                bit_status = 1;

            if (note_id == BRAND_NEW_NOTE)
                LoanApp.sql.insert("todolist", String.format("%s", columns), String.format("%s,%s, CAST(%s AS BIT)", LoginManager.logged_in_user.getInt("userid", LoanApp.USER_NOT_EXIST), todo_item, bit_status));
            else
                System.out.println("TODO!");
        }
    }

    public void addItem(TableView<TodoListModel> items_list) {
        TodoListModel item = new TodoListModel(BRAND_NEW_NOTE, LoginManager.logged_in_user.getInt("userid", LoanApp.USER_NOT_EXIST), "Write New Task Here", "NOT DONE");
        items_list.getItems().add(item);

    }
}
