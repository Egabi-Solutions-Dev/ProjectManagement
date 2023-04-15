package com.egabi.eg.projectmanagement.constant;
public enum ServiceCalledType {
    SELECTED_INVOICES("SELECTED_INVOICES"),
    DAILY_INVOICES ("DAILY_INVOICES"),
    ONE_INVOICE ("ONE_INVOICE");

    private String value;
    ServiceCalledType(String value){
        this.value=value;
    }
    public String getValue() {
        return value;
    }
}