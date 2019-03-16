package com.cg.insurance.exception;

public class InvalidMobileNumberException extends Exception{
	public InvalidMobileNumberException() {
		System.out.println("Invalid mobile number. It should be 10 digits");
	}
}
