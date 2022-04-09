package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import static com.example.demo.LoanApp.sql;

import java.sql.SQLException;
import java.util.prefs.Preferences;


/**
 * Controls the main application screen
 */
public class userPanelController {

    @FXML
    private TextFlow balance, accountName;
    @FXML
    private MenuItem logoutButton, editProfileButton;





    public void initManager(userPanelManager userPanelManager) throws SQLException {
        Text loan = new Text(getLoan());
        Text account = new Text("David shalomov");
        balance.getChildren().add(loan); // print loan amount to user panel
        accountName.getChildren().add(account);

        logoutButton.setOnAction(actionEvent -> userPanelManager.goLogin());
        editProfileButton.setOnAction(event -> userPanelManager.edit());

    }


    public String getLoan() throws SQLException {
        Preferences userPrefrences = Preferences.userRoot();
        String x = userPrefrences.get("username","-1");
        String[][] y = sql.select("loans","loan_total",String.format("user_id='%s'", x));
        System.out.println(y[0][0]);
        return y[0][0];

    }


}