package com.barbaraport.addressConsultationAPI.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
		
		assertEquals("01001-000", result.getCep());
		assertEquals("Praça da Sé", result.getRua());
		assertEquals("lado ímpar", result.getComplemento());
		assertEquals("Sé", result.getBairro());
		assertEquals("São Paulo", result.getCidade());
		assertEquals("SP", result.getEstado());
		assertEquals(7.85, result.getFrete());
	}
	
	@Test
	public void successfulForValidAndExistingZipCode2() throws Exception {
		AddressDTO result = addressConsultationService.getAddress(new ZipCodeDTO("12280113"));
		
		assertEquals("12280-113", result.getCep());
		assertEquals("Avenida Francisca Salles Damasco", result.getRua());
		assertEquals("de 641/642 ao fim", result.getComplemento());
		assertEquals("Jardim São José", result.getBairro());
		assertEquals("Caçapava", result.getCidade());
		assertEquals("SP", result.getEstado());
		assertEquals(7.85, result.getFrete());
	}
	
	@Test
	public void successfulForNullZipCode() throws Exception {
		Exception exception = assertThrows(
				Exception.class, 
				() -> addressConsultationService.getAddress(new ZipCodeDTO(null))
		);

		assertTrue(exception.getMessage().contentEquals("The zip code can not be null"));
	}
	
	@Test
	public void successfulForNullRequestBody() throws Exception {
		Exception exception = assertThrows(
				Exception.class, 
				() -> addressConsultationService.getAddress(null)
		);

		assertTrue(exception.getMessage().contentEquals("The request must have a body containing the zip code"));
	}
}
