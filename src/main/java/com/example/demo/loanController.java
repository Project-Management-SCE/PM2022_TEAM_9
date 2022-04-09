package com.example.demo;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Date;

public class loanController {
    private String[] data = new String[4];
    private
    ObservableList<String> sexList = FXCollections.observableArrayList("Male", "Female", "Other");
    ObservableList<String> countryList = FXCollections.observableArrayList("Israel", "America");
    ObservableList<String> ownCarList = FXCollections.observableArrayList("Yes", "No");
    @FXML
    private Button clear, next, back;
    @FXML
    private DatePicker age;
    @FXML
    private ChoiceBox<String> country,own_car,gender;

    @FXML
    private TextField name, amount, income, expenses;

    @FXML
    private Pagination pagination;


    public void initManager(loanManager loanManager) {
        // set back button
        back.setOnAction(actionEvent -> loanManager.goBack());

        clear.setOnAction(actionEvent -> {
            name.clear();
            amount.clear();
            income.clear();
            expenses.clear();
//            country.getItems().clear();
//            gender.getItems().clear();
//            own_car.getItems().clear();
//            age.getEditor().clear();
        });

        // set pagination
        pagination.setPageFactory(this::getPage);
        loanManager.nextPage(pagination.getCurrentPageIndex());



        country.setItems(countryList); // set country choice box
        gender.setItems(sexList);// set gender choice box
        own_car.setItems(ownCarList);// set own car choice box

    }

    public Label getPage(int pageIndex){

        Label content = null;
        if (pageIndex >= 0 && pageIndex < 4){
            if(data[pageIndex] == null){
                data[pageIndex] = "content for page " + (pageIndex + 1) + " / " + new Date();
            }
            content = new Label(data[pageIndex]);
            content.setId("Label" + (pageIndex +1));
            //System.out.println(pageIndex+1);
        }
        return content;
    }



}
