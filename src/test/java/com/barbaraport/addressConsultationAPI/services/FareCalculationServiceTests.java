package com.barbaraport.addressConsultationAPI.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FareCalculationServiceTests {
	
	@Autowired
	FareCalculationService fareCalculationService;
	
	@Test
	public void inexistentFederativeUnit() {
		
		String federativeUnit = "ABC";
		
	    Exception exception = assertThrows(
	    		Exception.class, 
	    		() -> fareCalculationService.calculateFare(federativeUnit)
	    );

	     assertTrue(exception.getMessage().contentEquals(
	    		 "It was not possible to determine which zone the " + 
	    				 federativeUnit + " belongs to."
	    ));
	}
	
	@Test
	public void nullFederativeUnit() {
		Exception exception = assertThrows(
	    		Exception.class, 
	    		() -> fareCalculationService.calculateFare(null)
	    );

	     assertTrue(exception.getMessage().contentEquals(
	    		 "The federative unit can not be null"
	    ));
	}
	
	@Test
	public void emptyFederativeUnit() {	
	    Exception exception = assertThrows(
	    		Exception.class, 
	    		() -> fareCalculationService.calculateFare("")
	    );

	     assertTrue(exception.getMessage().contentEquals(
	    		 "The federative unit can not be empty"
	    ));
	}
	
	@Test
	public void onlySpacesFederativeUnit() {
		Exception exception = assertThrows(
	    		Exception.class, 
	    		() -> fareCalculationService.calculateFare("   ")
	    );

	     assertTrue(exception.getMessage().contentEquals(
	    		 "The federative unit can not be empty"
	    ));
	}

	@Test
	public void existentFederativeUnitNorth() throws Exception {
		assertEquals(20.83, fareCalculationService.calculateFare("AM"));
		assertEquals(20.83, fareCalculationService.calculateFare("AC"));
		assertEquals(20.83, fareCalculationService.calculateFare("RO"));
		assertEquals(20.83, fareCalculationService.calculateFare("RR"));
		assertEquals(20.83, fareCalculationService.calculateFare("AP"));
		assertEquals(20.83, fareCalculationService.calculateFare("PA"));
		assertEquals(20.83, fareCalculationService.calculateFare("TO"));
	}

	@Test
	public void existentFederativeUnitNorthEast() throws Exception {
		assertEquals(15.98, fareCalculationService.calculateFare("MA"));
		assertEquals(15.98, fareCalculationService.calculateFare("PI"));
		assertEquals(15.98, fareCalculationService.calculateFare("RN"));
		assertEquals(15.98, fareCalculationService.calculateFare("CE"));
		assertEquals(15.98, fareCalculationService.calculateFare("PB"));
		assertEquals(15.98, fareCalculationService.calculateFare("RN"));
		assertEquals(15.98, fareCalculationService.calculateFare("BA"));
		assertEquals(15.98, fareCalculationService.calculateFare("PE"));
		assertEquals(15.98, fareCalculationService.calculateFare("AL"));
		assertEquals(15.98, fareCalculationService.calculateFare("SE"));
	}
	
	@Test
	public void existentFederativeUnitMidWest() throws Exception {
		assertEquals(12.50, fareCalculationService.calculateFare("DF"));
		assertEquals(12.50, fareCalculationService.calculateFare("GO"));
		assertEquals(12.50, fareCalculationService.calculateFare("MT"));
		assertEquals(12.50, fareCalculationService.calculateFare("MS"));
	}
	
	@Test
	public void existentFederativeUnitSouthEast() throws Exception {
		assertEquals(7.85, fareCalculationService.calculateFare("ES"));
		assertEquals(7.85, fareCalculationService.calculateFare("MG"));
		assertEquals(7.85, fareCalculationService.calculateFare("RJ"));
		assertEquals(7.85, fareCalculationService.calculateFare("SP"));
	}
	
	@Test
	public void existentFederativeUnitSouth() throws Exception {
		assertEquals(17.30, fareCalculationService.calculateFare("PR"));
		assertEquals(17.30, fareCalculationService.calculateFare("SC"));
		assertEquals(17.30, fareCalculationService.calculateFare("RS"));
	}
}
