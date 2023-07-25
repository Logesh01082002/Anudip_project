package com.anudipProject.sprint1Project.exception;

public class NotAnEmailException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public NotAnEmailException(String value) {
        super(String.format("Check your email id provided '%s'", value));
    }

    public NotAnEmailException(String message, Throwable cause) {
        super(message, cause);
    }
}
