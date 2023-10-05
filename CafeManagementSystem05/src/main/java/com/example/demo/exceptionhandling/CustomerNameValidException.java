package com.example.demo.exceptionhandling;

public class CustomerNameValidException extends RuntimeException{
	public CustomerNameValidException(String message)
	{
		super(message);
	}
}
