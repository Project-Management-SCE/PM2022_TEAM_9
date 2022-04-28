package main.java.com.example.demo;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/** Controls the main application screen */
public class LogOutViewController {
    @FXML
    private Button logoutButton;
    @FXML
    private Label sessionLabel;

    public void initialize() {
    }

    public void initSessionID(final LoginManager loginManager, String sessionID) {
        sessionLabel.setText(sessionID);
        logoutButton.setOnAction(event -> {
            System.out.println("log out view controller");
            loginManager.initializeScreen();
        });
    }

}