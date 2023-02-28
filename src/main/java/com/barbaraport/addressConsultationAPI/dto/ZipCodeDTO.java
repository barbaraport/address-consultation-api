package com.barbaraport.addressConsultationAPI.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * this is the Data Transfer Object that represents the request body
 * to send the zip code to the Address Consultation API
 *
 * @author Port, B.
 */
@ApiModel(description = "Request body to wrap the zip code and send it to the API")
public class ZipCodeDTO {

    /**
     * zip code
     */
    @ApiModelProperty(notes = "Zip code", example = "01001-000", required = true)
    private String cep;

    public ZipCodeDTO() {
    }

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
