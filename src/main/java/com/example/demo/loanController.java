package com.example.demo;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class loanController {

    ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female");
    ObservableList<String> countryList = FXCollections.observableArrayList("Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Rep", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Congo (Democratic Rep)", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland {Republic}", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea North", "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar", "{Burma}", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russian Federation", "Rwanda", "St Kitts & Nevis", "St Lucia", "Saint Vincent & the Grenadines", "Samoa", "San Marino", "Sao Tome & Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe");
    ObservableList<String> ownCarList = FXCollections.observableArrayList("Yes", "No");
    ObservableList<String> ownAssetList = FXCollections.observableArrayList("Yes", "No");
    ObservableList<String> educationList = FXCollections.observableArrayList("Academic Degree", "Higher Education", "Incomplete higher Education", "Lower Secondery Education", "Secondery");
    ObservableList<String> familyList = FXCollections.observableArrayList("Civil Marriage", "Married", "Separated", "Single", "Widow", "Unknown");
    ObservableList<String> housingList = FXCollections.observableArrayList("Co-Op Apartment", "House or Apartment", "Municipal Apartment", "Office Apartment", "Rented Apartment", "With Parents");
    ObservableList<String> regionList = FXCollections.observableArrayList("NORTH", "MIDDLE", "SOUTH");
    ObservableList<String> occupationList = FXCollections.observableArrayList("UNKNOWN", "ACCOUNTANTS", "CLEANING_STAFF", "COOKING_STAFF", "CORE_STAFF",
            "DRIVERS", "HR_STAFF", "HIGH_SKILL_TECH_STAFF", "IT_STAFF", "LABORERS",
            "LOW_SKILL_LABORERS", "MANAGERS", "MEDICINE_STAFF", "PRIVATE_SERVICE_STAFF",
            "REALITY_AGENTS", "SALES_STAFF", "SECRETARIES", "SECURITY_STAFF", "WAITERS_BARMEN_STAFF"
    );
    ObservableList<String> organizationList = FXCollections.observableArrayList("ADVERTISING", "AGRICULTURE", "BANK", "BUSINESS", "CLEANING",
            "CONSTRUCTION", "CULTURE", "ELECTRICITY", "EMERGENCY", "MANAGERS",
            "HOTEL", "HOUSING", "INDUSTRY", "INSURANCE", "KINDERGARTEN", "LEGAL_SERVICES",
            "MEDICINE", "MILITARY", "MOBILE", "POLICE", "POSTAL", "REALTOR", "RELIGION",
            "RESTAURANT", "SCHOOL", "SECURITY", "SECURITY MINISTRIES", "SELF EMPLOYED",
            "SERVICES", "TELECOM", "TRADE", "TRANSPORT", "UNIVERSITY", "XNA", "UNKNOWN"
    );

    @FXML
    private Button clear, next1, next2, next3, back1, back2, back3, back4, submit;
    @FXML
    private DatePicker age;
    @FXML
    public ChoiceBox<String> country, own_car, gender, own_asset, education, family, housing, occupation, region, organization;
    @FXML
    private TextField name, amount, income, expenses;
    @FXML
    private CheckBox workPhone, privatePhone, housePhone, email;


    private final int pageIndex = 1;

    /**
     * init first page buttons and text fields
     *
     * @param loanManager
     */
    public void initManager(loanManager loanManager) {
        // set back button
        back1.setOnAction(actionEvent -> loanManager.goBack());
        // clear function for clearing written inputs
        clear.setOnAction(actionEvent -> {
            name.clear();
            amount.clear();
            income.clear();
            expenses.clear();
        });
        country.setItems(countryList);
        gender.setItems(genderList);// set gender choice box
        own_car.setItems(ownCarList);// set own car choice box
        own_asset.setItems(ownAssetList);
        next1.setOnAction(actionEvent -> loanManager.nextPage(pageIndex));


    }

    /**
     * init second page buttons and choice boxes
     *
     * @param loanManager
     */
    public void initManager2(loanManager loanManager) {
        next2.setOnAction(actionEvent -> loanManager.nextPage(pageIndex + 1));
        back2.setOnAction(actionEvent -> loanManager.showLoanScreen());
        education.setItems(educationList);
        family.setItems(familyList);
        housing.setItems(housingList);
        occupation.setItems(occupationList);
        region.setItems(regionList);
        organization.setItems(organizationList);


    }

    /**
     * init third page buttons and check box
     */
    public void initManager3(loanManager loanManager) {
        back3.setOnAction(actionEvent -> loanManager.nextPage(pageIndex));
        submit.setOnAction(actionEvent -> loanManager.nextPage(pageIndex + 2));
    }

    /**
     * init calculating page buttons
     */
    public void initManager4(loanManager loanManager) {
        back4.setOnAction(actionEvent -> loanManager.nextPage(pageIndex+1));
    }

    public DatePicker getAge() {
        return age;
    }

    public ChoiceBox<String> getCountry() {
        return country;
    }

    public ChoiceBox<String> getOwn_car() {
        return own_car;
    }

    public ChoiceBox<String> getGender() {
        return gender;
    }

    public ChoiceBox<String> getOwn_asset() {
        return own_asset;
    }

    public ChoiceBox<String> getEducation() {
        return education;
    }

    public ChoiceBox<String> getFamily() {
        return family;
    }

    public ChoiceBox<String> getHousing() {
        return housing;
    }

    public ChoiceBox<String> getOccupation() {
        return occupation;
    }

    public ChoiceBox<String> getRegion() {
        return region;
    }

    public ChoiceBox<String> getOrganization() {
        return organization;
    }

    public TextField getName() {
        return name;
    }

    public TextField getAmount() {
        return amount;
    }

    public TextField getIncome() {
        return income;
    }

    public TextField getExpenses() {
        return expenses;
    }

    public CheckBox getWorkPhone() {
        return workPhone;
    }

    public CheckBox getPrivatePhone() {
        return privatePhone;
    }

    public CheckBox getHousePhone() {
        return housePhone;
    }

    public CheckBox getEmail() {
        return email;
    }

}
