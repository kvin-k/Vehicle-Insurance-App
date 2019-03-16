package com.cg.insurance.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.insurance.dto.InsuranceDetails;

public class VehicleInsuranceDAOImpl implements VehicleInsuranceDAO {
	
	// Creating hashmap to store values
	Map<String,InsuranceDetails> insuranceEntry=new HashMap<String, InsuranceDetails>();

	@Override
	public boolean InsuranceRegistration(String vehicleNo, InsuranceDetails details) {
		
		boolean result=false;
		if(!insuranceEntry.containsKey(vehicleNo)) {	
			
			insuranceEntry.put(vehicleNo, details);
			result=true;
		}
		else {
			result=false;// Returns false if Vehicle is already registered.
		}	
		return result;
	}

	@Override
	public int validityCheck(String vehicleNo) {
		// We took validity period to return the value for this method.
		int validityPeriod;
		InsuranceDetails detailsCheck=new InsuranceDetails();
		if(insuranceEntry.containsKey(vehicleNo)) {
			detailsCheck=insuranceEntry.get(vehicleNo);	
			validityPeriod=detailsCheck.getInsurancePeriod();
		}else {			
			validityPeriod=-1;// ValidityPeriod is -1 if vehicle is not registered.
		}
		return validityPeriod;
	}

}
