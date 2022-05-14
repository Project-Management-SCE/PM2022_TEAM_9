package com.example.demo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InspectLoanManager {
    private final Scene scene;

    private final static int WINDOW_WIDTH = 495;
    private final static int WINDOW_HEIGHT = 675;

    public InspectLoanManager(Scene scene) {
        this.scene = scene;
    }

    public void initializeScreen(int loan_id) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("inspectLoan.fxml")
            );
            this.scene.setRoot(loader.load());
            this.scene.getWindow().setWidth(WINDOW_WIDTH);
            this.scene.getWindow().setHeight(WINDOW_HEIGHT);
            this.scene.setUserData(loader);

            InspectLoanController controller = loader.getController();
            controller.initManager(this, loan_id);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void goBack() {
        BankerPanelManager bankerPanelManager = new BankerPanelManager(scene);
        bankerPanelManager.initializeScreen();
    }

    public Scene getScene() {
        return scene;
    }


}
