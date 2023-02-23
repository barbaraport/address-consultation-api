package com.barbaraport.addressConsultationAPI.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

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
		mockMvc.perform(post("/v1/consulta-endereco")
		.contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(new ZipCodeDTO("01001000"))))
        .andDo(print())
        .andExpect(status().isOk());
	}
}
