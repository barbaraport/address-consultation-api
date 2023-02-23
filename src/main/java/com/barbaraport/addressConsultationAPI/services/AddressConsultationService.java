package com.barbaraport.addressConsultationAPI.services;

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

@Service
public class AddressConsultationService {
	
	@Autowired
	private FareCalculationService fareCalculationService;

	public AddressDTO getAddress(ZipCodeDTO zipCodeDTO) throws Exception {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(
				"http://www.viacep.com.br/ws/" + zipCodeDTO.getCep() + "/json/"
		);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<ViaCepResponseDTO> response = restTemplate.exchange(
		        builder.toUriString(), 
		        HttpMethod.GET, 
		        entity, 
		        ViaCepResponseDTO.class);
		
		ViaCepResponseDTO viaCepAddress = response.getBody();
		
		String uf = viaCepAddress.getUf();

		try {
			float fare = fareCalculationService.calculateFare(uf);
			
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
		catch(Exception exception) {
			throw exception;
		}
	}
}
