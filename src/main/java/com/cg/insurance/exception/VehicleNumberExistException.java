package com.cg.insurance.exception;

public class VehicleNumberExistException extends Exception {
	public VehicleNumberExistException(){
		System.out.println("Vehicle already registered. Give new vehicle number.");
	}
}
