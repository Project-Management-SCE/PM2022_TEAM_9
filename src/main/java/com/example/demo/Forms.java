package com.example.demo;

import core.ann.classifier.Matrix;

import java.util.prefs.Preferences;


enum GENDER {
    MALE(2), FEMALE(1);
    private final int value;

    GENDER(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

//
enum FLAG_OWN_CAR {
    NO(1), YES(2);
    private final int value;

    FLAG_OWN_CAR(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

////
enum FLAG_OWN_REALTY {
    NO(1), YES(2);
    private final int value;

    FLAG_OWN_REALTY(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum NAME_EDUCATION_TYPE {
    ACADEMIC_DEGREE(1), HIGHER_EDUCATION(2), INCOMPLETE_HIGHER(3), LOWER_SECONDARY(4), SECONDARY(5);
    private final int value;

    NAME_EDUCATION_TYPE(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

//
enum NAME_FAMILY_STATUS {
    CIVIL_MARRIAGE(1), MARRIED(2), SEPARATED(3), SINGLE(4), Unknown(5), WIDOW(6);
    private final int value;

    NAME_FAMILY_STATUS(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum NAME_HOUSING_TYPE {
    CO_OP_APARTMENT(1), HOUSE_OR_APARTMENT(2), MUNICIPAL_APARTMENT(3), OFFICE_APARTMENT(4), RENTED_APARTMENT(5), WITH_PARENTS(6);
    private final int value;

    NAME_HOUSING_TYPE(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_MOBIL {
    NO(1), YES(2);
    private final int value;

    FLAG_MOBIL(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_EMP_PHONE {
    NO(1), YES(2);
    private final int value;

    FLAG_EMP_PHONE(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_WORK_PHONE {
    NO(1), YES(2);
    private final int value;

    FLAG_WORK_PHONE(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_PHONE {
    NO(1), YES(2);
    private final int value;

    FLAG_PHONE(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_EMAIL {
    NO(1), YES(2);
    private final int value;

    FLAG_EMAIL(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum OCCUPATION_TYPE {
    UNKNOWN(1), ACCOUNTANTS(2), CLEANING_STAFF(3), COOKING_STAFF(4), CORE_STAFF(5),
    DRIVERS(6), HR_STAFF(7), HIGH_SKILL_TECH_STAFF(8), IT_STAFF(9), LABORERS(10),
    LOW_SKILL_LABORERS(11), MANAGERS(12), MEDICINE_STAFF(13), PRIVATE_SERVICE_STAFF(14),
    REALITY_AGENTS(15), SALES_STAFF(16), SECRETARIES(17), SECURITY_STAFF(18), WAITERS_BARMEN_STAFF(19);
    private final int value;

    OCCUPATION_TYPE(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum REGION_RATING_CLIENT {
    NORTH(1), MIDDLE(2), SOUTH(3);
    private final int value;

    REGION_RATING_CLIENT(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum ORGANIZATION_TYPE {
    ADVERTISING(1), AGRICULTURE(2), BANK(3), BUSINESS(4), CLEANING(7),
    CONSTRUCTION(8), CULTURE(9), ELECTRICITY(10), EMERGENCY(11), MANAGERS(12),
    HOTEL(13), HOUSING(14), INDUSTRY(15), INSURANCE(28), KINDERGARTEN(29),
    LEGAL_SERVICES(30), MEDICINE(31), MILITARY(32), MOBILE(33), UNKNOWN(34),
    POLICE(35), POSTAL(36), REALTOR(37), RELIGION(38), RESTAURANT(39),
    SCHOOL(40), SECURITY(41), SECURITY_MINISTRIES(42), SELF_EMPLOYED(43),
    SERVICES(44), TELECOM(45), TRADE(46), TRANSPORT(53), UNIVERSITY(57), XNA(58);
    private final int value;

    ORGANIZATION_TYPE(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}


enum FLAG_DOCUMENT_2 {
    NO(1), YES(2);
    private final int value;

    FLAG_DOCUMENT_2(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_DOCUMENT_3 {
    NO(1), YES(2);
    private final int value;

    FLAG_DOCUMENT_3(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_DOCUMENT_4 {
    NO(1), YES(2);
    private final int value;

    FLAG_DOCUMENT_4(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_DOCUMENT_5 {
    NO(1), YES(2);
    private final int value;

    FLAG_DOCUMENT_5(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_DOCUMENT_6 {
    NO(1), YES(2);
    private final int value;

    FLAG_DOCUMENT_6(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_DOCUMENT_7 {
    NO(1), YES(2);
    private final int value;

    FLAG_DOCUMENT_7(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_DOCUMENT_8 {
    NO(1), YES(2);
    private final int value;

    FLAG_DOCUMENT_8(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_DOCUMENT_9 {
    NO(1), YES(2);
    private final int value;

    FLAG_DOCUMENT_9(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_DOCUMENT_10 {
    NO(1), YES(2);
    private final int value;

    FLAG_DOCUMENT_10(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_DOCUMENT_11 {
    NO(1), YES(2);
    private final int value;

    FLAG_DOCUMENT_11(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_DOCUMENT_12 {
    NO(1), YES(2);
    private final int value;

    FLAG_DOCUMENT_12(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_DOCUMENT_13 {
    NO(1), YES(2);
    private final int value;

    FLAG_DOCUMENT_13(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_DOCUMENT_14 {
    NO(1), YES(2);
    private final int value;

    FLAG_DOCUMENT_14(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_DOCUMENT_15 {
    NO(1), YES(2);
    private final int value;

    FLAG_DOCUMENT_15(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_DOCUMENT_16 {
    NO(1), YES(2);
    private final int value;

    FLAG_DOCUMENT_16(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_DOCUMENT_17 {
    NO(1), YES(2);
    private final int value;

    FLAG_DOCUMENT_17(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_DOCUMENT_18 {
    NO(1), YES(2);
    private final int value;

    FLAG_DOCUMENT_18(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_DOCUMENT_19 {
    NO(1), YES(2);
    private final int value;

    FLAG_DOCUMENT_19(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_DOCUMENT_20 {
    NO(1), YES(2);
    private final int value;

    FLAG_DOCUMENT_20(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

enum FLAG_DOCUMENT_21 {
    NO(1), YES(2);
    private final int value;

    FLAG_DOCUMENT_21(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int value() {
        return value;
    }
}

// Driver code
class FormAdapter {
    private final static int ATTRIBUTES = 43;
    private final static int INVALID_INT = -999;
    private final static String INVALID_STR = "-999";
    private final static int ROWS = 1;
    private final Preferences data;

    FormAdapter(Preferences data) {
        this.data = data;
    }

    protected Matrix preferencesConverter() throws core.ann.classifier.MatrixExceptionHandler {
        Matrix ann_data = new Matrix(ROWS, ATTRIBUTES);
        ann_data.setValue(0, 0, Gender());
        ann_data.setValue(0, 1, flagOwnCar());
        ann_data.setValue(0, 2, flagOwnRealty());
        ann_data.setValue(0, 3, data.getInt("childrens_amount", INVALID_INT));
        ann_data.setValue(0, 4, data.getInt("total_income", INVALID_INT));
        ann_data.setValue(0, 5, data.getInt("loan_amount", INVALID_INT));
        ann_data.setValue(0, 6, data.getInt("property_value", INVALID_INT));
        ann_data.setValue(0, 7, nameEducation());
        ann_data.setValue(0, 8, nameFamilyStatus());
        ann_data.setValue(0, 9, nameHousingType());
        ann_data.setValue(0, 10, regionPopulationRelative());
        ann_data.setValue(0, 11, data.getInt("dob_days", INVALID_INT));
        ann_data.setValue(0, 12, data.getInt("days_employed", INVALID_INT));
        ann_data.setValue(0, 13, data.getInt("own_car_age", INVALID_INT));
        ann_data.setValue(0, 14, flagMobilePhone());
        ann_data.setValue(0, 15, flagEmployeePhone());
        ann_data.setValue(0, 16, flagWorkPhone());
        ann_data.setValue(0, 17, flagPrivatePhone());
        ann_data.setValue(0, 18, flagEmail());
        ann_data.setValue(0, 19, OccupationType());
        ann_data.setValue(0, 20, data.getInt("family_members", INVALID_INT));
        ann_data.setValue(0, 21, regionRatingClient());
        ann_data.setValue(0, 22, organizationType());
        ann_data.setValue(0, 23, flagDocument1());
        ann_data.setValue(0, 24, flagDocument2());
        ann_data.setValue(0, 25, flagDocument3());
        ann_data.setValue(0, 26, flagDocument4());
        ann_data.setValue(0, 27, flagDocument5());
        ann_data.setValue(0, 28, flagDocument6());
        ann_data.setValue(0, 29, flagDocument7());
        ann_data.setValue(0, 30, flagDocument8());
        ann_data.setValue(0, 31, flagDocument9());
        ann_data.setValue(0, 32, flagDocument10());
        ann_data.setValue(0, 33, flagDocument11());
        ann_data.setValue(0, 34, flagDocument12());
        ann_data.setValue(0, 35, flagDocument13());
        ann_data.setValue(0, 36, flagDocument14());
        ann_data.setValue(0, 37, flagDocument15());
        ann_data.setValue(0, 38, flagDocument16());
        ann_data.setValue(0, 39, flagDocument17());
        ann_data.setValue(0, 40, flagDocument18());
        ann_data.setValue(0, 41, flagDocument19());
        ann_data.setValue(0, 42, flagDocument20());

        return ann_data;
    }

    private int regionRatingClient() {
        if (data.get("state", null).compareTo("North") == 0)
            return REGION_RATING_CLIENT.NORTH.value();

        if (data.get("state", null).compareTo("Middle") == 0)
            return REGION_RATING_CLIENT.NORTH.value();

        if (data.get("state", null).compareTo("South") == 0)
            return REGION_RATING_CLIENT.NORTH.value();

        return -1;
    }

    private int organizationType() {
        if (data.get("organization_type", null).compareTo("Advertising") == 0)
            return ORGANIZATION_TYPE.ADVERTISING.value();

        if (data.get("organization_type", null).compareTo("Agriculture") == 0)
            return ORGANIZATION_TYPE.AGRICULTURE.value();

        if (data.get("organization_type", null).compareTo("Bank") == 0)
            return ORGANIZATION_TYPE.BANK.value();

        if (data.get("organization_type", null).compareTo("Business") == 0)
            return ORGANIZATION_TYPE.BUSINESS.value();

        if (data.get("organization_type", null).compareTo("Cleaning") == 0)
            return ORGANIZATION_TYPE.CLEANING.value();

        if (data.get("organization_type", null).compareTo("Construction") == 0)
            return ORGANIZATION_TYPE.CONSTRUCTION.value();

        if (data.get("organization_type", null).compareTo("Culture") == 0)
            return ORGANIZATION_TYPE.CULTURE.value();

        if (data.get("organization_type", null).compareTo("Electricity") == 0)
            return ORGANIZATION_TYPE.ELECTRICITY.value();

        if (data.get("organization_type", null).compareTo("Emergency") == 0)
            return ORGANIZATION_TYPE.EMERGENCY.value();

        if (data.get("organization_type", null).compareTo("Managers") == 0)
            return ORGANIZATION_TYPE.MANAGERS.value();

        if (data.get("organization_type", null).compareTo("Hotel") == 0)
            return ORGANIZATION_TYPE.HOTEL.value();

        if (data.get("organization_type", null).compareTo("Housing") == 0)
            return ORGANIZATION_TYPE.HOUSING.value();

        if (data.get("organization_type", null).compareTo("Industry") == 0)
            return ORGANIZATION_TYPE.INDUSTRY.value();

        if (data.get("organization_type", null).compareTo("Insurance") == 0)
            return ORGANIZATION_TYPE.INDUSTRY.value();

        if (data.get("organization_type", null).compareTo("Kindergarten") == 0)
            return ORGANIZATION_TYPE.KINDERGARTEN.value();

        if (data.get("organization_type", null).compareTo("Legal Services") == 0)
            return ORGANIZATION_TYPE.LEGAL_SERVICES.value();

        if (data.get("organization_type", null).compareTo("Medicine") == 0)
            return ORGANIZATION_TYPE.MEDICINE.value();

        if (data.get("organization_type", null).compareTo("Military") == 0)
            return ORGANIZATION_TYPE.MILITARY.value();

        if (data.get("organization_type", null).compareTo("Mobile") == 0)
            return ORGANIZATION_TYPE.MOBILE.value();

        if (data.get("organization_type", null).compareTo("Police") == 0)
            return ORGANIZATION_TYPE.POLICE.value();

        if (data.get("organization_type", null).compareTo("Postal") == 0)
            return ORGANIZATION_TYPE.POSTAL.value();

        if (data.get("organization_type", null).compareTo("Realtor") == 0)
            return ORGANIZATION_TYPE.REALTOR.value();

        if (data.get("organization_type", null).compareTo("Religion") == 0)
            return ORGANIZATION_TYPE.RELIGION.value();

        if (data.get("organization_type", null).compareTo("Restaurant") == 0)
            return ORGANIZATION_TYPE.RESTAURANT.value();

        if (data.get("organization_type", null).compareTo("School") == 0)
            return ORGANIZATION_TYPE.SCHOOL.value();

        if (data.get("organization_type", null).compareTo("Security") == 0)
            return ORGANIZATION_TYPE.SECURITY.value();

        if (data.get("organization_type", null).compareTo("Security Ministries") == 0)
            return ORGANIZATION_TYPE.SECURITY_MINISTRIES.value();

        if (data.get("organization_type", null).compareTo("Self Employed") == 0)
            return ORGANIZATION_TYPE.SELF_EMPLOYED.value();

        if (data.get("organization_type", null).compareTo("Services") == 0)
            return ORGANIZATION_TYPE.SERVICES.value();

        if (data.get("organization_type", null).compareTo("Telecom") == 0)
            return ORGANIZATION_TYPE.TELECOM.value();

        if (data.get("organization_type", null).compareTo("Trade") == 0)
            return ORGANIZATION_TYPE.TRADE.value();

        if (data.get("organization_type", null).compareTo("Transport") == 0)
            return ORGANIZATION_TYPE.TRANSPORT.value();

        if (data.get("organization_type", null).compareTo("University") == 0)
            return ORGANIZATION_TYPE.UNIVERSITY.value();

        if (data.get("organization_type", null).compareTo("Xna") == 0)
            return ORGANIZATION_TYPE.XNA.value();

        if (data.get("organization_type", null).compareTo("Unknown") == 0)
            return ORGANIZATION_TYPE.UNKNOWN.value();

        return -1;
    }

    public int OccupationType() {
        if (data.get("occupation_type", null).compareTo("Unknown") == 0)
            return OCCUPATION_TYPE.UNKNOWN.value();

        if (data.get("occupation_type", null).compareTo("Accountants") == 0)
            return OCCUPATION_TYPE.ACCOUNTANTS.value();

        if (data.get("occupation_type", null).compareTo("Cooking") == 0)
            return OCCUPATION_TYPE.COOKING_STAFF.value();

        if (data.get("occupation_type", null).compareTo("core") == 0)
            return OCCUPATION_TYPE.CORE_STAFF.value();

        if (data.get("occupation_type", null).compareTo("HR") == 0)
            return OCCUPATION_TYPE.HR_STAFF.value();

        if (data.get("occupation_type", null).compareTo("High Skill Tech") == 0)
            return OCCUPATION_TYPE.HIGH_SKILL_TECH_STAFF.value();

        if (data.get("occupation_type", null).compareTo("IT") == 0)
            return OCCUPATION_TYPE.IT_STAFF.value();

        if (data.get("occupation_type", null).compareTo("Laborers") == 0)
            return OCCUPATION_TYPE.LABORERS.value();

        if (data.get("occupation_type", null).compareTo("Low Skill Laborers") == 0)
            return OCCUPATION_TYPE.LOW_SKILL_LABORERS.value();

        if (data.get("occupation_type", null).compareTo("Managers") == 0)
            return OCCUPATION_TYPE.MANAGERS.value();

        if (data.get("occupation_type", null).compareTo("Medicine") == 0)
            return OCCUPATION_TYPE.MEDICINE_STAFF.value();

        if (data.get("occupation_type", null).compareTo("Private Service") == 0)
            return OCCUPATION_TYPE.PRIVATE_SERVICE_STAFF.value();

        if (data.get("occupation_type", null).compareTo("Reality Agents") == 0)
            return OCCUPATION_TYPE.REALITY_AGENTS.value();

        if (data.get("occupation_type", null).compareTo("Sales") == 0)
            return OCCUPATION_TYPE.SALES_STAFF.value();

        if (data.get("occupation_type", null).compareTo("Secretaries") == 0)
            return OCCUPATION_TYPE.SECRETARIES.value();

        if (data.get("occupation_type", null).compareTo("Security") == 0)
            return OCCUPATION_TYPE.SECURITY_STAFF.value();

        if (data.get("occupation_type", null).compareTo("Waiters & Barmen") == 0)
            return OCCUPATION_TYPE.WAITERS_BARMEN_STAFF.value();

        return -1;
    }

    private int nameHousingType() {
        if (data.get("living_type", null).compareTo("Co-Op Apartment") == 0)
            return NAME_HOUSING_TYPE.CO_OP_APARTMENT.value();

        if (data.get("living_type", null).compareTo("House or Apartment") == 0)
            return NAME_HOUSING_TYPE.HOUSE_OR_APARTMENT.value();

        if (data.get("living_type", null).compareTo("Municipal Apartment") == 0)
            return NAME_HOUSING_TYPE.MUNICIPAL_APARTMENT.value();

        if (data.get("living_type", null).compareTo("Office Apartment") == 0)
            return NAME_HOUSING_TYPE.OFFICE_APARTMENT.value();

        if (data.get("living_type", null).compareTo("Rented Apartment") == 0)
            return NAME_HOUSING_TYPE.RENTED_APARTMENT.value();

        if (data.get("living_type", null).compareTo("With Parents") == 0)
            return NAME_HOUSING_TYPE.WITH_PARENTS.value();

        return -1;
    }

    private double regionPopulationRelative(){
        if ((data.get("state", null).compareTo("North") == 0))
            return 0.03;
        if ((data.get("state", null).compareTo("Center") == 0))
            return 0.07;
        else
            return 0.03;
    }

    private int nameFamilyStatus() {
        if (data.get("family_status", null).compareTo("Civil Marriage") == 0)
            return NAME_FAMILY_STATUS.CIVIL_MARRIAGE.value();

        if (data.get("family_status", null).compareTo("Married") == 0)
            return NAME_FAMILY_STATUS.MARRIED.value();

        if (data.get("family_status", null).compareTo("Separated") == 0)
            return NAME_FAMILY_STATUS.SEPARATED.value();

        if (data.get("family_status", null).compareTo("Single") == 0)
            return NAME_FAMILY_STATUS.SINGLE.value();

        if (data.get("family_status", null).compareTo("Widow") == 0)
            return NAME_FAMILY_STATUS.WIDOW.value();

        if (data.get("family_status", null).compareTo("Unknown") == 0)
            return NAME_FAMILY_STATUS.Unknown.value();

        return -1;
    }

    private int nameEducation() {
        if (data.get("education_level", null).compareTo("Academic Degree") == 0)
            return NAME_EDUCATION_TYPE.ACADEMIC_DEGREE.value();

        if (data.get("education_level", null).compareTo("Higher Education") == 0)
            return NAME_EDUCATION_TYPE.HIGHER_EDUCATION.value();

        if (data.get("education_level", null).compareTo("Incomplete Higher Education") == 0)
            return NAME_EDUCATION_TYPE.INCOMPLETE_HIGHER.value();

        if (data.get("education_level", null).compareTo("Lower Secondary Education") == 0)
            return NAME_EDUCATION_TYPE.LOWER_SECONDARY.value();

        if (data.get("education_level", null).compareTo("Secondary") == 0)
            return NAME_EDUCATION_TYPE.SECONDARY.value();

        return -1;
    }

    private int Gender() {
        if (data.get("gender", null).compareTo("Male") == 0)
            return GENDER.MALE.value();

        if (data.get("gender", null).compareTo("Female") == 0)
            return GENDER.FEMALE.value();

        return -1;
    }


    private int flagPrivatePhone() {
        return flagMobilePhone();
    }

    private int flagOwnRealty() {
        if (data.getBoolean("own_realty_flag", false))
            return FLAG_OWN_REALTY.YES.value();

        if (!data.getBoolean("own_realty_flag", false))
            return FLAG_OWN_REALTY.NO.value();

        return -1;
    }

    private int flagOwnCar() {
        if (data.getBoolean("own_car_flag", false))
            return FLAG_OWN_CAR.YES.value();

        if (!data.getBoolean("own_car_flag", false))
            return FLAG_OWN_CAR.NO.value();

        return -1;
    }

    private int flagMobilePhone() {
        if (data.getBoolean("mobile_phone_flag", false))
            return FLAG_MOBIL.YES.value();

        if (!data.getBoolean("mobile_phone_flag", false))
            return FLAG_MOBIL.NO.value();

        return -1;
    }

    private int flagWorkPhone() {
        if (data.getBoolean("work_phone_flag", false))
            return FLAG_EMP_PHONE.YES.value();

        if (!data.getBoolean("work_phone_flag", false))
            return FLAG_EMP_PHONE.NO.value();

        return -1;
    }

    private int flagEmployeePhone() {
        return flagWorkPhone();
    }

    private int flagEmail() {
        if (data.getBoolean("email_flag", false))
            return FLAG_EMAIL.YES.value();

        if (!data.getBoolean("email_flag", false))
            return FLAG_EMAIL.NO.value();

        return -1;
    }

    private int flagDocument1() {
        if (data.getBoolean("doc_2_flag", false))
            return FLAG_DOCUMENT_2.YES.value();

        if (!data.getBoolean("doc_2_flag", false))
            return FLAG_DOCUMENT_2.NO.value();

        return -1;
    }

    private int flagDocument2() {
        if (data.getBoolean("doc_3_flag", false))
            return FLAG_DOCUMENT_3.YES.value();

        if (!data.getBoolean("doc_3_flag", false))
            return FLAG_DOCUMENT_3.NO.value();

        return -1;
    }

    private int flagDocument3() {
        if (data.getBoolean("doc_4_flag", false))
            return FLAG_DOCUMENT_4.YES.value();

        if (!data.getBoolean("doc_4_flag", false))
            return FLAG_DOCUMENT_4.NO.value();

        return -1;
    }

    private int flagDocument4() {
        if (data.getBoolean("doc_5_flag", false))
            return FLAG_DOCUMENT_5.YES.value();

        if (!data.getBoolean("doc_5_flag", false))
            return FLAG_DOCUMENT_5.NO.value();

        return -1;
    }

    private int flagDocument5() {
        if (data.getBoolean("doc_6_flag", false))
            return FLAG_DOCUMENT_6.YES.value();

        if (!data.getBoolean("doc_6_flag", false))
            return FLAG_DOCUMENT_6.NO.value();

        return -1;
    }

    private int flagDocument6() {
        if (data.getBoolean("doc_7_flag", false))
            return FLAG_DOCUMENT_7.YES.value();

        if (!data.getBoolean("doc_7_flag", false))
            return FLAG_DOCUMENT_7.NO.value();

        return -1;
    }

    private int flagDocument7() {
        if (data.getBoolean("doc_8_flag", false))
            return FLAG_DOCUMENT_8.YES.value();

        if (!data.getBoolean("doc_8_flag", false))
            return FLAG_DOCUMENT_8.NO.value();

        return -1;
    }

    private int flagDocument8() {
        if (data.getBoolean("doc_9_flag", false))
            return FLAG_DOCUMENT_9.YES.value();

        if (!data.getBoolean("doc_9_flag", false))
            return FLAG_DOCUMENT_9.NO.value();

        return -1;
    }

    private int flagDocument9() {
        if (data.getBoolean("doc_10_flag", false))
            return FLAG_DOCUMENT_10.YES.value();

        if (!data.getBoolean("doc_10_flag", false))
            return FLAG_DOCUMENT_10.NO.value();

        return -1;
    }

    private int flagDocument10() {
        if (data.getBoolean("doc_11_flag", false))
            return FLAG_DOCUMENT_11.YES.value();

        if (!data.getBoolean("doc_11_flag", false))
            return FLAG_DOCUMENT_11.NO.value();

        return -1;
    }

    private int flagDocument11() {
        if (data.getBoolean("doc_12_flag", false))
            return FLAG_DOCUMENT_12.YES.value();

        if (!data.getBoolean("doc_12_flag", false))
            return FLAG_DOCUMENT_12.NO.value();

        return -1;
    }

    private int flagDocument12() {
        if (data.getBoolean("doc_13_flag", false))
            return FLAG_DOCUMENT_13.YES.value();

        if (!data.getBoolean("doc_13_flag", false))
            return FLAG_DOCUMENT_13.NO.value();

        return -1;
    }

    private int flagDocument13() {
        if (data.getBoolean("doc_14_flag", false))
            return FLAG_DOCUMENT_14.YES.value();

        if (!data.getBoolean("doc_14_flag", false))
            return FLAG_DOCUMENT_14.NO.value();

        return -1;
    }

    private int flagDocument14() {
        if (data.getBoolean("doc_15_flag", false))
            return FLAG_DOCUMENT_15.YES.value();

        if (!data.getBoolean("doc_15_flag", false))
            return FLAG_DOCUMENT_15.NO.value();

        return -1;
    }

    private int flagDocument15() {
        if (data.getBoolean("doc_16_flag", false))
            return FLAG_DOCUMENT_16.YES.value();

        if (!data.getBoolean("doc_16_flag", false))
            return FLAG_DOCUMENT_16.NO.value();

        return -1;
    }

    private int flagDocument16() {
        if (data.getBoolean("doc_17_flag", false))
            return FLAG_DOCUMENT_17.YES.value();

        if (!data.getBoolean("doc_17_flag", false))
            return FLAG_DOCUMENT_17.NO.value();

        return -1;
    }

    private int flagDocument17() {
        if (data.getBoolean("doc_18_flag", false))
            return FLAG_DOCUMENT_18.YES.value();

        if (!data.getBoolean("doc_18_flag", false))
            return FLAG_DOCUMENT_18.NO.value();

        return -1;
    }

    private int flagDocument18() {
        if (data.getBoolean("doc_19_flag", false))
            return FLAG_DOCUMENT_19.YES.value();

        if (!data.getBoolean("doc_19_flag", false))
            return FLAG_DOCUMENT_19.NO.value();

        return -1;
    }

    private int flagDocument19() {
        if (data.getBoolean("doc_20_flag", false))
            return FLAG_DOCUMENT_20.YES.value();

        if (!data.getBoolean("doc_20_flag", false))
            return FLAG_DOCUMENT_20.NO.value();

        return -1;
    }

    private int flagDocument20() {
        if (data.getBoolean("doc_21_flag", false))
            return FLAG_DOCUMENT_21.YES.value();

        if (!data.getBoolean("doc_21_flag", false))
            return FLAG_DOCUMENT_21.NO.value();

        return -1;
    }

    public final static String AGREEMENT = """
            <h1>Terms and Conditions</h1>
            <p>Last updated: April 12, 2022</p>
            <p>Please read these terms and conditions carefully before using Our Service.</p>
            <h1>Interpretation and Definitions</h1>
            <h2>Interpretation</h2>
            <p>The words of which the initial letter is capitalized have meanings defined under the following conditions. The following definitions shall have the same meaning regardless of whether they appear in singular or in plural.</p>
            <h2>Definitions</h2>
            <p>For the purposes of these Terms and Conditions:</p>
            <ul>
            <li>
            <p><strong>Application</strong> means the software program provided by the Company downloaded by You on any electronic device, named Loans</p>
            </li>
            <li>
            <p><strong>Application Store</strong> means the digital distribution service operated and developed by Apple Inc. (Apple App Store) or Google Inc. (Google Play Store) in which the Application has been downloaded.</p>
            </li>
            <li>
            <p><strong>Affiliate</strong> means an entity that controls, is controlled by or is under common control with a party, where &quot;control&quot; means ownership of 50% or more of the shares, equity interest or other securities entitled to vote for election of directors or other managing authority.</p>
            </li>
            <li>
            <p><strong>Country</strong> refers to:  Israel</p>
            </li>
            <li>
            <p><strong>Company</strong> (referred to as either &quot;the Company&quot;, &quot;We&quot;, &quot;Us&quot; or &quot;Our&quot; in this Agreement) refers to Loans LLC, Haim Nachman Bialik St 56, Be'er Sheva, 84100.</p>
            </li>
            <li>
            <p><strong>Device</strong> means any device that can access the Service such as a computer, a cellphone or a digital tablet.</p>
            </li>
            <li>
            <p><strong>Service</strong> refers to the Application.</p>
            </li>
            <li>
            <p><strong>Terms and Conditions</strong> (also referred as &quot;Terms&quot;) mean these Terms and Conditions that form the entire agreement between You and the Company regarding the use of the Service. This Terms and Conditions agreement has been created with the help of the <a href="https://www.termsfeed.com/terms-conditions-generator/" target="_blank">Terms and Conditions Generator</a>.</p>
            </li>
            <li>
            <p><strong>Third-party Social Media Service</strong> means any services or content (including data, information, products or services) provided by a third-party that may be displayed, included or made available by the Service.</p>
            </li>
            <li>
            <p><strong>You</strong> means the individual accessing or using the Service, or the company, or other legal entity on behalf of which such individual is accessing or using the Service, as applicable.</p>
            </li>
            </ul>
            <h1>Acknowledgment</h1>
            <p>These are the Terms and Conditions governing the use of this Service and the agreement that operates between You and the Company. These Terms and Conditions set out the rights and obligations of all users regarding the use of the Service.</p>
            <p>Your access to and use of the Service is conditioned on Your acceptance of and compliance with these Terms and Conditions. These Terms and Conditions apply to all visitors, users and others who access or use the Service.</p>
            <p>By accessing or using the Service You agree to be bound by these Terms and Conditions. If You disagree with any part of these Terms and Conditions then You may not access the Service.</p>
            <p>You represent that you are over the age of 18. The Company does not permit those under 18 to use the Service.</p>
            <p>Your access to and use of the Service is also conditioned on Your acceptance of and compliance with the Privacy Policy of the Company. Our Privacy Policy describes Our policies and procedures on the collection, use and disclosure of Your personal information when You use the Application or the Website and tells You about Your privacy rights and how the law protects You. Please read Our Privacy Policy carefully before using Our Service.</p>
            <h1>Links to Other Websites</h1>
            <p>Our Service may contain links to third-party web sites or services that are not owned or controlled by the Company.</p>
            <p>The Company has no control over, and assumes no responsibility for, the content, privacy policies, or practices of any third party web sites or services. You further acknowledge and agree that the Company shall not be responsible or liable, directly or indirectly, for any damage or loss caused or alleged to be caused by or in connection with the use of or reliance on any such content, goods or services available on or through any such web sites or services.</p>
            <p>We strongly advise You to read the terms and conditions and privacy policies of any third-party web sites or services that You visit.</p>
            <h1>Termination</h1>
            <p>We may terminate or suspend Your access immediately, without prior notice or liability, for any reason whatsoever, including without limitation if You breach these Terms and Conditions.</p>
            <p>Upon termination, Your right to use the Service will cease immediately.</p>
            <h1>Limitation of Liability</h1>
            <p>Notwithstanding any damages that You might incur, the entire liability of the Company and any of its suppliers under any provision of this Terms and Your exclusive remedy for all of the foregoing shall be limited to the amount actually paid by You through the Service or 100 USD if You haven't purchased anything through the Service.</p>
            <p>To the maximum extent permitted by applicable law, in no event shall the Company or its suppliers be liable for any special, incidental, indirect, or consequential damages whatsoever (including, but not limited to, damages for loss of profits, loss of data or other information, for business interruption, for personal injury, loss of privacy arising out of or in any way related to the use of or inability to use the Service, third-party software and/or third-party hardware used with the Service, or otherwise in connection with any provision of this Terms), even if the Company or any supplier has been advised of the possibility of such damages and even if the remedy fails of its essential purpose.</p>
            <p>Some states do not allow the exclusion of implied warranties or limitation of liability for incidental or consequential damages, which means that some of the above limitations may not apply. In these states, each party's liability will be limited to the greatest extent permitted by law.</p>
            <h1>&quot;AS IS&quot; and &quot;AS AVAILABLE&quot; Disclaimer</h1>
            <p>The Service is provided to You &quot;AS IS&quot; and &quot;AS AVAILABLE&quot; and with all faults and defects without warranty of any kind. To the maximum extent permitted under applicable law, the Company, on its own behalf and on behalf of its Affiliates and its and their respective licensors and service providers, expressly disclaims all warranties, whether express, implied, statutory or otherwise, with respect to the Service, including all implied warranties of merchantability, fitness for a particular purpose, title and non-infringement, and warranties that may arise out of course of dealing, course of performance, usage or trade practice. Without limitation to the foregoing, the Company provides no warranty or undertaking, and makes no representation of any kind that the Service will meet Your requirements, achieve any intended results, be compatible or work with any other software, applications, systems or services, operate without interruption, meet any performance or reliability standards or be error free or that any errors or defects can or will be corrected.</p>
            <p>Without limiting the foregoing, neither the Company nor any of the company's provider makes any representation or warranty of any kind, express or implied: (i) as to the operation or availability of the Service, or the information, content, and materials or products included thereon; (ii) that the Service will be uninterrupted or error-free; (iii) as to the accuracy, reliability, or currency of any information or content provided through the Service; or (iv) that the Service, its servers, the content, or e-mails sent from or on behalf of the Company are free of viruses, scripts, trojan horses, worms, malware, timebombs or other harmful components.</p>
            <p>Some jurisdictions do not allow the exclusion of certain types of warranties or limitations on applicable statutory rights of a consumer, so some or all of the above exclusions and limitations may not apply to You. But in such a case the exclusions and limitations set forth in this section shall be applied to the greatest extent enforceable under applicable law.</p>
            <h1>Governing Law</h1>
            <p>The laws of the Country, excluding its conflicts of law rules, shall govern this Terms and Your use of the Service. Your use of the Application may also be subject to other local, state, national, or international laws.</p>
            <h1>Disputes Resolution</h1>
            <p>If You have any concern or dispute about the Service, You agree to first try to resolve the dispute informally by contacting the Company.</p>
            <h1>For European Union (EU) Users</h1>
            <p>If You are a European Union consumer, you will benefit from any mandatory provisions of the law of the country in which you are resident in.</p>
            <h1>United States Legal Compliance</h1>
            <p>You represent and warrant that (i) You are not located in a country that is subject to the United States government embargo, or that has been designated by the United States government as a &quot;terrorist supporting&quot; country, and (ii) You are not listed on any United States government list of prohibited or restricted parties.</p>
            <h1>Severability and Waiver</h1>
            <h2>Severability</h2>
            <p>If any provision of these Terms is held to be unenforceable or invalid, such provision will be changed and interpreted to accomplish the objectives of such provision to the greatest extent possible under applicable law and the remaining provisions will continue in full force and effect.</p>
            <h2>Waiver</h2>
            <p>Except as provided herein, the failure to exercise a right or to require performance of an obligation under these Terms shall not effect a party's ability to exercise such right or require such performance at any time thereafter nor shall the waiver of a breach constitute a waiver of any subsequent breach.</p>
            <h1>Translation Interpretation</h1>
            <p>These Terms and Conditions may have been translated if We have made them available to You on our Service.
            You agree that the original English text shall prevail in the case of a dispute.</p>
            <h1>Changes to These Terms and Conditions</h1>
            <p>We reserve the right, at Our sole discretion, to modify or replace these Terms at any time. If a revision is material We will make reasonable efforts to provide at least 30 days' notice prior to any new terms taking effect. What constitutes a material change will be determined at Our sole discretion.</p>
            <p>By continuing to access or use Our Service after those revisions become effective, You agree to be bound by the revised terms. If You do not agree to the new terms, in whole or in part, please stop using the website and the Service.</p>
            <h1>Contact Us</h1>
            <p>If you have any questions about these Terms and Conditions, You can contact us:</p>
            <ul>
            <li>By email: loans@loans-llc.com</li>
            </ul>""";
}