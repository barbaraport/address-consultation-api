package com.barbaraport.addressConsultationAPI.dto;

/**
 * this is the Data Transfer Object that represents the response from the
 * Via Cep API
 *
 * @author Port, B.
 */
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
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

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getSiafi() {
        return siafi;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }

}
