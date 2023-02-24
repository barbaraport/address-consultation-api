package com.barbaraport.addressConsultationAPI.services;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class ZipCodeHandlingService {

	public String removeMask(String zipCode) {
		return zipCode.replaceAll("[^0-9]", "");
	}

	public boolean isZipCodeValid(String zipCode) {
		return Pattern.matches("\\d{5}[\\-]?\\d{3}", zipCode);
	}
}
