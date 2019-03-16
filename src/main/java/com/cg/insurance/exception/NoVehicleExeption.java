package com.cg.insurance.exception;

public class NoVehicleExeption extends Exception{
 public NoVehicleExeption() {
	 System.out.println("Vehicle is not registered to check validity.");
 }
}
