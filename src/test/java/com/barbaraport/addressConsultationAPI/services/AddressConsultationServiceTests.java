package com.barbaraport.addressConsultationAPI.services;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;

import com.barbaraport.addressConsultationAPI.dto.ZipCodeDTO;

@SpringBootTest
class AddressConsultationServiceTests {
	
	@Autowired
	private AddressConsultationService addressConsultationService;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void successfulForValidAndExistingZipCode1() {
		HttpEntity<String> result = addressConsultationService.getAddress(new ZipCodeDTO("01001000"));
		assertNotEquals("", result.getBody());
	}
	
	@Test
	public void successfulForValidAndExistingZipCode2() {
		HttpEntity<String> result = addressConsultationService.getAddress(new ZipCodeDTO("12280092"));
		assertNotEquals("", result.getBody());
	}
}
