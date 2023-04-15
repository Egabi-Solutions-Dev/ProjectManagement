package com.egabi.eg.projectmanagement.exception;

import org.springframework.http.HttpStatus;


public class CDCUnauthorizedException extends BaseException {

    public CDCUnauthorizedException(String errorMessage) {
        super(errorMessage, HttpStatus.UNAUTHORIZED.value());
    }
}
