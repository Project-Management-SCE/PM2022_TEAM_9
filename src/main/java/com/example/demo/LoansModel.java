package com.example.demo;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class LoansModel {

    private final SimpleIntegerProperty id;
    private final SimpleDoubleProperty loan_amount;
    private final SimpleStringProperty status;

    public LoansModel(int id, String reference_id, String client_name, String request_date, double loan_amount, double remaining_amount, String status) {
        this.id = new SimpleIntegerProperty(id);
        SimpleStringProperty reference_id1 = new SimpleStringProperty(reference_id);
        SimpleStringProperty client_name1 = new SimpleStringProperty(client_name);
        SimpleStringProperty request_date1 = new SimpleStringProperty(request_date);
        this.loan_amount = new SimpleDoubleProperty(loan_amount);
        SimpleDoubleProperty remaining_amount1 = new SimpleDoubleProperty(remaining_amount);
        this.status = new SimpleStringProperty(status);
    }

    public int getId() {
        return id.get();
    }

    public double getLoan_amount() {
        return loan_amount.get();
    }

    public String getStatus() {
        return status.get();
    }

}