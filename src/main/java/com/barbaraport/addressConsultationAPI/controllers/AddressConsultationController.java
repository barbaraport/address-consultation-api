package com.barbaraport.addressConsultationAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.barbaraport.addressConsultationAPI.dto.AddressDTO;
import com.barbaraport.addressConsultationAPI.dto.ErrorDTO;
import com.barbaraport.addressConsultationAPI.dto.ZipCodeDTO;
import com.barbaraport.addressConsultationAPI.services.AddressConsultationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * this controllers contains the main route
 * from the Address Consultation API
 *
 * @author Port, B.
 */
@CrossOrigin
@RestController
@Api(
        value = "Address Consultation API",
        consumes = "application/json",
        produces = "application/json"
)
@RequestMapping(path = "/v1/consulta-endereco")
public class AddressConsultationController {

    /**
     * service to handle the address consultation
     */
    @Autowired
    private AddressConsultationService addressConsultationService;

    /**
     * this method always is called when there's a POST request to the
     * /v1/consulta-endereco route
     *
     * @param zipCodeDTO is the request body and must have a "cep" inside it
     * @return a response entity containing the response after processing the zip code,
     * which can be an error, in case of error, or the address, in case of success
     * @author Port, B.
     */
    @ApiOperation(
            value = "Finds the address from a given zip code",
            notes = "The zip code can have a mask or not. Example: 12280-112 or 12280112",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "POST"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Everything is OK and the address was found",
                    response = AddressDTO.class
            ),
            @ApiResponse(
                    code = 400,
                    message = "The zip code is invalid or it does not exist",
                    response = ErrorDTO.class
            ),
    })
    @PostMapping(produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> getAddress(@RequestBody ZipCodeDTO zipCodeDTO) {
        try {
            return new ResponseEntity<>(addressConsultationService.getAddress(zipCodeDTO), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ErrorDTO(exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
