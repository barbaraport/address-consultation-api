package com.barbaraport.addressConsultationAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbaraport.addressConsultationAPI.dto.AddressDTO;
import com.barbaraport.addressConsultationAPI.dto.ZipCodeDTO;
import com.barbaraport.addressConsultationAPI.services.AddressConsultationService;

@RestController
@RequestMapping(path = "v1/consulta-endereco")
public class AddressConsultationController {
	
	@Autowired
	private AddressConsultationService addressConsultationService;

	@PostMapping(produces = "application/json;charset=UTF-8")
	public ResponseEntity<?> getAddress(@RequestBody ZipCodeDTO zipCodeDTO) throws Exception {
		try {
			return new ResponseEntity<AddressDTO>(addressConsultationService.getAddress(zipCodeDTO), HttpStatus.OK);
		}
		catch (Exception exception) {
			return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
