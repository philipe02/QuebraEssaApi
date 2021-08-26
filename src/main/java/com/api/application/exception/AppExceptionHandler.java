package com.api.application.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.application.model.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { StandardException.class })
	public ResponseEntity<Object> handleAnyException(Exception e, WebRequest request) {
		String errorDescription = e.getLocalizedMessage();
		if (errorDescription == null)
			errorDescription = e.toString();
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorDescription, e.getCause());

		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
