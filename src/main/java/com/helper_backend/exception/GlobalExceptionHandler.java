package com.helper_backend.exception;

import javax.security.auth.login.CredentialExpiredException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.helper_backend.response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorResponse> handleUserException(UserException ex) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), // 409 Conflict
				ex.getMessage(), null);
		return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
	}

	// fallback for unexpected errors
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Something went wrong: " + ex.getMessage(), null);
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ UnauthorizedException.class, CredentialExpiredException.class, BadCredentialsException.class })
	public ResponseEntity<ErrorResponse> handleUnauthorized(Exception ex) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), "Access token expired", null);
		return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
	}
}
