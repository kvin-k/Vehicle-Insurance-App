package com.cg.insurance.exception;

public class InvalidAadharException extends Exception{
	public InvalidAadharException() {
		System.out.println("Aadhar Number should be 12 digits");
	}
}
