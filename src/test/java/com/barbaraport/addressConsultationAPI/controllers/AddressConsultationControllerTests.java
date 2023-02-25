package com.barbaraport.addressConsultationAPI.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.barbaraport.addressConsultationAPI.dto.AddressDTO;
import com.barbaraport.addressConsultationAPI.dto.ZipCodeDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class AddressConsultationControllerTests {
	
	private static final String ROUTE = "/v1/consulta-endereco";
	
	@Autowired
    private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void successfulForValidAndExistingZipCodeSouthEast1WithoutMask() throws JsonProcessingException, Exception {
		MvcResult result = mockMvc.perform(post(ROUTE)
		.contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(new ZipCodeDTO("01001000"))))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		String jsonAddress = response.getContentAsString();
		
		AddressDTO address = new ObjectMapper().readValue(jsonAddress, AddressDTO.class);
		
		assertEquals("01001-000", address.getCep());
		assertEquals("Praça da Sé", address.getRua());
		assertEquals("lado ímpar", address.getComplemento());
		assertEquals("Sé", address.getBairro());
		assertEquals("São Paulo", address.getCidade());
		assertEquals("SP", address.getEstado());
		assertEquals(7.85, address.getFrete());
	}
	
	@Test
	public void successfulForValidAndExistingZipCodeSouthEast1WithMask() throws JsonProcessingException, Exception {
		MvcResult result = mockMvc.perform(post(ROUTE)
		.contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(new ZipCodeDTO("01001-000"))))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		String jsonAddress = response.getContentAsString();
		
		AddressDTO address = new ObjectMapper().readValue(jsonAddress, AddressDTO.class);
		
		assertEquals("01001-000", address.getCep());
		assertEquals("Praça da Sé", address.getRua());
		assertEquals("lado ímpar", address.getComplemento());
		assertEquals("Sé", address.getBairro());
		assertEquals("São Paulo", address.getCidade());
		assertEquals("SP", address.getEstado());
		assertEquals(7.85, address.getFrete());
	}
	
	@Test
	public void successfulForValidAndExistingZipCodeSouthEast2WithoutMask() throws JsonProcessingException, Exception {
		MvcResult result = mockMvc.perform(post(ROUTE)
		.contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(new ZipCodeDTO("12280113"))))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		String jsonAddress = response.getContentAsString();
		
		AddressDTO address = new ObjectMapper().readValue(jsonAddress, AddressDTO.class);		
		assertEquals("12280-113", address.getCep());
		assertEquals("Avenida Francisca Salles Damasco", address.getRua());
		assertEquals("de 641/642 ao fim", address.getComplemento());
		assertEquals("Jardim São José", address.getBairro());
		assertEquals("Caçapava", address.getCidade());
		assertEquals("SP", address.getEstado());
		assertEquals(7.85, address.getFrete());
	}
	
	@Test
	public void successfulForValidAndExistingZipCodeSouthEast2WithMask() throws JsonProcessingException, Exception {
		MvcResult result = mockMvc.perform(post(ROUTE)
		.contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(new ZipCodeDTO("12280-113"))))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		String jsonAddress = response.getContentAsString();
		
		AddressDTO address = new ObjectMapper().readValue(jsonAddress, AddressDTO.class);		
		assertEquals("12280-113", address.getCep());
		assertEquals("Avenida Francisca Salles Damasco", address.getRua());
		assertEquals("de 641/642 ao fim", address.getComplemento());
		assertEquals("Jardim São José", address.getBairro());
		assertEquals("Caçapava", address.getCidade());
		assertEquals("SP", address.getEstado());
		assertEquals(7.85, address.getFrete());
	}
	
	@Test
	public void successfulForValidAndExistingZipCodeNorthEastWithoutMask() throws Exception {
		MvcResult result = mockMvc.perform(post(ROUTE)
		.contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(new ZipCodeDTO("59042250"))))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		String jsonAddress = response.getContentAsString();
		
		AddressDTO address = new ObjectMapper().readValue(jsonAddress, AddressDTO.class);	
		assertEquals("59042-250", address.getCep());
		assertEquals("Rua Alto da Bela Vista", address.getRua());
		assertEquals("", address.getComplemento());
		assertEquals("Nordeste", address.getBairro());
		assertEquals("Natal", address.getCidade());
		assertEquals("RN", address.getEstado());
		assertEquals(15.98, address.getFrete());
	}
	
	@Test
	public void successfulForValidAndExistingZipCodeNorthEastWithMask() throws Exception {
		MvcResult result = mockMvc.perform(post(ROUTE)
		.contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(new ZipCodeDTO("59042-250"))))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		String jsonAddress = response.getContentAsString();
		
		AddressDTO address = new ObjectMapper().readValue(jsonAddress, AddressDTO.class);			
		assertEquals("59042-250", address.getCep());
		assertEquals("Rua Alto da Bela Vista", address.getRua());
		assertEquals("", address.getComplemento());
		assertEquals("Nordeste", address.getBairro());
		assertEquals("Natal", address.getCidade());
		assertEquals("RN", address.getEstado());
		assertEquals(15.98, address.getFrete());
	}
	
	@Test
	public void successfulForValidAndExistingZipCodeNorthWithoutMask() throws Exception {
		MvcResult result = mockMvc.perform(post(ROUTE)
		.contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(new ZipCodeDTO("69230970"))))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		String jsonAddress = response.getContentAsString();
		
		AddressDTO address = new ObjectMapper().readValue(jsonAddress, AddressDTO.class);			
		assertEquals("69230-970", address.getCep());
		assertEquals("Rua 07 de Setembro", address.getRua());
		assertEquals("100", address.getComplemento());
		assertEquals("Centro", address.getBairro());
		assertEquals("Nova Olinda do Norte", address.getCidade());
		assertEquals("AM", address.getEstado());
		assertEquals(20.83, address.getFrete());
	}
	
	@Test
	public void successfulForValidAndExistingZipCodeNorthWithMask() throws Exception {
		MvcResult result = mockMvc.perform(post(ROUTE)
		.contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(new ZipCodeDTO("69230-970"))))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		String jsonAddress = response.getContentAsString();
		
		AddressDTO address = new ObjectMapper().readValue(jsonAddress, AddressDTO.class);			
		assertEquals("69230-970", address.getCep());
		assertEquals("Rua 07 de Setembro", address.getRua());
		assertEquals("100", address.getComplemento());
		assertEquals("Centro", address.getBairro());
		assertEquals("Nova Olinda do Norte", address.getCidade());
		assertEquals("AM", address.getEstado());
		assertEquals(20.83, address.getFrete());
	}
	
	@Test
	public void successfulForValidAndExistingZipCodeMidWestWithoutMask() throws Exception {
		MvcResult result = mockMvc.perform(post(ROUTE)
		.contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(new ZipCodeDTO("70150900"))))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		String jsonAddress = response.getContentAsString();
		
		AddressDTO address = new ObjectMapper().readValue(jsonAddress, AddressDTO.class);			
		assertEquals("70150-900", address.getCep());
		assertEquals("Praça dos Três Poderes", address.getRua());
		assertEquals("", address.getComplemento());
		assertEquals("Zona Cívico-Administrativa", address.getBairro());
		assertEquals("Brasília", address.getCidade());
		assertEquals("DF", address.getEstado());
		assertEquals(12.50, address.getFrete());
	}
	
	@Test
	public void successfulForValidAndExistingZipCodeMidWestWithMask() throws Exception {
		MvcResult result = mockMvc.perform(post(ROUTE)
		.contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(new ZipCodeDTO("70150-900"))))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		String jsonAddress = response.getContentAsString();
		
		AddressDTO address = new ObjectMapper().readValue(jsonAddress, AddressDTO.class);			
		assertEquals("70150-900", address.getCep());
		assertEquals("Praça dos Três Poderes", address.getRua());
		assertEquals("", address.getComplemento());
		assertEquals("Zona Cívico-Administrativa", address.getBairro());
		assertEquals("Brasília", address.getCidade());
		assertEquals("DF", address.getEstado());
		assertEquals(12.50, address.getFrete());
	}
	
	@Test
	public void successfulForValidAndExistingZipCodeSouthWithoutMask() throws Exception {
		MvcResult result = mockMvc.perform(post(ROUTE)
		.contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(new ZipCodeDTO("90040320"))))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		String jsonAddress = response.getContentAsString();
		
		AddressDTO address = new ObjectMapper().readValue(jsonAddress, AddressDTO.class);		
		assertEquals("90040-320", address.getCep());
		assertEquals("Rua Vieira de Castro", address.getRua());
		assertEquals("", address.getComplemento());
		assertEquals("Farroupilha", address.getBairro());
		assertEquals("Porto Alegre", address.getCidade());
		assertEquals("RS", address.getEstado());
		assertEquals(17.30, address.getFrete());
	}
	
	@Test
	public void successfulForValidAndExistingZipCodeSouthWithMask() throws Exception {
		MvcResult result = mockMvc.perform(post(ROUTE)
		.contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(new ZipCodeDTO("90040-320"))))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		String jsonAddress = response.getContentAsString();
		
		AddressDTO address = new ObjectMapper().readValue(jsonAddress, AddressDTO.class);		
		assertEquals("90040-320", address.getCep());
		assertEquals("Rua Vieira de Castro", address.getRua());
		assertEquals("", address.getComplemento());
		assertEquals("Farroupilha", address.getBairro());
		assertEquals("Porto Alegre", address.getCidade());
		assertEquals("RS", address.getEstado());
		assertEquals(17.30, address.getFrete());
	}
	
	@Test
	public void successfulForValidButInexistentZipCodeWithoutMask() throws JsonProcessingException, Exception {
		String zipCode = "99999999";
		
		MvcResult result = mockMvc.perform(post(ROUTE)
		.contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(new ZipCodeDTO(zipCode))))
        .andDo(print())
        .andExpect(status().isBadRequest())
        .andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		String message = response.getContentAsString();
	
		assertEquals(
				"The zip code " + zipCode + " does not exist",
				message
		);
	}
	
	@Test
	public void successfulForValidButInexistentZipCodeWithMask() throws JsonProcessingException, Exception {
		String zipCode = "99999-999";
		
		MvcResult result = mockMvc.perform(post(ROUTE)
		.contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(new ZipCodeDTO(zipCode))))
        .andDo(print())
        .andExpect(status().isBadRequest())
        .andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		String message = response.getContentAsString();
	
		assertEquals(
				"The zip code " + zipCode + " does not exist",
				message
		);
	}
}
