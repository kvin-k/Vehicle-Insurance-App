package com.cg.insurance;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.cg.insurance.dto.InsuranceDetails;
import com.cg.insurance.service.VehicleInsuranceService;
import com.cg.insurance.service.VehicleInsuranceServiceImpl;

public class Client 
{
    public static void main( String[] args )
    {
    	Scanner sc=new Scanner(System.in);
    	String vehicleNo;
    	// Lambda to show menu with no return type and no parameter.
    	Runnable menu=()->{
    		System.out.println("Menu");
	        System.out.println("1. Vehicle Insurance Registration");
	        System.out.println("2. Insurance Validity Check");
	        System.out.println("3. Exit");
    	};
    	InsuranceDetails details=new InsuranceDetails();
    	VehicleInsuranceService service=new VehicleInsuranceServiceImpl();
    	VehicleInsuranceServiceImpl serviceValidate=new VehicleInsuranceServiceImpl();
    	while(true) {
	    	menu.run();
	    	int choice=sc.nextInt();
	    	switch(choice) {
	    	case 1:
	    		System.out.println("Enter vehicle no:");
	    		vehicleNo=sc.next();
	    		System.out.println("Enter vehicle type:");
	    		details.setVehicleType(sc.nextInt());
	    		System.out.println("Enter insurance period:");
	    		details.setInsurancePeriod(sc.nextInt());
	    		System.out.println("Enter Aadhar number:");
	    		String aadhar=sc.next();
	    		// Validating the aadhar number
	    		if(serviceValidate.validateAadhar(aadhar)){
	    			details.setAadharNumber(aadhar);
	    			System.out.println("Enter mobile number:");
	    			String mobile=sc.next();
	    			//Validating the mobile number
	    			if(serviceValidate.validateMobileNumber(mobile)) {
			    		details.setMobileNumber(mobile);
			    		boolean registraionStatus=service.InsuranceRegistration(vehicleNo, details);
			    		if(registraionStatus) {
			    			System.out.println("Insurance for vehicle number "+vehicleNo+" is successfully done.");
			    		}
	    			}
	    		}	    		
	    		break;
	    	case 2:
	    		System.out.println("Enter vehicle number to check validity");
	    		int validityPeriod=service.validityCheck(sc.next());
	    		// If vehicle number is correct then return validity period else return -1
	    		if(validityPeriod>0) {
	    			// For setting the date format
		    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    		// To get current day for increment
		    		Calendar c = Calendar.getInstance();
		    		c.setTime(new Date()); // To get today date.
		    		c.add(Calendar.DATE, validityPeriod*365); // Adding  days
		    		String output = sdf.format(c.getTime());
	    			System.out.println("Insurance expires on "+output+" and "+validityPeriod*365 +" days left for renewal.");
	    		}
	    		break;
	    	case 3:
	    		System.out.println("Thank you");
	    		System.exit(0);
	    		break;
	    	default:
	    		System.out.println("Enter valid number");
	    		break;
	    	}
    	}
    }
}
