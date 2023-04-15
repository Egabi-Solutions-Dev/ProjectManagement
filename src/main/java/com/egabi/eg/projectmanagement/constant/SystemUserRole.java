package com.egabi.eg.projectmanagement.constant;

public enum SystemUserRole {

    ADMIN("ADMIN"),
    EMPLOYEE("EMPLOYEE");


    private final String value;
    SystemUserRole(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
