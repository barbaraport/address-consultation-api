package com.barbaraport.addressConsultationAPI.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * this is the Data Transfer Object that represents the fail response from the
 * Address Consultation API
 *
 * @author Port, B.
 */
@ApiModel(description = "Response body when the address was not found")
public class ErrorDTO {

    /**
     * error message
     */
    @ApiModelProperty(notes = "Error message", example = "The zip code 99999-999 does not exist", required = true)
    private String message;

    /**
     * empty constructor
     */
    public ErrorDTO() {
    }

    public ErrorDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
