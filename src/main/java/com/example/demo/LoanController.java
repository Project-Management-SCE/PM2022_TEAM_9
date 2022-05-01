package com.example.demo;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.WebView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class LoanController {
    private final ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female");
    private final ObservableList<String> regionList = FXCollections.observableArrayList("North", "Center", "South");
    private final ObservableList<String> familyList = FXCollections.observableArrayList("Civil Marriage", "Married", "Separated", "Single", "Widow", "Unknown");
    private final ObservableList<String> countryList = FXCollections.observableArrayList("Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Rep", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Congo (Democratic Rep)", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland {Republic}", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea North", "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar", "{Burma}", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russian Federation", "Rwanda", "St Kitts & Nevis", "St Lucia", "Saint Vincent & the Grenadines", "Samoa", "San Marino", "Sao Tome & Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe");
    private final ObservableList<String> educationList = FXCollections.observableArrayList("Academic Degree", "Higher Education", "Incomplete higher Education", "Lower Secondary Education", "Secondary");
    private final ObservableList<String> housingList = FXCollections.observableArrayList("Co-Op Apartment", "House or Apartment", "Municipal Apartment", "Office Apartment", "Rented Apartment", "With Parents");
    private final ObservableList<String> occupationList = FXCollections.observableArrayList("Unknown", "Accountants", "Cleaning", "Cooking", "core", "Drivers", "HR", "High Skill Tech", "IT", "Laborers", "Low Skill Laborers", "Managers", "Medicine", "Private Service", "Reality Agents", "Sales", "Secretaries", "Security", "Waiters & Barmen");
    private final ObservableList<String> organizationList = FXCollections.observableArrayList("Advertising", "Agriculture", "Bank", "Business", "Cleaning", "Construction", "Culture", "Electricity", "Emergency", "Managers", "Hotel", "Housing", "Industry", "Insurance", "Kindergarten", "Legal_services", "Medicine", "Military", "Mobile", "Police", "Postal", "Realtor", "Religion", "Restaurant", "School", "Security", "Security Ministries", "Self Employed", "Services", "Telecom", "Trade", "Transport", "University", "Xna", "Unknown");

    @FXML
    private DatePicker date_of_birth, days_employed;
    @FXML
    private ChoiceBox<String> country, gender, state, organization_type, occupation_type, living_type, education_level, family_status;
    @FXML
    private TextField own_car_age, loan_amount, property_value, total_income, family_members, work_phone, home_phone, mobile_phone, email, childrens_amount;
    @FXML
    private TextField full_name, address, city, zipcode;
    @FXML
    private CheckBox flag_own_car, flag_own_realty, work_phone_na, home_phone_na, mobile_phone_na, email_na;
    @FXML
    private Button nextBtn, backBtn, accept_offer_button, reject_offer_button, file_an_appeal_button, back_to_main_button;
    @FXML
    ToggleButton doc_btn_0, doc_btn_1, doc_btn_2, doc_btn_3, doc_btn_4, doc_btn_5, doc_btn_6, doc_btn_7, doc_btn_8, doc_btn_9, doc_btn_10, doc_btn_11, doc_btn_12, doc_btn_13, doc_btn_14, doc_btn_15, doc_btn_16, doc_btn_17, doc_btn_18, doc_btn_19;
    @FXML
    private WebView agreement;
    @FXML
    private Label loadingStatus, full_name_label, county_label, address_name_label, country_label, original_loan_label, approved_loan_label ;

    protected static int current_page = 0;


    /**
     * init first page buttons and text fields
     *
     * @param loanManager
     */
    public void initManager(LoanManager loanManager) {
        state.setItems(regionList);
        country.setItems(countryList); // load ComboBox list
        gender.setItems(genderList); // load ComboBox list
        nextBtn.setOnAction((event) -> loanManager.nextPage(++current_page));
        backBtn.setOnAction((event) -> loanManager.returnWelcomeScreen());

        // disable choice of future date
        date_of_birth.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(LocalDate.now()) > 0);
            }
        });

    }

    /**
     * init second page buttons and choice boxes
     *
     * @param loanManager
     */
    public void initManager2(LoanManager loanManager) {
        organization_type.setItems(organizationList);
        occupation_type.setItems(occupationList);
        living_type.setItems(housingList);
        own_car_age.setDisable(true);
        property_value.setDisable(true);
        nextBtn.setOnAction((event) -> loanManager.nextPage(++current_page));
        backBtn.setOnAction((event) -> loanManager.nextPage(--current_page));
        flag_own_car.setOnAction((event) -> inverseCheckBoxToTextField(own_car_age, flag_own_car));
        flag_own_realty.setOnAction((event) -> inverseCheckBoxToTextField(property_value, flag_own_realty));

        // disable choice of future date
        days_employed.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(LocalDate.now()) > 0);
            }
        });

    }


    /**
     * init third page buttons and check box
     */
    public void initManager3(LoanManager loanManager) {
        family_status.setItems(familyList); // load ComboBox list
        education_level.setItems(educationList); // load ComboBox list
        nextBtn.setOnAction((event) -> loanManager.nextPage(++current_page));
        backBtn.setOnAction((event) -> loanManager.nextPage(--current_page));
        home_phone_na.setOnAction((event) -> checkBoxToTextField(home_phone));
        work_phone_na.setOnAction((event) -> checkBoxToTextField(work_phone));
        mobile_phone_na.setOnAction((event) -> checkBoxToTextField(mobile_phone));
        email_na.setOnAction((event) -> checkBoxToTextField(email));
    }

    /**
     * init calculating page buttons
     */
    public void initManager4(LoanManager loanManager) {
        nextBtn.setOnAction((event) -> loanManager.nextPage(++current_page));
        backBtn.setOnAction((event) -> loanManager.nextPage(--current_page));
    }


    /**
     * init calculating page buttons
     */
    public void initManager5(LoanManager loanManager) {
        nextBtn.setOnAction((event) -> loanManager.nextPage(++current_page));
        backBtn.setOnAction((event) -> loanManager.nextPage(--current_page));
    }


    /**
     * init calculating page buttons
     */
    public void initManager6(LoanManager loanManager) {
        accept_offer_button.setOnAction((event) -> loanManager.continueRegistrationScreen());
        reject_offer_button.setOnAction((event) -> loanManager.returnWelcomeScreen());
    }

    /**
     * init calculating page buttons
     */
    public void initManager7(LoanManager loanManager) {
        file_an_appeal_button.setOnAction((event) -> loanManager.continueRegistrationScreen());
        back_to_main_button.setOnAction((event) -> loanManager.returnWelcomeScreen());
    }

    private void checkBoxToTextField(TextField tf) {
        tf.setDisable(!tf.isDisabled());
    }

    private void inverseCheckBoxToTextField(TextField tf, CheckBox cb) {
        tf.setDisable(!cb.isSelected());
    }

    public DatePicker dateOfBirth() {
        return date_of_birth;
    }

    public DatePicker daysEmployed() {
        return days_employed;
    }

    public ChoiceBox<String> Country() {
        return country;
    }

    public ChoiceBox<String> Gender() {
        return gender;
    }

    public ChoiceBox<String> State() {
        return state;
    }

    public ChoiceBox<String> organizationType() {
        return organization_type;
    }

    public ChoiceBox<String> occupationType() {
        return occupation_type;
    }

    public ChoiceBox<String> LivingType() {
        return living_type;
    }

    public TextField ownCarAge() {
        return own_car_age;
    }

    public TextField loanAmount() {
        return loan_amount;
    }

    public TextField propertyValue() {
        return property_value;
    }

    public TextField totalIncome() {
        return total_income;
    }

    public TextField fullName() {
        return full_name;
    }

    public TextField Address() {
        return address;
    }

    public TextField City() {
        return city;
    }

    public TextField Zipcode() {
        return zipcode;
    }

    public CheckBox ownCarFlag() {
        return flag_own_car;
    }

    public CheckBox ownRealtyFlag() {
        return flag_own_realty;
    }

    public ChoiceBox<String> educationLevel() {
        return education_level;
    }

    public TextField familyMembers() {
        return family_members;
    }

    public ChoiceBox<String> familyStatus() {
        return family_status;
    }

    public TextField workPhone() {
        return work_phone;
    }

    public TextField homePhone() {
        return home_phone;
    }

    public TextField mobilePhone() {
        return mobile_phone;
    }

    public TextField Email() {
        return email;
    }

    public TextField childrensAmount() {
        return childrens_amount;
    }

    public CheckBox workPhoneNA() {
        return work_phone_na;
    }

    public CheckBox homePhoneNA() {
        return home_phone_na;
    }

    public CheckBox mobilePhoneNA() {
        return mobile_phone_na;
    }

    public CheckBox EmailNA() {
        return email_na;
    }

    public ToggleButton docButton0() {
        return doc_btn_0;
    }

    public ToggleButton docButton1() {
        return doc_btn_1;
    }

    public ToggleButton docButton2() {
        return doc_btn_2;
    }

    public ToggleButton docButton3() {
        return doc_btn_3;
    }

    public ToggleButton docButton4() {
        return doc_btn_4;
    }

    public ToggleButton docButton5() {
        return doc_btn_5;
    }

    public ToggleButton docButton6() {
        return doc_btn_6;
    }

    public ToggleButton docButton7() {
        return doc_btn_7;
    }

    public ToggleButton docButton8() {
        return doc_btn_8;
    }

    public ToggleButton docButton9() {
        return doc_btn_9;
    }

    public ToggleButton docButton10() {
        return doc_btn_10;
    }

    public ToggleButton docButton11() {
        return doc_btn_11;
    }

    public ToggleButton docButton12() {
        return doc_btn_12;
    }

    public ToggleButton docButton13() {
        return doc_btn_13;
    }

    public ToggleButton docButton14() {
        return doc_btn_14;
    }

    public ToggleButton docButton15() {
        return doc_btn_15;
    }

    public ToggleButton docButton16() {
        return doc_btn_16;
    }

    public ToggleButton docButton17() {
        return doc_btn_17;
    }

    public ToggleButton docButton18() {
        return doc_btn_18;
    }

    public ToggleButton docButton19() {
        return doc_btn_19;
    }

    public WebView Agreement() {
        return agreement;
    }

    public Label loadingStatus() {
        return loadingStatus;
    }

    public Label getFull_name_label() {
        return full_name_label;
    }

    public Label getCounty_label() {
        return county_label;
    }

    public Label getAddress_name_label() {
        return address_name_label;
    }

    public Label getCountry_label() {
        return country_label;
    }

    public Label getOriginal_loan_label() {
        return original_loan_label;
    }

    public Label getApproved_loan_label() {
        return approved_loan_label;
    }

    protected static long dateToDays(DatePicker dp) {
        LocalDateTime live_time = LocalDateTime.now();
        LocalDate current_time = LocalDate.of(live_time.getYear(), live_time.getMonthValue(), live_time.getDayOfMonth());
        LocalDate old_time = LocalDate.of(dp.getValue().getYear(), dp.getValue().getMonthValue(), dp.getValue().getDayOfMonth());
        return ChronoUnit.DAYS.between(old_time, current_time);
    }

    protected static LocalDate daysToDate(int days) {
        LocalDateTime live_time = LocalDateTime.now();
        LocalDate current_time = LocalDate.of(live_time.getYear(), live_time.getMonthValue(), live_time.getDayOfMonth());
        return current_time.minusDays(days);
    }

}
