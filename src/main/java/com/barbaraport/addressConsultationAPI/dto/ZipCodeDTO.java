package com.barbaraport.addressConsultationAPI.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * this is the Data Transfer Object that represents the request body
 * to send the zip code to the Address Consultation API
 *
 * @author Port, B.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Request body to wrap the zip code and send it to the API")
public class ZipCodeDTO {

    /**
     * zip code
     */
    @ApiModelProperty(notes = "Zip code", example = "01001-000", required = true)
    private String cep;

}
