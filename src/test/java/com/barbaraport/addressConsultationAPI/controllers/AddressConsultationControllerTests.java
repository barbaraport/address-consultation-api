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
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class AddressConsultationControllerTests {
	
	@Autowired
    private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void successfulForValidAndExistingZipCode1() throws Exception {
		MvcResult result = mockMvc.perform(post("/v1/consulta-endereco")
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
}
