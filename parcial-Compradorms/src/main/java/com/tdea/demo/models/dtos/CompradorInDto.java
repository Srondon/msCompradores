package com.tdea.demo.models.dtos;


public class CompradorInDto {
	
	private String nombreCompleto;	
	private String numeroDocumento;	
	private Integer edad;
	private	boolean activo;
	private	boolean esEmpleado;
	private	String tipoContrato;
		
	public CompradorInDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CompradorInDto(String nombreCompleto, String numeroDocumento, Integer edad, boolean activo,
			boolean esEmpleado, String tipoContrato) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.numeroDocumento = numeroDocumento;
		this.edad = edad;
		this.activo = activo;
		this.esEmpleado = esEmpleado;
		this.tipoContrato = tipoContrato;
	}


	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public boolean isEsEmpleado() {
		return esEmpleado;
	}
	public void setEsEmpleado(boolean esEmpleado) {
		this.esEmpleado = esEmpleado;
	}
	public String getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	
	
	
}
