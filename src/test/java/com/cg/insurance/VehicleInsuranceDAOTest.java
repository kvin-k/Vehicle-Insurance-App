package com.cg.insurance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.insurance.dao.VehicleInsuranceDAO;
import com.cg.insurance.dao.VehicleInsuranceDAOImpl;
import com.cg.insurance.dto.InsuranceDetails;

class VehicleInsuranceDAOTest {
	static VehicleInsuranceDAO dao;
	
	@BeforeAll
	public static void init() {
		dao=new VehicleInsuranceDAOImpl();
	}
	@Test
	void InsuranceRegistrationtest() {
		InsuranceDetails details=new InsuranceDetails();
		details.setAadharNumber("123412341234");
		details.setInsurancePeriod(3);
		details.setMobileNumber("9988776655");
		details.setVehicleType(3);
		assertEquals(true, dao.InsuranceRegistration("TS08EJ9999", details));
	}
	@Test
	void validityChecktest() {
		assertEquals(-1, dao.validityCheck("Ts6s7"));
		
		
	}

}
