package com.barbaraport.addressConsultationAPI.dto;

public class AddressDTO extends ZipCodeDTO {
	private String rua;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private double frete;
	
	public AddressDTO () {}
	
	public AddressDTO (
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
