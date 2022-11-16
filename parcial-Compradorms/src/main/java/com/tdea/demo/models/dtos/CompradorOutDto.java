package com.tdea.demo.models.dtos;

public class CompradorOutDto {

	private String nombreCompleto;
	private String esEmpleado;
		
	public CompradorOutDto() {
		super();		
	}
		
	public CompradorOutDto(String nombreCompleto, String esEmpleado) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.esEmpleado = esEmpleado;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getEsEmpleado() {
		return esEmpleado;
	}
	public void setEsEmpleado(String esEmpleado) {
		this.esEmpleado = esEmpleado;
	}
	
}
