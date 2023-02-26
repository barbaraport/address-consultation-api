package com.barbaraport.addressConsultationAPI.dto;

import io.swagger.annotations.ApiModelProperty;

public class ZipCodeDTO {
	
	@ApiModelProperty(notes = "Zip code", example = "12280-112", required = true)
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
