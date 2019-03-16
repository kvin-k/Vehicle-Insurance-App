package com.cg.insurance.dao;

import com.cg.insurance.dto.InsuranceDetails;

public interface VehicleInsuranceDAO {
	public boolean InsuranceRegistration(String vehicleNo,InsuranceDetails details);
	public int validityCheck(String vehicleNo);
}
