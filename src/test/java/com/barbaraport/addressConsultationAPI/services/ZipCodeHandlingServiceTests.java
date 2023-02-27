package com.barbaraport.addressConsultationAPI.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.barbaraport.addressConsultationAPI.dto.ZipCodeDTO;

@SpringBootTest
public class ZipCodeHandlingServiceTests {

    @Autowired
    private ZipCodeHandlingService zipCodeHandlingService;

    @Test
    public void removeCharactersZipCode1() {
        assertEquals("12280112", zipCodeHandlingService.removeMask("12280-112"));
    }

    @Test
    public void zipCodeIsNull() {
        assertTrue(zipCodeHandlingService.isZipCodeNull(null));
    }

    @Test
    public void zipCodeDTONotNullAndZipCodeNotNull() {
        assertFalse(zipCodeHandlingService.isZipCodeDTONull(new ZipCodeDTO("12280112")));
    }

    @Test
    public void zipCodeDTONotNullAndZipCodeIsNull() {
        assertFalse(zipCodeHandlingService.isZipCodeDTONull(new ZipCodeDTO(null)));
    }

    @Test
    public void zipCodeDTOIsNull() {
        assertTrue(zipCodeHandlingService.isZipCodeDTONull(null));
    }

    @Test
    public void zipCodeNotNull() {
        assertFalse(zipCodeHandlingService.isZipCodeNull("12281-001"));
    }

    @Test
    public void zipCode1ValidationValid() {
        assertTrue(zipCodeHandlingService.isZipCodeValid("12280-112"));
    }

    @Test
    public void zipCode2ValidationValid() {
        assertTrue(zipCodeHandlingService.isZipCodeValid("12280112"));
    }

    @Test
    public void zipCode3ValidationNotValid() {
        assertFalse(zipCodeHandlingService.isZipCodeValid("12280--112"));
    }

    @Test
    public void zipCode4ValidationNotValid() {
        assertFalse(zipCodeHandlingService.isZipCodeValid("59$330000"));
    }

    @Test
    public void zipCode5ValidationNotValid() {
        assertFalse(zipCodeHandlingService.isZipCodeValid("12-281001"));
    }

    @Test
    public void zipCode6ValidationNotValid() {
        assertFalse(zipCodeHandlingService.isZipCodeValid("1228009a"));
    }

    @Test
    public void zipCode7ValidationValid() {
        assertFalse(zipCodeHandlingService.isZipCodeValid("12280 112"));
    }
}
