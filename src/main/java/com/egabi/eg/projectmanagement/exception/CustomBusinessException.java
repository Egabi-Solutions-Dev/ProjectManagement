package com.egabi.eg.projectmanagement.exception;

import org.springframework.http.HttpStatus;


public class CustomBusinessException extends BaseException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomBusinessException(String errorMessage) {
		super(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR.value());
	}
}
