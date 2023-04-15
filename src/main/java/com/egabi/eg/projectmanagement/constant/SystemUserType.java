package com.egabi.eg.projectmanagement.constant;

public enum SystemUserType {

    AUTO_SERVICE("AUTO_SERVICE"),
    WEB_SERVICE("WEB_SERVICE"),
    APPLICATION("APPLICATION");


    private final String value;
    SystemUserType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
