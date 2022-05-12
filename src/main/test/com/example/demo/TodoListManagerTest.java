package com.example.demo;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.testfx.framework.junit.ApplicationTest;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TodoListManagerTest extends ApplicationTest {

    private Scene scene;
    private FXMLLoader loader;
    private static final PostgreSQL sql = PostgreSQL.getInstance();
    private final String TEST_MESSAGE_IDENTIFIER = "TEST MESSAGE PLEASE IGNORE #9801456456";

    @BeforeClass
    public static void initSQL() {
        sql.openConnection();
    }

    @Override
    public void start(Stage stage)  {
        scene = new Scene(new StackPane());
        WelcomeManager welcomeManager = new WelcomeManager(scene);
        welcomeManager.initializeScreen();

        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.getIcons().add(new Image(String.format("file:%s\\src\\main\\resources\\com\\example\\demo\\img\\app_icon.jpg", System.getProperty("user.dir"))));
        stage.show();

        // Stage [Welcome]
        loader = (FXMLLoader) welcomeManager.getScene().getUserData();
        ((WelcomeController) loader.getController()).getLogin().fire();


        // Stage [Login]
        LoginManager loginManager = new LoginManager(scene);
        loginManager.initializeScreen();
        loader = (FXMLLoader) loginManager.getScene().getUserData();
        ((LoginController) loader.getController()).getUser().setText("liransm");
        ((LoginController) loader.getController()).getPassword().setText("PM2022");
        ((LoginController) loader.getController()).getLoginButton().fire();


        // Stage [BankerPanel]
        BankerPanelManager bankerPanelManager = new BankerPanelManager(scene);
        bankerPanelManager.initializeScreen();
        loader = (FXMLLoader) bankerPanelManager.getScene().getUserData();

    }

    @Test
    public void A1_initializeScreen() {
        // Stage [TodoList Panel]
        TodoListManager todoListManager = new TodoListManager(scene);
        todoListManager.initializeScreen();
        loader = (FXMLLoader) todoListManager.getScene().getUserData();
        assertNotNull(((TodoListController) loader.getController()).getTodo_list());

        assertNotEquals(((TodoListController) loader.getController()).getTodo_list().getItems().get(0).getItem(), "");
        assertNotEquals(((TodoListController) loader.getController()).getTodo_list().getItems().get(0).getStatus(), "");
    }

    @Test
    public void A4_deleteItem() {
        // Stage [TodoList Panel]
        TodoListManager todoListManager = new TodoListManager(scene);
        todoListManager.initializeScreen();
        loader = (FXMLLoader) todoListManager.getScene().getUserData();
        assertNotNull(((TodoListController) loader.getController()).getTodo_list());
        assertNotNull(((TodoListController) loader.getController()).getDelete_item());
        ((TodoListController) loader.getController()).getDelete_item().fire();

    }

    @Test
    public void A2_commitChange() {
        // Stage [TodoList Panel]
        TodoListManager todoListManager = new TodoListManager(scene);
        todoListManager.initializeScreen();
        loader = (FXMLLoader) todoListManager.getScene().getUserData();
        assertNotNull(((TodoListController) loader.getController()).getTodo_list());

        assertNotEquals(((TodoListController) loader.getController()).getTodo_list().getItems().get(0).getItem(), "");
        assertNotEquals(((TodoListController) loader.getController()).getTodo_list().getItems().get(0).getStatus(), "");

        ((TodoListController) loader.getController()).getTodo_list().getItems().get(0).setItem("MODIFIED FOR TEST");
        ((TodoListController) loader.getController()).getTodo_list().getItems().get(0).setStatus("DONE");
        ((TodoListController) loader.getController()).getTodo_list().refresh();
    }

    @Test
    public void A3_addItem() {
        // Stage [TodoList Panel]
        TodoListManager todoListManager = new TodoListManager(scene);
        todoListManager.initializeScreen();
        loader = (FXMLLoader) todoListManager.getScene().getUserData();
        assertNotNull(((TodoListController) loader.getController()).getTodo_list());
        ((TodoListController) loader.getController()).getAdd_item().fire();
    }
}