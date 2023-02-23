package com.barbaraport.addressConsultationAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barbaraport.addressConsultationAPI.dto.ZipCodeDTO;
import com.barbaraport.addressConsultationAPI.services.AddressConsultationService;

@RestController
@RequestMapping(path = "v1/consulta-endereco")
public class AddressConsultationController {
	
	@Autowired
	public AddressConsultationService addressConsultationService;

	@PostMapping
	public String getAddress(@RequestBody ZipCodeDTO zipCodeDTO) {
		return addressConsultationService.getAddress();
	}
}
