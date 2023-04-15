package com.egabi.eg.projectmanagement.constant;

public enum InvoiceTypeCode {
    NORMAL("388"),
    DEBIT ("383"),
    CREDIT ("381");


    private final String value;

    InvoiceTypeCode(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
