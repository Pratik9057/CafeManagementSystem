package com.example.demo.exceptionhandling;

public class PhoneNumberValidationException extends RuntimeException{
	public PhoneNumberValidationException(String message) {
        super(message);
    }
}
