package com.frontendauthentication.exception;

public class InvalidInputException extends RuntimeException{
	private static final long serialVersionUID = 8956220829979476801L;

	public InvalidInputException(String message) {
        super(message);
	}
	
}
