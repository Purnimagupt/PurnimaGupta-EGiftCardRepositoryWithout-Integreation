package com.egiftcard.exception;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler {

		@ExceptionHandler(DuplicateGiftCardIdException.class)
		public ResponseEntity<ExceptionResponse> handleDuplicateIDException(DuplicateGiftCardIdException exception){
			ExceptionResponse response=new ExceptionResponse();
			response.setErrorCode("CONFLICT");
			response.setErrorMessage(exception.getMessage());
			response.setTimestamp(LocalDateTime.now());
			ResponseEntity<ExceptionResponse> responseEntyity=new ResponseEntity<ExceptionResponse>(response,HttpStatus.CONFLICT);
			return responseEntyity;
		}
		@ExceptionHandler(InvalidIdException.class)
		public ResponseEntity<ExceptionResponse> handleInvalidIdException(InvalidIdException  exception1){
			ExceptionResponse response1=new ExceptionResponse();
			response1.setErrorCode("NOT_ACCEPTABLE");
			response1.setErrorMessage( exception1.getMessage());
			response1.setTimestamp(LocalDateTime.now());
			ResponseEntity<ExceptionResponse> responseEntyity=new ResponseEntity<ExceptionResponse>(response1,HttpStatus.NOT_ACCEPTABLE);
			return responseEntyity;
		}
		
		@ExceptionHandler(GiftCardNotFoundException.class)
		public ResponseEntity<ExceptionResponse> handleGiftCardNotFoundException(GiftCardNotFoundException  exception2){
			ExceptionResponse response2=new ExceptionResponse();
			response2.setErrorCode("NOT_FOUND");
			response2.setErrorMessage( exception2.getMessage());
			response2.setTimestamp(LocalDateTime.now());
			ResponseEntity<ExceptionResponse> responseEntyity=new ResponseEntity<ExceptionResponse>(response2,HttpStatus.NOT_FOUND);
			return responseEntyity;
		}
		
	   @ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<ExceptionResponse> handleValidationExceptions(MethodArgumentNotValidException exception3){
			ExceptionResponse response2=new ExceptionResponse();
			
			Map<String, String> errors = new HashMap<>();
		    exception3.getBindingResult().getAllErrors().forEach((error) -> {
		        String fieldName = ((FieldError) error).getField();
		        String errorMessage = error.getDefaultMessage();
		        errors.put(fieldName, errorMessage);});
		    String errormessage=null;
		    for(String key:errors.keySet()) {
		    	errormessage=errors.get(key);
		    }
            response2.setErrorCode("UNSUPPORTED_MEDIA_TYPE");
			response2.setErrorMessage(errormessage);
			response2.setTimestamp(LocalDateTime.now());
			ResponseEntity<ExceptionResponse> responseEntyity=new ResponseEntity<ExceptionResponse>(response2,HttpStatus.UNSUPPORTED_MEDIA_TYPE);
			return responseEntyity;
		}

		
	/*	@SuppressWarnings("unchecked")
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public  ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
		  MethodArgumentNotValidException ex) {
		    Map<String, String> errors = new HashMap<>();
		    ex.getBindingResult().getAllErrors().forEach((error) -> {
		        String fieldName = ((FieldError) error).getField();
		        String errorMessage = error.getDefaultMessage();
		        errors.put(fieldName, errorMessage);
		    });
		    return new ResponseEntity<Map<String, String>>(errors,HttpStatus.UNSUPPORTED_MEDIA_TYPE);
		}*/
	   
	   

	}


