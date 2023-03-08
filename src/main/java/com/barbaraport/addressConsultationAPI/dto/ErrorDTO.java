package com.barbaraport.addressConsultationAPI.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * this is the Data Transfer Object that represents the fail response from the
 * Address Consultation API
 *
 * @author Port, B.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Response body when the address was not found")
public class ErrorDTO {

    /**
     * error message
     */
    @ApiModelProperty(notes = "Error message", example = "The zip code 99999-999 does not exist", required = true)
    private String message;

}
