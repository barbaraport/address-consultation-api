package com.barbaraport.addressConsultationAPI.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.barbaraport.addressConsultationAPI.dto.ZipCodeDTO;

@Service
public class AddressConsultationService {

	public HttpEntity<String> getAddress(ZipCodeDTO zipCodeDTO) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(
				"http://www.viacep.com.br/ws/" + zipCodeDTO.getCep() + "/json/"
		);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<String> response = restTemplate.exchange(
		        builder.toUriString(), 
		        HttpMethod.GET, 
		        entity, 
		        String.class);
		
		return response;
	}
}
