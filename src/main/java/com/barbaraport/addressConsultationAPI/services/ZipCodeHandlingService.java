package com.barbaraport.addressConsultationAPI.services;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.barbaraport.addressConsultationAPI.dto.ZipCodeDTO;

@Service
public class ZipCodeHandlingService {

	public String removeMask(String zipCode) {
		return zipCode.replaceAll("[^0-9]", "");
	}

	public boolean isZipCodeValid(String zipCode) {
		return Pattern.matches("\\d{5}[\\-]?\\d{3}", zipCode);
	}
	
	public boolean isZipCodeNull(String zipCode) {
		return zipCode == null;
	}
	
	public boolean isZipCodeDTONull(ZipCodeDTO zipCodeDTO) {
		return zipCodeDTO == null;
	}
}
