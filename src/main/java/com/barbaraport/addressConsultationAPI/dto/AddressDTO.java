package com.barbaraport.addressConsultationAPI.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * this is the Data Transfer Object that represents the successful response from the
 * Address Consultation API
 *
 * @author Port, B.
 */
@ApiModel(description = "Response body when the address is successfully found")
public class AddressDTO extends ZipCodeDTO {

    /**
     * street
     */
    @ApiModelProperty(notes = "Street", example = "Praça da Sé", required = true)
    private String rua;

    /**
     * additional information. it may be empty
     */
    @ApiModelProperty(notes = "Additional information", example = "lado ímpar", required = true)
    private String complemento;

    /**
     * neighbourhood
     */
    @ApiModelProperty(notes = "Neighbourhood", example = "Sé", required = true)
    private String bairro;

    /**
     * city
     */
    @ApiModelProperty(notes = "City", example = "São Paulo", required = true)
    private String cidade;

    /**
     * state
     */
    @ApiModelProperty(notes = "State", example = "SP", required = true)
    private String estado;

    /**
     * fare (transportation cost)
     */
    @ApiModelProperty(notes = "Fare", example = "7.85", required = true)
    private double frete;

    /**
     * empty constructor
     */
    public AddressDTO() {
    }

    /**
     * all arguments constructor
     *
     * @param cep         zip code
     * @param rua         street
     * @param complemento additional information
     * @param bairro      neighbourhood
     * @param cidade      city
     * @param estado      state
     * @param frete       fare (transportation cost)
     */
    public AddressDTO(
            String cep,
            String rua,
            String complemento,
            String bairro,
            String cidade,
            String estado,
            double frete) {
        super(cep);

        this.rua = rua;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.frete = frete;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

}
