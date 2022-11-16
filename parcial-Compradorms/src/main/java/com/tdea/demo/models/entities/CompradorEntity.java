package com.tdea.demo.models.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Required;

@Entity
@Table (name = "tb_comprador")
public class CompradorEntity implements Serializable{
	
	//-> Atributos de la entidad
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
			
	@Column(length = 50, nullable = false) //-> Maximo 50 caracteres, Nullable: No puedo crear sin este campo
	private String nombreCompleto;
	
	@Column(updatable = false, unique = true, nullable = false) //-> No puedo modificar el documento después de que lo registre. Es obligatoriamente único.
	private String numeroDocumento;
	
	private Integer edad;
	private	boolean activo;
	private	boolean esEmpleado;
	private	String tipoContrato;
	
	@Column(updatable = false) //-> Con esto hago que no sea posible actualizarla.
	private LocalDateTime fecha_Registro;	
	@Column(insertable = false)
	private LocalDateTime fecha_actualizacion;
		
	public CompradorEntity() {
		super();	
	}
	
	public CompradorEntity(Long id, String nombreCompleto, String numeroDocumento, Integer edad, boolean activo,
			boolean esEmpleado, String tipoContrato, LocalDateTime fecha_Registro, LocalDateTime fecha_actualizacion) {		
		this.id = id;
		this.nombreCompleto = nombreCompleto;
		this.numeroDocumento = numeroDocumento;
		this.edad = edad;
		this.activo = activo;
		this.esEmpleado = esEmpleado;
		this.tipoContrato = tipoContrato;
		this.fecha_Registro = fecha_Registro;
		this.fecha_actualizacion = fecha_actualizacion;
	}
	
	
	public CompradorEntity(String nombreCompleto, String numeroDocumento, Integer edad,
			String tipoContrato) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.numeroDocumento = numeroDocumento;
		this.edad = edad;		
		this.tipoContrato = tipoContrato;
	}

	@PrePersist //-> Antes de hacer el insert, tener en cuenta el registro.
	public void prePersist() { //-> Persistencias: Registrar en la BDD		
		activo = true;
		esEmpleado = true; //-> Los hago "por defecto".
		fecha_Registro = LocalDateTime.now();
	}	
	@PreUpdate
	public void preUpdte() {
		fecha_actualizacion = LocalDateTime.now();
	}	
	
	//-> Setter ang Getters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public LocalDateTime getFecha_Registro() {
		return fecha_Registro;
	}
	public void setFecha_Registro(LocalDateTime fecha_Registro) {
		this.fecha_Registro = fecha_Registro;
	}
	public LocalDateTime getFecha_actualizacion() {
		return fecha_actualizacion;
	}
	public void setFecha_actualizacion(LocalDateTime fecha_actualizacion) {
		this.fecha_actualizacion = fecha_actualizacion;
	}
	
	
	
} //-> FinClase entidad Comprador

