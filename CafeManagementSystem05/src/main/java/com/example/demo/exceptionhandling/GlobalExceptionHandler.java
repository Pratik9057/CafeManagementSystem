package com.example.demo.exceptionhandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private String desc = "Description";

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> map = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String msg = error.getDefaultMessage();
			map.put(fieldName, msg);
		});
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	protected ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to get Customer");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
	}
	
	@ExceptionHandler(PhoneNumberValidationException.class)
    public ResponseEntity<String> handlePhoneNumberValidationException(PhoneNumberValidationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
	@ExceptionHandler(CustomerNameValidException.class)
    public ResponseEntity<String> handleCustomerNameValidException(CustomerNameValidException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
	
	//For Unique Mobile Number
	@ExceptionHandler(DuplicateMobileNumberException.class)
    public ResponseEntity<String> handleDuplicateMobileNumberException(DuplicateMobileNumberException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ex.getMessage());
    }
}
