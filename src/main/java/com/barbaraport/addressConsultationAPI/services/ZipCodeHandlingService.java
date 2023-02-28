package com.barbaraport.addressConsultationAPI.services;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.barbaraport.addressConsultationAPI.dto.ZipCodeDTO;

/**
 * this service handles all the validation and handling from the
 * zip codes
 *
 * @author Port, B.
 */
@Service
public class ZipCodeHandlingService {

    /**
     * removes the mask from the zip code,
     * leaving it just with the numbers
     *
     * @param zipCode the zip code, with mask or not (if it does not have a mask, the content will not
     *                be changed)
     * @return the raw zip code (without masks)
     * @author Port, B.
     */
    public String removeMask(String zipCode) {
        return zipCode.replaceAll("[^0-9]", "");
    }

    /**
     * checks if the given zip code has eight numbers (if raw)
     * or matches the "five numbers, hyphen and more three numbers" pattern
     *
     * @param zipCode the zip code, which can be raw or not
     * @return true if the zip code matches to the patterns (raw or with mask). otherwise,
     * returns false
     * @author Port, B.
     */
    public boolean isZipCodeValid(String zipCode) {
        return Pattern.matches("\\d{5}[\\-]?\\d{3}", zipCode);
    }

    /**
     * removes all the leading and trailing spaces from the zip code string
     * and returns if it is empty or not
     *
     * @param zipCode the zip code string, which can have any content
     * @return true if it is empty or false if it has some content
     * @author Port, B.
     */
    public boolean isZipCodeEmpty(String zipCode) {
        return zipCode.trim().strip().equals("");
    }

    /**
     * checks if the zip code string is null, which prevents NullPointerException
     *
     * @param zipCode the zip code string, which can have any content
     * @return true if the string is null, or false if it is not null
     * @author Port, B.
     */
    public boolean isZipCodeNull(String zipCode) {
        return zipCode == null;
    }

    /**
     * checks if the zip code wrapper, the ZipCodeDTO
     * ({@link com.barbaraport.addressConsultationAPI.dto.ZipCodeDTO}) is entirely null,
     * which prevents NullPointerException
     *
     * @param zipCodeDTO the {@link com.barbaraport.addressConsultationAPI.dto.ZipCodeDTO} which comes
     *                   from the client
     * @return if the Data Transfer Object is null or not
     * @author Port, B.
     */
    public boolean isZipCodeDTONull(ZipCodeDTO zipCodeDTO) {
        return zipCodeDTO == null;
    }
}
