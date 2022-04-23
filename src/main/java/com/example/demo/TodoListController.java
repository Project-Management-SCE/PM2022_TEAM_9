package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DefaultStringConverter;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TodoListController implements Initializable {
    private final ObservableList<TodoListModel> observable_list = FXCollections.observableArrayList();

    @FXML
    Button add_item, delete_item;
    @FXML
    private TableView<TodoListModel> todo_list;
    @FXML
    TableColumn<TodoListModel, String> to_do_col, status_col;

    public void initManager(TodoListManager todoListManager) {
        controlsConfiguration(todoListManager);
    }

    private void controlsConfiguration(TodoListManager todoListManager) {
        add_item.setOnAction(event -> todoListManager.addItem(todo_list));
        delete_item.setOnAction(event -> todoListManager.deleteItem(todo_list));

        //make table editable
        to_do_col.setEditable(true);
        todo_list.setEditable(true);
        to_do_col.setCellFactory(TextFieldTableCell.forTableColumn(new DefaultStringConverter()));
        to_do_col.setOnEditCommit(event -> todoListManager.commitChange(todo_list));
    }

    /**
     * Fill table with messages data
     *
     * @return ObservableList (MessageModel).
     */
    private ObservableList<TodoListModel> itemsToTable() {
        try {
            String[][] items = LoanApp.sql.select("todolist", "*", String.format("user_id=%s", LoginManager.logged_in_user.getInt("userid", LoanApp.USER_NOT_EXIST)));
            for (String[] item : items)
                observable_list.add(new TodoListModel(Integer.parseInt(item[0]), Integer.parseInt(item[1]), item[2], item[3]));
            return observable_list;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        to_do_col.setCellValueFactory(new PropertyValueFactory<>("Item"));
        status_col.setCellValueFactory(new PropertyValueFactory<>("Status"));
        todo_list.setItems(itemsToTable());
    }
}
