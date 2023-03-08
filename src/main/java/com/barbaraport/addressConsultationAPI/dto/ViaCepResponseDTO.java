package com.barbaraport.addressConsultationAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * this is the Data Transfer Object that represents the response from the
 * Via Cep API
 *
 * @author Port, B.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ViaCepResponseDTO {
    /**
     * zip code
     */
    private String cep;

    /**
     * street
     */
    private String logradouro;

    /**
     * additional information
     */
    private String complemento;

    /**
     * neighbourhood
     */
    private String bairro;

    /**
     * city
     */
    private String localidade;

    /**
     * federated state
     */
    private String uf;

    /**
     * some code from the
     * "Instituto Brasileiro de Geografia e Estatística"
     */
    private String ibge;

    /**
     * some code
     */
    private String gia;

    /**
     * area (city or state) code to make phone calls
     */
    private String ddd;

    /**
     * some code
     */
    private String siafi;

}
