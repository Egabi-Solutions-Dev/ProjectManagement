package com.egabi.eg.projectmanagement.exception;



public class BaseException extends Exception {

    private String errorMessage;
    private int errorCode;

    public BaseException(String errorMessage, int errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
