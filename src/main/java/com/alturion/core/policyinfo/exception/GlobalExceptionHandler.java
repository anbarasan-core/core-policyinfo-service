package com.alturion.core.policyinfo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alturion.core.policyinfo.common.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse<Void>> handleResourceNotFoundException(ResourceNotFoundException resourceException) {
		
		ApiResponse<Void> resourceNotFoundApiResponse = new ApiResponse<>(
				LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value(),
				resourceException.getMessage(),
				null
				);
		return new ResponseEntity<ApiResponse<Void>>(resourceNotFoundApiResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidPremiumAmountException.class)
	public ResponseEntity<ApiResponse<Void>> handlePremiumAmountException(InvalidPremiumAmountException invalidPremiumException) {
		
		ApiResponse<Void> invalidPremiumResponse = new ApiResponse<>(
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value(),
				invalidPremiumException.getMessage(),
				null
				);
		return new ResponseEntity<ApiResponse<Void>>(invalidPremiumResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PlanNotFoundException.class)
	public ResponseEntity<ApiResponse<Void>> hanldePlanNotFoundException(PlanNotFoundException planNotFoundException) {
		
		ApiResponse<Void> invalidPlanResponse = new ApiResponse<>(
				LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value(),
				planNotFoundException.getMessage(),
				null
				);
		return new ResponseEntity<ApiResponse<Void>>(invalidPlanResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DependencyServiceUnavailableException.class)
	public ResponseEntity<ApiResponse<Void>> handleDependencyServiceUnavailableException(DependencyServiceUnavailableException dependencyServiceException) {
		
		ApiResponse<Void> dependencyServiceUnavailableResponse = new ApiResponse<>(
				LocalDateTime.now(),
				HttpStatus.SERVICE_UNAVAILABLE.value(),
				dependencyServiceException.getMessage(),
				null
				);
		return new ResponseEntity<ApiResponse<Void>>(dependencyServiceUnavailableResponse,HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<Void>> handleMethodArgumentException(MethodArgumentNotValidException methodArgumentException) {
		
		ApiResponse<Void> methodArgumentResponse = new ApiResponse<>(
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value(),
				"Provided Input is NOT Valid",
				null
				);
		return new ResponseEntity<ApiResponse<Void>>(methodArgumentResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IllegalStateException.class)
	public ResponseEntity<ApiResponse<Void>> handleIllegalStateException(IllegalStateException illegalStateException) {
		
		ApiResponse<Void> illegalStateResponse = new ApiResponse<>(
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value(),
				illegalStateException.getMessage(),
				null
				);
		return new ResponseEntity<ApiResponse<Void>>(illegalStateResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<Void>> handleGenericException(Exception ex) {
		
		ApiResponse<Void> genericExceptionResponse = new ApiResponse<>(
				LocalDateTime.now(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Something Went Wrong",
				null
				);
		return new ResponseEntity<ApiResponse<Void>>(genericExceptionResponse,HttpStatus.SERVICE_UNAVAILABLE);
	}

}
