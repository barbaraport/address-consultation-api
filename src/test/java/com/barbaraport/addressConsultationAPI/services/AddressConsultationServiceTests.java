package com.barbaraport.addressConsultationAPI.services;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.barbaraport.addressConsultationAPI.dto.AddressDTO;
import com.barbaraport.addressConsultationAPI.dto.ZipCodeDTO;

@SpringBootTest
class AddressConsultationServiceTests {
	
	@Autowired
	private AddressConsultationService addressConsultationService;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void successfulForValidAndExistingZipCode1() throws Exception {
		AddressDTO result = addressConsultationService.getAddress(new ZipCodeDTO("01001000"));
		assertNotEquals("", result);
	}
	
	@Test
	public void successfulForValidAndExistingZipCode2() throws Exception {
		AddressDTO result = addressConsultationService.getAddress(new ZipCodeDTO("12280092"));
		assertNotEquals("", result);
	}
}
