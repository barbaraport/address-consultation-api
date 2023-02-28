package com.barbaraport.addressConsultationAPI.services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.barbaraport.addressConsultationAPI.dto.AddressDTO;
import com.barbaraport.addressConsultationAPI.dto.ViaCepResponseDTO;
import com.barbaraport.addressConsultationAPI.dto.ZipCodeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * this service is the core from all the logic of the
 * Address Consultation API
 *
 * @author Port, B.
 */
@Service
public class AddressConsultationService {

    /**
     * service that handles the fare calculation
     */
    @Autowired
    private FareCalculationService fareCalculationService;

    /**
     * service that handles the zip code validation
     */
    @Autowired
    private ZipCodeHandlingService zipCodeHandlingService;

    /**
     * this method verifies the validity from the zip code
     * and returns an error message if it is not valid, or the address
     * and the calculated fare if everything was successful
     *
     * @param zipCodeDTO the zip code Data Transfer Object, which wraps the "cep"
     * @return the Address Data Transfer Object ({@link com.barbaraport.addressConsultationAPI.dto.AddressDTO})
     * @throws Exception in case of null, empty or invalid zip code
     * @author Port, B.
     */
    public AddressDTO getAddress(ZipCodeDTO zipCodeDTO) throws Exception {

        boolean isZipCodeDTONull = zipCodeHandlingService.isZipCodeDTONull(zipCodeDTO);
        if (isZipCodeDTONull) throw new Exception("The request must have a body containing the zip code.");

        String zipCode = zipCodeDTO.getCep();

        boolean isZipCodeNull = zipCodeHandlingService.isZipCodeNull(zipCode);
        if (isZipCodeNull) throw new Exception("The zip code cannot be null.");

        boolean isZipCodeEmpty = zipCodeHandlingService.isZipCodeEmpty(zipCode);
        if (isZipCodeEmpty) throw new Exception("The zip code cannot be empty.");

        boolean isValidZipCode = zipCodeHandlingService.isZipCodeValid(zipCode);
        if (!isValidZipCode) throw new Exception("The zip code " + zipCode + " is invalid.");

        ViaCepResponseDTO viaCepAddress = this.doRequest(zipCode);

        String uf = viaCepAddress.getUf();

        double fare = fareCalculationService.calculateFare(uf);

        return new AddressDTO(
                viaCepAddress.getCep(),
                viaCepAddress.getLogradouro(),
                viaCepAddress.getComplemento(),
                viaCepAddress.getBairro(),
                viaCepAddress.getLocalidade(),
                uf,
                fare
        );
    }

    /**
     * if the zip code is valid, this method is going to request the corresponding
     * address to the Via Cep API
     *
     * @param zipCode the valid zip code
     * @return the Via Cep Response
     * Data Transfer Object ({@link com.barbaraport.addressConsultationAPI.dto.ViaCepResponseDTO})
     * @throws Exception in case of any error while requesting to the API or if the API itself could not
     *                   return the address (outdated zip codes, for example)
     * @author Port, B.
     */
    private ViaCepResponseDTO doRequest(String zipCode) throws Exception {

        String rawZipCode = zipCodeHandlingService.removeMask(zipCode);

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(
                "http://www.viacep.com.br/ws/" + rawZipCode + "/json/"
        );

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<String> plainResponse = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);

        int statusCodeValue = plainResponse.getStatusCodeValue();
        if (statusCodeValue == 400)
            throw new Exception(
                    "There was an error processing the zip code " + zipCode
                            + ". Try again.");

        String plainResponseBody = plainResponse.getBody();

        JSONObject responseBody = new JSONObject(plainResponseBody);

        if (responseBody.has("erro"))
            throw new Exception("The zip code " + zipCode + " does not exist.");

        return new ObjectMapper().readValue(
                plainResponseBody,
                ViaCepResponseDTO.class
        );
    }
}
