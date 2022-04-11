package com.example.demo;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class loanManager {
    private Scene scene;
    private FXMLLoader loader;
    private final Preferences loan_form = Preferences.userRoot().node("LOAN FORM");

    private final static String UNDEFINED = "";

    public loanManager(Scene scene) {
        this.scene = scene;
        try {
            loan_form.clear();// clear HDD saved data
        } catch (BackingStoreException e) {
            e.printStackTrace();
        }
    }

    /**
     * show loan screen
     */
    public void showLoanScreen() {
        try {
            this.loader = new FXMLLoader(getClass().getResource("loan.fxml"));
            scene.setRoot(loader.load());
            loanController controller = loader.getController();
            controller.initManager(this);
            reloadForm(); // reload previous saved data
        } catch (IOException e) {
            Logger.getLogger(welcomeManager.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * go back from loan page to welcome page
     */
    public void goBack() {
        welcomeManager welcomeManager = new welcomeManager(scene);
        welcomeManager.showWelcomeScreen();
    }


    public void nextPage(int pageIndex) {

        if (pageIndex == 1) {
            try {
                System.out.println("page 2");
                savePage1(); // save current data
                this.loader = new FXMLLoader(getClass().getResource("loan2.fxml"));
                scene.setRoot(loader.load());
                loanController controller = loader.getController();
                controller.initManager2(this);
                reloadForm();
            } catch (IOException e) {
                Logger.getLogger(welcomeManager.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        if (pageIndex == 2) {
            try {
                System.out.println("page 3");
                savePage2();
                this.loader = new FXMLLoader(getClass().getResource("loan3.fxml"));
                scene.setRoot(loader.load());
                loanController controller = loader.getController();
                controller.initManager3(this);
                reloadForm();
            } catch (IOException e) {
                Logger.getLogger(welcomeManager.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        if (pageIndex == 3) { // submit for now
            try {
                System.out.println("submit");
                savePage3();
                this.loader = new FXMLLoader(getClass().getResource("submitLoan.fxml"));
                scene.setRoot(loader.load());
                loanController controller = loader.getController();
                controller.initManager4(this);
                reloadForm();
            } catch (IOException e) {
                Logger.getLogger(welcomeManager.class.getName()).log(Level.SEVERE, null, e);
            }

        }

    }


    private void savePage1() {
        if (((loanController) loader.getController()).getName() != null && ((loanController) loader.getController()).getName().getText().length() > 0)
            loan_form.put("full_name", ((loanController) loader.getController()).getName().getText());
        if (((loanController) loader.getController()).getAmount() != null && ((loanController) loader.getController()).getAmount().getText().length() > 0)
            loan_form.putDouble("loan_amount", Double.parseDouble(((loanController) loader.getController()).getAmount().getText()));
        if (((loanController) loader.getController()).getIncome() != null && ((loanController) loader.getController()).getIncome().getText().length() > 0)
            loan_form.putDouble("monthly_income", Double.parseDouble(((loanController) loader.getController()).getIncome().getText()));
        if (((loanController) loader.getController()).getExpenses() != null && ((loanController) loader.getController()).getExpenses().getText().length() > 0)
            loan_form.putDouble("monthly_expenses", Double.parseDouble(((loanController) loader.getController()).getExpenses().getText()));
        if (((loanController) loader.getController()).getCountry() != null && ((loanController) loader.getController()).getCountry().getValue().length() > 0)
            loan_form.put("country", ((loanController) loader.getController()).getCountry().getValue());
//        if (((loanController) loader.getController()).getCountry().getValue() != null && ((loanController) loader.getController()).getCountry().getValue().length() > 0)
//            loan_form.put("age", String.valueOf(((loanController) loader.getController()).getAge().getValue()));
        if (((loanController) loader.getController()).getGender() != null && ((loanController) loader.getController()).getGender().getValue().length() > 0)
            loan_form.put("gender", ((loanController) loader.getController()).getGender().getValue());
        if (((loanController) loader.getController()).getOwn_car() != null && ((loanController) loader.getController()).getOwn_car().getValue().length() > 0)
            loan_form.put("own_car", ((loanController) loader.getController()).getOwn_car().getValue());
        if (((loanController) loader.getController()).getOwn_asset() != null && ((loanController) loader.getController()).getOwn_asset().getValue().length() > 0)
            loan_form.put("own_apartment", ((loanController) loader.getController()).getOwn_asset().getValue());
    }

    private void savePage2(){
        if (((loanController) loader.getController()).getEducation() != null && ((loanController) loader.getController()).getEducation().getValue().length() > 0)
            loan_form.put("education", ((loanController) loader.getController()).getEducation().getValue());
        if (((loanController) loader.getController()).getFamily() != null && ((loanController) loader.getController()).getFamily().getValue().length() > 0)
            loan_form.put("family", ((loanController) loader.getController()).getFamily().getValue());
        if (((loanController) loader.getController()).getHousing() != null && ((loanController) loader.getController()).getHousing().getValue().length() > 0)
            loan_form.put("housing", ((loanController) loader.getController()).getHousing().getValue());
        if (((loanController) loader.getController()).getRegion()!= null && ((loanController) loader.getController()).getRegion().getValue().length() > 0)
            loan_form.put("region", ((loanController) loader.getController()).getRegion().getValue());
        if (((loanController) loader.getController()).getOccupation() != null && ((loanController) loader.getController()).getOccupation().getValue().length() > 0)
            loan_form.put("occupation", ((loanController) loader.getController()).getOccupation().getValue());
        if (((loanController) loader.getController()).getOrganization() != null && ((loanController) loader.getController()).getOrganization().getValue().length() > 0)
            loan_form.put("organization", ((loanController) loader.getController()).getOrganization().getValue());
    }

    public void savePage3(){
        if (((loanController) loader.getController()).getWorkPhone() != null && ((loanController) loader.getController()).getWorkPhone().isSelected())
            loan_form.putBoolean("work_phone", ((loanController) loader.getController()).getWorkPhone().isSelected());
        if (((loanController) loader.getController()).getPrivatePhone() != null && ((loanController) loader.getController()).getPrivatePhone().isSelected())
            loan_form.putBoolean("private_phone", ((loanController) loader.getController()).getPrivatePhone().isSelected());
        if (((loanController) loader.getController()).getHousePhone() != null && ((loanController) loader.getController()).getHousePhone().isSelected())
            loan_form.putBoolean("house_phone", ((loanController) loader.getController()).getHousePhone().isSelected());
        if (((loanController) loader.getController()).getEmail() != null && ((loanController) loader.getController()).getEmail().isSelected())
            loan_form.putBoolean("email", ((loanController) loader.getController()).getEmail().isSelected());

    }

    private void reloadForm() {
        if (loan_form.get("full_name", UNDEFINED).compareTo("") != 0 && ((loanController) loader.getController()).getName() != null)
            ((loanController) loader.getController()).getName().setText(loan_form.get("full_name", UNDEFINED));
        if (loan_form.get("loan_amount", UNDEFINED).compareTo("") != 0 && ((loanController) loader.getController()).getAmount() != null)
            ((loanController) loader.getController()).getAmount().setText(loan_form.get("loan_amount", UNDEFINED));
        if (loan_form.get("monthly_income", UNDEFINED).compareTo("") != 0 && ((loanController) loader.getController()).getIncome() != null)
            ((loanController) loader.getController()).getIncome().setText(loan_form.get("monthly_income", UNDEFINED));
        if (loan_form.get("monthly_expenses", UNDEFINED).compareTo("") != 0 && ((loanController) loader.getController()).getExpenses() != null)
            ((loanController) loader.getController()).getExpenses().setText(loan_form.get("monthly_expenses", UNDEFINED));
        if (loan_form.get("country", UNDEFINED).compareTo("") != 0 && ((loanController) loader.getController()).getCountry() != null)
            ((loanController) loader.getController()).getCountry().getSelectionModel().select(loan_form.get("country", UNDEFINED));
        if (loan_form.get("gender", UNDEFINED).compareTo("") != 0 && ((loanController) loader.getController()).getGender() != null)
            ((loanController) loader.getController()).getGender().getSelectionModel().select(loan_form.get("gender", UNDEFINED));
        if (loan_form.get("own_car", UNDEFINED).compareTo("") != 0 && ((loanController) loader.getController()).getOwn_car() != null)
            ((loanController) loader.getController()).getOwn_car().getSelectionModel().select(loan_form.get("own_car", UNDEFINED));
        if (loan_form.get("own_apartment", UNDEFINED).compareTo("") != 0 && ((loanController) loader.getController()).getOwn_asset() != null)
            ((loanController) loader.getController()).getOwn_asset().getSelectionModel().select(loan_form.get("own_apartment", UNDEFINED));
        if (loan_form.get("education", UNDEFINED).compareTo("") != 0 && ((loanController) loader.getController()).getEducation() != null)
            ((loanController) loader.getController()).getEducation().getSelectionModel().select(loan_form.get("education", UNDEFINED));
        if (loan_form.get("family", UNDEFINED).compareTo("") != 0 && ((loanController) loader.getController()).getFamily() != null)
            ((loanController) loader.getController()).getFamily().getSelectionModel().select(loan_form.get("family", UNDEFINED));
        if (loan_form.get("housing", UNDEFINED).compareTo("") != 0 && ((loanController) loader.getController()).getHousing() != null)
            ((loanController) loader.getController()).getHousing().getSelectionModel().select(loan_form.get("housing", UNDEFINED));
        if (loan_form.get("region", UNDEFINED).compareTo("") != 0 && ((loanController) loader.getController()).getRegion() != null)
            ((loanController) loader.getController()).getRegion().getSelectionModel().select(loan_form.get("region", UNDEFINED));
        if (loan_form.get("occupation", UNDEFINED).compareTo("") != 0 && ((loanController) loader.getController()).getOccupation() != null)
            ((loanController) loader.getController()).getOccupation().getSelectionModel().select(loan_form.get("occupation", UNDEFINED));
        if (loan_form.get("organization", UNDEFINED).compareTo("") != 0 && ((loanController) loader.getController()).getOrganization() != null)
            ((loanController) loader.getController()).getOrganization().getSelectionModel().select(loan_form.get("organization", UNDEFINED));

        if (loan_form.getBoolean("work_phone", false) && ((loanController) loader.getController()).getWorkPhone() != null)
            ((loanController) loader.getController()).getWorkPhone().setSelected(true);
        if (loan_form.getBoolean("private_phone", false) && ((loanController) loader.getController()).getWorkPhone() != null)
            ((loanController) loader.getController()).getPrivatePhone().setSelected(true);
        if (loan_form.getBoolean("house_phone", false) && ((loanController) loader.getController()).getWorkPhone() != null)
            ((loanController) loader.getController()).getHousePhone().setSelected(true);
        if (loan_form.getBoolean("email", false) && ((loanController) loader.getController()).getWorkPhone() != null)
            ((loanController) loader.getController()).getEmail().setSelected(true);





    }


}


