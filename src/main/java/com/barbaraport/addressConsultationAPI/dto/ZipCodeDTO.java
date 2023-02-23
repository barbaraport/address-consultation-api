package com.barbaraport.addressConsultationAPI.dto;

public class ZipCodeDTO {
	private String cep;
	
	public ZipCodeDTO() {}
	
	public ZipCodeDTO(String cep) {
		this.cep = cep;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
