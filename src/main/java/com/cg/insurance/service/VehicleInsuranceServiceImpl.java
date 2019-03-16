package com.cg.insurance.service;

import com.cg.insurance.Client;
import com.cg.insurance.dao.VehicleInsuranceDAO;
import com.cg.insurance.dao.VehicleInsuranceDAOImpl;
import com.cg.insurance.dto.InsuranceDetails;
import com.cg.insurance.exception.InvalidAadharException;
import com.cg.insurance.exception.InvalidMobileNumberException;
import com.cg.insurance.exception.NoVehicleExeption;
import com.cg.insurance.exception.VehicleNumberExistException;

public class VehicleInsuranceServiceImpl implements VehicleInsuranceService {
	VehicleInsuranceDAO dao=new VehicleInsuranceDAOImpl();
	@Override
	public boolean InsuranceRegistration(String vehicleNo, InsuranceDetails details) {
		// Return true is vehicle is registered else false
		if(dao.InsuranceRegistration(vehicleNo, details)) {
			return true;
		}
		else {
			try {
				throw new VehicleNumberExistException();
			} catch (VehicleNumberExistException e) {
			}
			return false;
		}
	}

	@Override
	public int validityCheck(String vehicleNo) {
		// 'temp' variable to return the value.
		int temp=dao.validityCheck(vehicleNo);
		if(temp>0) {
			return temp;
		}else {
			try {
				throw new NoVehicleExeption();
			} catch (NoVehicleExeption e) {
			}
			return -1;
		}
		
	}
	// Checking aadhar number length
	public boolean validateAadhar(String aadhar) {
		if(aadhar.length()==12) {
			return true;
		}else {
			try {
				throw new InvalidAadharException();
			} catch (InvalidAadharException e) {
			}
			return false;
		}
	}
	// Checking mobile number length
	public boolean validateMobileNumber(String mobile) {
		if(mobile.length()==10) {
			return true;
		}else {
			try {
				throw new InvalidMobileNumberException();
			} catch (InvalidMobileNumberException e) {
			}
			return false;
		}
	}

}
