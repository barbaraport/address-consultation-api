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

@CrossOrigin
@RestController
@Api(
        value = "Address Consultation API",
        consumes = "application/json",
        produces = "application/json"
)
@RequestMapping(path = "/v1/consulta-endereco")
public class AddressConsultationController {

    @Autowired
    private AddressConsultationService addressConsultationService;

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
