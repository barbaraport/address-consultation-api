package com.barbaraport.addressConsultationAPI.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.barbaraport.addressConsultationAPI.dto.AddressDTO;
import com.barbaraport.addressConsultationAPI.dto.ZipCodeDTO;

@SpringBootTest
class AddressConsultationServiceTests {

    @Autowired
    private AddressConsultationService addressConsultationService;

    @Test
    void contextLoads() {
    }

    @Test
    public void successfulForValidAndExistingZipCodeSouthEast1WithoutMask() throws Exception {
        AddressDTO result = addressConsultationService.getAddress(new ZipCodeDTO("01001000"));

        assertEquals("01001-000", result.getCep());
        assertEquals("Praça da Sé", result.getRua());
        assertEquals("lado ímpar", result.getComplemento());
        assertEquals("Sé", result.getBairro());
        assertEquals("São Paulo", result.getCidade());
        assertEquals("SP", result.getEstado());
        assertEquals(7.85, result.getFrete());
    }

    @Test
    public void successfulForValidAndExistingZipCodeSouthEast1WithMask() throws Exception {
        AddressDTO result = addressConsultationService.getAddress(new ZipCodeDTO("01001-000"));

        assertEquals("01001-000", result.getCep());
        assertEquals("Praça da Sé", result.getRua());
        assertEquals("lado ímpar", result.getComplemento());
        assertEquals("Sé", result.getBairro());
        assertEquals("São Paulo", result.getCidade());
        assertEquals("SP", result.getEstado());
        assertEquals(7.85, result.getFrete());
    }

    @Test
    public void successfulForValidAndExistingZipCodeSouthEast2WithoutMask() throws Exception {
        AddressDTO result = addressConsultationService.getAddress(new ZipCodeDTO("12280113"));

        assertEquals("12280-113", result.getCep());
        assertEquals("Avenida Francisca Salles Damasco", result.getRua());
        assertEquals("de 641/642 ao fim", result.getComplemento());
        assertEquals("Jardim São José", result.getBairro());
        assertEquals("Caçapava", result.getCidade());
        assertEquals("SP", result.getEstado());
        assertEquals(7.85, result.getFrete());
    }

    @Test
    public void successfulForValidAndExistingZipCodeSouthEast2WithMask() throws Exception {
        AddressDTO result = addressConsultationService.getAddress(new ZipCodeDTO("12280-113"));

        assertEquals("12280-113", result.getCep());
        assertEquals("Avenida Francisca Salles Damasco", result.getRua());
        assertEquals("de 641/642 ao fim", result.getComplemento());
        assertEquals("Jardim São José", result.getBairro());
        assertEquals("Caçapava", result.getCidade());
        assertEquals("SP", result.getEstado());
        assertEquals(7.85, result.getFrete());
    }

    @Test
    public void successfulForValidAndExistingZipCodeNorthEastWithoutMask() throws Exception {
        AddressDTO result = addressConsultationService.getAddress(new ZipCodeDTO("59042250"));

        assertEquals("59042-250", result.getCep());
        assertEquals("Rua Alto da Bela Vista", result.getRua());
        assertEquals("", result.getComplemento());
        assertEquals("Nordeste", result.getBairro());
        assertEquals("Natal", result.getCidade());
        assertEquals("RN", result.getEstado());
        assertEquals(15.98, result.getFrete());
    }

    @Test
    public void successfulForValidAndExistingZipCodeNorthEastWithMask() throws Exception {
        AddressDTO result = addressConsultationService.getAddress(new ZipCodeDTO("59042-250"));

        assertEquals("59042-250", result.getCep());
        assertEquals("Rua Alto da Bela Vista", result.getRua());
        assertEquals("", result.getComplemento());
        assertEquals("Nordeste", result.getBairro());
        assertEquals("Natal", result.getCidade());
        assertEquals("RN", result.getEstado());
        assertEquals(15.98, result.getFrete());
    }

    @Test
    public void successfulForValidAndExistingZipCodeNorthWithoutMask() throws Exception {
        AddressDTO result = addressConsultationService.getAddress(new ZipCodeDTO("69230970"));

        assertEquals("69230-970", result.getCep());
        assertEquals("Rua 07 de Setembro", result.getRua());
        assertEquals("100", result.getComplemento());
        assertEquals("Centro", result.getBairro());
        assertEquals("Nova Olinda do Norte", result.getCidade());
        assertEquals("AM", result.getEstado());
        assertEquals(20.83, result.getFrete());
    }

    @Test
    public void successfulForValidAndExistingZipCodeNorthWithMask() throws Exception {
        AddressDTO result = addressConsultationService.getAddress(new ZipCodeDTO("69230-970"));

        assertEquals("69230-970", result.getCep());
        assertEquals("Rua 07 de Setembro", result.getRua());
        assertEquals("100", result.getComplemento());
        assertEquals("Centro", result.getBairro());
        assertEquals("Nova Olinda do Norte", result.getCidade());
        assertEquals("AM", result.getEstado());
        assertEquals(20.83, result.getFrete());
    }

