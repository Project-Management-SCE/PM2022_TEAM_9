package com.example.demo;

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
}

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
}

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
}

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
}

// Driver code
class EnumConstructorExample {
    public static void main(String[] args) {
        System.out.println(OCCUPATION_TYPE.IT_STAFF);
    }
}