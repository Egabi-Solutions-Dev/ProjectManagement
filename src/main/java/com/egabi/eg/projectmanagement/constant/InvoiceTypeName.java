package com.egabi.eg.projectmanagement.constant;

public enum InvoiceTypeName {
    STANDARD_INVOICE("0100000"),
    SIMPLIFIED_INVOICE ("0200000");


    private final String value;

    InvoiceTypeName(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
