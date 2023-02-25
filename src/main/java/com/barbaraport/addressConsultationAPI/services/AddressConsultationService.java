package com.barbaraport.addressConsultationAPI.services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.barbaraport.addressConsultationAPI.dto.AddressDTO;
import com.barbaraport.addressConsultationAPI.dto.ViaCepResponseDTO;
import com.barbaraport.addressConsultationAPI.dto.ZipCodeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AddressConsultationService {
	
	@Autowired
	private FareCalculationService fareCalculationService;
	
	@Autowired
	private ZipCodeHandlingService zipCodeHandlingService;

	public AddressDTO getAddress(ZipCodeDTO zipCodeDTO) throws Exception {
		
		boolean isZipCodeDTONull = zipCodeHandlingService.isZipCodeDTONull(zipCodeDTO);
		if (isZipCodeDTONull) throw new Exception("The request must have a body containing the zip code");
		
		String zipCode = zipCodeDTO.getCep();
		
		boolean isZipCodeNull = zipCodeHandlingService.isZipCodeNull(zipCode);
		if (isZipCodeNull) throw new Exception("The zip code can not be null");
		
		boolean isValidZipCode = zipCodeHandlingService.isZipCodeValid(zipCode);
		if (!isValidZipCode) throw new Exception("The zip code " + zipCode + " can not be invalid.");
		
		ViaCepResponseDTO viaCepAddress = this.doRequest(zipCode);
		
		String uf = viaCepAddress.getUf();

		double fare = fareCalculationService.calculateFare(uf);
			
		AddressDTO consultationAddress = new AddressDTO(
				viaCepAddress.getCep(),
				viaCepAddress.getLogradouro(),
				viaCepAddress.getComplemento(),
				viaCepAddress.getBairro(),
				viaCepAddress.getLocalidade(),
				uf,
				fare
		);

		return consultationAddress;
	}
	
	private ViaCepResponseDTO doRequest(String zipCode) throws Exception {
		
		String rawZipCode = zipCodeHandlingService.removeMask(zipCode);
		
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(
				"http://www.viacep.com.br/ws/" + rawZipCode + "/json/"
		);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<String> plainJsonResponse = restTemplate.exchange(
		        builder.toUriString(), 
		        HttpMethod.GET, 
		        entity, 
		        String.class);
		
		String plainJsonResponseBody = plainJsonResponse.getBody();
		
		JSONObject responseBody = new JSONObject(plainJsonResponseBody);
		
		if(responseBody.has("erro")) throw new Exception(
				"The zip code " + zipCode + " does not exist");
		
		ViaCepResponseDTO viaCepAddress = new ObjectMapper().readValue(
				plainJsonResponseBody,
				ViaCepResponseDTO.class
		);
		
		return viaCepAddress;
	}
}
