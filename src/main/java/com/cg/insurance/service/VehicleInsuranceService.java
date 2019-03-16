package com.cg.insurance.service;

import com.cg.insurance.dto.InsuranceDetails;

public interface VehicleInsuranceService {
	public boolean InsuranceRegistration(String vehicleNo,InsuranceDetails details);
	public int validityCheck(String vehicleNo);
}
