package com.egabi.eg.projectmanagement.exception;

import com.egabi.eg.projectmanagement.constant.ErrorsConstants;
import com.egabi.eg.projectmanagement.response.ApiBaseModel;

import com.egabi.eg.projectmanagement.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	private static final Logger LOGGER = LogManager.getLogger(GlobalControllerExceptionHandler.class);




//	org.springframework.security.web.firewall.RequestRejectedException

	@ExceptionHandler(value = RequestRejectedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody
	ApiBaseModel handleRequestRejectedException(HttpServletRequest req, Exception ex) {
		logException(ex);

		Set err = new HashSet<Integer>();
		err.add(HttpStatus.BAD_REQUEST.value());
		ApiBaseModel res = new ApiBaseModel(Boolean.FALSE,err,null,null);
		return res;
	}


	@ExceptionHandler(value = CustomBusinessException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody
	ApiBaseModel handleBusinessException(HttpServletRequest req, CustomBusinessException ex) {
		logException(ex);
		LOGGER.info(ex.getMessage());
		String errorMessage= formatExceptionMsg(ex.getMessage());
		Set err = new HashSet<Integer>();
		err.add(ex.getErrorCode());
		ApiBaseModel res = new ApiBaseModel(Boolean.FALSE,err,null,null);
		return res;
//		return new ErrorResponse(errorMessage, ex.getErrorCode());
	}

	@ExceptionHandler(value = CDCUnauthorizedException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public @ResponseBody ApiBaseModel handleUnauthorizedException(HttpServletRequest req, CDCUnauthorizedException ex) {
		logException(ex);
		LOGGER.info(ex.getMessage());
		Set err = new HashSet<Integer>();
		err.add(ex.getErrorCode());
		ApiBaseModel res = new ApiBaseModel(Boolean.FALSE,err,null,null);
		return res;
	}

	@ExceptionHandler(value = LockedException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public @ResponseBody ApiBaseModel handleLockedException(HttpServletRequest req, LockedException ex) {
		logException(ex);
		LOGGER.info(ex.getMessage());
		Set err = new HashSet<Integer>();
		err.add(ErrorsConstants.AUTH_USER_LOCKED);
		ApiBaseModel res = new ApiBaseModel(Boolean.FALSE,err,null,null);
		return res;
	}

	@ExceptionHandler(value = DisabledException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public @ResponseBody ApiBaseModel handleLockedException(HttpServletRequest req, DisabledException ex) {
		logException(ex);
		LOGGER.info(ex.getMessage());
		Set err = new HashSet<Integer>();
		err.add(ErrorsConstants.AUTH_USER_DISABLED);
		ApiBaseModel res = new ApiBaseModel(Boolean.FALSE,err,null,null);
		return res;
	}

	@ExceptionHandler(value = BadCredentialsException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public @ResponseBody ApiBaseModel handleBadCredentialsException(HttpServletRequest req, BadCredentialsException ex) {
		logException(ex);
		LOGGER.info(ex.getMessage());
		Set err = new HashSet<Integer>();
		err.add(ErrorsConstants.AUTH_INVALID_CREDENTIALS);
		ApiBaseModel res = new ApiBaseModel(Boolean.FALSE,err,null,null);
		return res;
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ApiBaseModel handleMethodArgumentException(HttpServletRequest req, Exception ex) {

		logException(ex);

		StringBuilder sb = new StringBuilder();
		List<FieldError> fieldErrors = ((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			sb.append(fieldError.getDefaultMessage());
			sb.append(";");
		}
		Set err = new HashSet<Integer>();
		err.add(HttpStatus.INTERNAL_SERVER_ERROR.value());
		ApiBaseModel res = new ApiBaseModel(Boolean.FALSE,err,null,null);
		return res;
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ApiBaseModel handleException(HttpServletRequest req, Exception ex) {
		logException(ex);
		String errorMessage= formatExceptionMsg(ex.getMessage());
		Set err = new HashSet<Integer>();
		err.add(HttpStatus.INTERNAL_SERVER_ERROR.value());
		ApiBaseModel res = new ApiBaseModel(Boolean.FALSE,err,null,null);
		return res;
	}

	@ExceptionHandler(value = javax.validation.ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ApiBaseModel handleConstraintViolationException(HttpServletRequest req, javax.validation.ConstraintViolationException ex) {
		logException(ex);
		String errorMessage = ex.getMessage();
		String[] errors = errorMessage.split(",");
		Set<Integer> errSet = new HashSet<>(1,1);

		for (String err: errors){
			errSet.add(Utils.getResourceMessageAsInteger(err));
		}

//
//		HashSet<Integer> errorCodes =
//		int[] errorCodes = errSet.stream().mapToInt(num -> num.intValue()).toArray();

		ApiBaseModel res = new ApiBaseModel(Boolean.FALSE,errSet,null,null);
		return res;
	}

	private void logException(Throwable th) {
		String errorMessage = th.getMessage();

		if (th.getStackTrace() != null) {
			LOGGER.error(errorMessage, th);
		} else {
			LOGGER.error(errorMessage);
		}
	}

	private String formatExceptionMsg(String msg){
		if(msg==null || msg.equals("")){
			return null;
		}

		String code = msg.replaceAll(" ","_").toUpperCase(Locale.ROOT);

		return code;
	}


}