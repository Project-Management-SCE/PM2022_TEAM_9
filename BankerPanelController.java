package com.example.demo;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Duration;
import javafx.util.converter.DefaultStringConverter;
import javafx.util.converter.DoubleStringConverter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class BankerPanelController implements PropertyChangeListener, Initializable {
    @FXML
    private MenuItem logoutButton, editProfileButton, todolistButton, aboutButton, modifyAccountButton, homeButton;
    @FXML
    private Label new_messages_quantity, message_icon;
    @FXML
    private TableView<LoansModel> loans_table;
    @FXML
    private TableColumn<LoansModel, Integer> reference_id_col;
    @FXML
    private TableColumn<LoansModel, String> client_name_col, request_date_col, status_col;
    @FXML
    private TableColumn<LoansModel, Double> loan_amount_col, remaining_amount_col;


    private Timeline msg_flasher;
    private Boolean isUserNotified = false;
    protected final ObservableList<LoansModel> loans_list = FXCollections.observableArrayList();

    public void initManager(BankerPanelManager bankerPanelManager) throws SQLException {
        controlsConfiguration(bankerPanelManager);
    }

    private void controlsConfiguration(BankerPanelManager bankerPanelManager) {
        logoutButton.setOnAction(actionEvent -> bankerPanelManager.goLogin());
        editProfileButton.setOnAction(event -> bankerPanelManager.edit());
        todolistButton.setOnAction(event -> bankerPanelManager.showTodoList());
        message_icon.setOnMouseClicked(event -> bankerPanelManager.manageMessages());

        aboutButton.setOnAction(event -> {
            AboutManager aboutManager = new AboutManager(bankerPanelManager.getScene());
            aboutManager.initializeScreen();
        });

        homeButton.setOnAction(event -> {
            bankerPanelManager.initializeScreen();
        });

        modifyAccountButton.setOnAction(event -> {
            ModifyAccountManager modifyAccountManager = new ModifyAccountManager(bankerPanelManager.getScene());
            modifyAccountManager.initializeScreen();
        });

        aboutButton.setOnAction(event -> {
            AboutManager aboutManager = new AboutManager(bankerPanelManager.getScene());
            aboutManager.initializeScreen();
        });

        // sort columns
        remaining_amount_col.setSortType(TableColumn.SortType.DESCENDING);
        client_name_col.setSortType(TableColumn.SortType.DESCENDING);
        request_date_col.setSortType(TableColumn.SortType.DESCENDING);
        loan_amount_col.setSortType(TableColumn.SortType.DESCENDING);
        remaining_amount_col.setSortType(TableColumn.SortType.DESCENDING);
        status_col.setSortType(TableColumn.SortType.DESCENDING);

        //make table editable
        status_col.setEditable(true);
        loan_amount_col.setEditable(true);
        loans_table.setEditable(true);
        loan_amount_col.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        status_col.setCellFactory(ChoiceBoxTableCell.forTableColumn("APPROVED", "PENDING", "REJECTED"));

        status_col.setOnEditCommit(event -> {
            try {
                bankerPanelManager.commitChange(loans_table, event, null);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            loans_table.getItems().removeAll(loans_table.getItems());
            loans_table.getSelectionModel().clearSelection();
            loans_table.setItems(itemsToTable());

        });

        loan_amount_col.setOnEditCommit(event -> {
            try {
                bankerPanelManager.commitChange(loans_table, null, event);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            loans_table.getItems().removeAll(loans_table.getItems());
            loans_table.getSelectionModel().clearSelection();
            loans_table.setItems(itemsToTable());

        });


        // new message icon blinker
        msg_flasher = new Timeline(
                new KeyFrame(Duration.seconds(0.8), e -> message_icon.setVisible(false)),
                new KeyFrame(Duration.seconds(1.6), e -> message_icon.setVisible(true)));
        msg_flasher.setCycleCount(Animation.INDEFINITE);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().compareTo("NEW_MESSAGE") == 0) { // if new message arrived
            if (isUserNotified) // if mailbox still blinking running
                new_messages_quantity.setText("(" + evt.getNewValue() + ")");
            else {
                msg_flasher.play();
                isUserNotified = true;
                new_messages_quantity.setText("(" + evt.getNewValue() + ")");
            }
        }

        if (evt.getPropertyName().compareTo("NO_NEW_MESSAGES") == 0) { // if no new message arrived
            msg_flasher.stop();
            isUserNotified = false;
            new_messages_quantity.setText("(" + evt.getNewValue() + ")");
            message_icon.setVisible(true);
        }
    }

    /**
     * Fill table with messages data
     *
     * @return ObservableList (MessageModel).
     */
    protected ObservableList<LoansModel> itemsToTable() {
        try {
            String[][] clients = LoanApp.sql.select("users", "id", "role=0");
            for (String[] col : clients) {
                String[][] loan_form_data = LoanApp.sql.select("loan_form_data", "reference_id", String.format("user_id=%s", col[0]));
                String[][] loan_data = LoanApp.sql.select("loans", "*", String.format("user_id=%s", col[0]));
                String[][] full_name = LoanApp.sql.select("clients", "first_name, last_name", String.format("user_id=%s", col[0]));
                loans_list.add(new LoansModel(Integer.parseInt(loan_data[0][0]), loan_form_data[0][0], full_name[0][0] + " " + full_name[0][1], loan_data[0][2], Double.parseDouble(loan_data[0][3]), Double.parseDouble(loan_data[0][4]), loan_data[0][5]));
            }
            return loans_list;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reference_id_col.setCellValueFactory(new PropertyValueFactory<>("reference_id"));
        client_name_col.setCellValueFactory(new PropertyValueFactory<>("client_name"));
        request_date_col.setCellValueFactory(new PropertyValueFactory<>("request_date"));
        loan_amount_col.setCellValueFactory(new PropertyValueFactory<>("loan_amount"));
        remaining_amount_col.setCellValueFactory(new PropertyValueFactory<>("remaining_amount"));
        status_col.setCellValueFactory(new PropertyValueFactory<>("status"));
        loans_table.setItems(itemsToTable());
    }

    public MenuItem getLogoutButton() {
        return logoutButton;
    }

    public MenuItem getEditProfileButton() {
        return editProfileButton;
    }

    public MenuItem getTodolistButton() {
        return todolistButton;
    }

    public MenuItem getAboutButton() {
        return aboutButton;
    }

    public MenuItem getModifyAccountButton() {
        return modifyAccountButton;
    }

    public MenuItem getHomeButton() {
        return homeButton;
    }

    public Label getNew_messages_quantity() {
        return new_messages_quantity;
    }

    public Label getMessage_icon() {
        return message_icon;
    }

    public Timeline getMsg_flasher() {
        return msg_flasher;
    }

    public Boolean getUserNotified() {
        return isUserNotified;
    }

    public TableView<LoansModel> getLoans_list() {
        return loans_table;
    }

    public TableColumn<LoansModel, Integer> getLoan_id_column() {
        return reference_id_col;
    }

    public TableColumn<LoansModel, String> getClient_name_column() {
        return client_name_col;
    }

    public TableColumn<LoansModel, String> getRequest_date_column() {
        return request_date_col;
    }

    public TableColumn<LoansModel, String> getStatus_column() {
        return status_col;
    }

    public TableColumn<LoansModel, Double> getLoan_amount_column() {
        return loan_amount_col;
    }

    public TableColumn<LoansModel, Double> getRemaining_amount_column() {
        return remaining_amount_col;
    }
}