    @Test
    public void successfulForValidAndExistingZipCodeMidWestWithoutMask() throws Exception {
        AddressDTO result = addressConsultationService.getAddress(new ZipCodeDTO("70150900"));

        assertEquals("70150-900", result.getCep());
        assertEquals("Praça dos Três Poderes", result.getRua());
        assertEquals("", result.getComplemento());
        assertEquals("Zona Cívico-Administrativa", result.getBairro());
        assertEquals("Brasília", result.getCidade());
        assertEquals("DF", result.getEstado());
        assertEquals(12.50, result.getFrete());
    }

    @Test
    public void successfulForValidAndExistingZipCodeMidWestWithMask() throws Exception {
        AddressDTO result = addressConsultationService.getAddress(new ZipCodeDTO("70150-900"));

        assertEquals("70150-900", result.getCep());
        assertEquals("Praça dos Três Poderes", result.getRua());
        assertEquals("", result.getComplemento());
        assertEquals("Zona Cívico-Administrativa", result.getBairro());
        assertEquals("Brasília", result.getCidade());
        assertEquals("DF", result.getEstado());
        assertEquals(12.50, result.getFrete());
    }

    @Test
    public void successfulForValidAndExistingZipCodeSouthWithoutMask() throws Exception {
        AddressDTO result = addressConsultationService.getAddress(new ZipCodeDTO("90040320"));

        assertEquals("90040-320", result.getCep());
        assertEquals("Rua Vieira de Castro", result.getRua());
        assertEquals("", result.getComplemento());
        assertEquals("Farroupilha", result.getBairro());
        assertEquals("Porto Alegre", result.getCidade());
        assertEquals("RS", result.getEstado());
        assertEquals(17.30, result.getFrete());
    }

    @Test
    public void successfulForValidAndExistingZipCodeSouthWithMask() throws Exception {
        AddressDTO result = addressConsultationService.getAddress(new ZipCodeDTO("90040-320"));

        assertEquals("90040-320", result.getCep());
        assertEquals("Rua Vieira de Castro", result.getRua());
        assertEquals("", result.getComplemento());
        assertEquals("Farroupilha", result.getBairro());
        assertEquals("Porto Alegre", result.getCidade());
        assertEquals("RS", result.getEstado());
        assertEquals(17.30, result.getFrete());
    }

    @Test
    public void successfulForNonexistentZipCode() {
        String zipCode = "99999999";

        Exception exception = assertThrows(
                Exception.class,
                () -> addressConsultationService.getAddress(new ZipCodeDTO(zipCode))
        );

        assertTrue(exception.getMessage().contentEquals(
                "The zip code " + zipCode + " does not exist."
        ));
    }

    @Test
    public void successfulForInvalidZipCode1() {
        String zipCode = "9004-0320";

        Exception exception = assertThrows(
                Exception.class,
                () -> addressConsultationService.getAddress(new ZipCodeDTO(zipCode))
        );

        assertTrue(exception.getMessage().contentEquals(
                "The zip code " + zipCode + " is invalid."
        ));
    }

    @Test
    public void successfulForInvalidZipCode2() {
        String zipCode = "900403 20";

        Exception exception = assertThrows(
                Exception.class,
                () -> addressConsultationService.getAddress(new ZipCodeDTO(zipCode))
        );

        assertTrue(exception.getMessage().contentEquals(
                "The zip code " + zipCode + " is invalid."
        ));
    }

    @Test
    public void successfulForInvalidZipCode3() {
        String zipCode = " 900403 20 ";

        Exception exception = assertThrows(
                Exception.class,
                () -> addressConsultationService.getAddress(new ZipCodeDTO(zipCode))
        );

        assertTrue(exception.getMessage().contentEquals(
                "The zip code " + zipCode + " is invalid."
        ));
    }

    @Test
    public void successfulForNullZipCode() {
        Exception exception = assertThrows(
                Exception.class,
                () -> addressConsultationService.getAddress(new ZipCodeDTO(null))
        );

        assertTrue(exception.getMessage().contentEquals("The zip code cannot be null."));
    }

    @Test
    public void successfulForEmptyZipCode() {
        Exception exception = assertThrows(
                Exception.class,
                () -> addressConsultationService.getAddress(new ZipCodeDTO(" "))
        );

        assertTrue(exception.getMessage().contentEquals("The zip code cannot be empty."));
    }

    @Test
    public void successfulForNullRequestBody() {
        Exception exception = assertThrows(
                Exception.class,
                () -> addressConsultationService.getAddress(null)
        );

        assertTrue(exception.getMessage().contentEquals("The request must have a body containing the zip code."));
    }
}
