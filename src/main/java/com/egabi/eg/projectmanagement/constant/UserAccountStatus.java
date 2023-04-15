package com.egabi.eg.projectmanagement.constant;

public enum UserAccountStatus {
    ACTIVE ("ACT"),
    DISABLED("DIS"),
    LOCKED("LCK");

    private final String value;
    UserAccountStatus(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
