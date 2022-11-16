package com.tdea.demo.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdea.demo.models.dtos.CompradorInDto;
import com.tdea.demo.models.dtos.CompradorOutDto;
import com.tdea.demo.models.entities.CompradorEntity;
import com.tdea.demo.models.mappers.CompradorMapper;
import com.tdea.demo.repository.CompradorRepository;
import com.tdea.demo.services.CompradorService;

@Service
public class CompradorServicesImpl implements CompradorService{

	@Autowired
	private CompradorRepository compradorRepository;  //-> Acceso al repositorio	
	
	@Autowired
	private CompradorMapper compradorMapper;
	
	@Override
	public CompradorOutDto registrarComprador(CompradorInDto compradorInDto)throws Exception {			
		
		if(compradorInDto.getNombreCompleto().length() > 50){
			throw new Exception("El texto supera el maximo de caracteres.");
		}
		
		if(compradorInDto.getNombreCompleto() == null) {
			throw new Exception("Debe diligenciar el campo: Nombre Completo.");
		}
		if(compradorInDto.getNumeroDocumento() == null) {
			throw new Exception("Debe diligenciar el campo: Numero de documento.");
		}
		if(compradorInDto.getEdad() <= 17 || compradorInDto.getEdad() >= 81){
			throw new Exception("El usuario NO cumple con el rango de edad.");
		}	
		if(compradorInDto.isEsEmpleado() == true) { //-> Si es empleado
			if(compradorInDto.getTipoContrato() == null) {
				throw new Exception("Debe asignar algún contrato válido: Fijo ó Indefinido.");
			}
		}else { //-> En caso de que NO sea empleado
			compradorInDto.setTipoContrato(" "); //-> Va vacío porque no es empleado.
		}		
						
		if(compradorRepository.findByNumeroDocumento(
				compradorInDto.getNumeroDocumento()).isPresent()){
			throw new Exception("El comprador ya se encuentra registrado en la Base de Datos.");
		}
		
		
		//CompradorOutDto dto = new CompradorOutDto();		
		CompradorEntity nuevaEntidad = compradorRepository.save(compradorMapper.dtoToEntity(compradorInDto)); 				
		CompradorOutDto dto = compradorMapper.entityToDto(nuevaEntidad);
		
		return dto;		
	}

	//-> Método para MOSTRAR compradores
		
	@Override
	public List<CompradorEntity> mostrarCompradores() {  //-> La que no dio: mostrarCompradores(CompradorEntity compradorEntity)
		//return (List<CompradorEntity>) compradorRepository.findAllByActivo(compradorEntity.isActivo()); 
		//-> -> Sale error de esta forma, para hacer el filtrado active = false
		return (List<CompradorEntity>) compradorRepository.findAll();
	}
	
	//-> Método para ACTUALIZAR compradores
	
	@Override
	public CompradorEntity actualizarComprador(Long id, CompradorEntity compradorEntity)throws Exception {				
		
		/*
		if( !(compradorRepository.findById(id).isPresent()) ){ //-> Si NO se encuentra en la BDD
			throw new Exception("El usuario NO existe en la Base de Datos.");
		}
		  
		  -> No sé porque, pero antes funcionaba y ahora siempre me sale: 404 Not Found
		
		
		if(compradorEntity.isActivo() == false){
			throw new Exception("El usuario se encuentra inactivo.");
		}
		
		
				if(compradorEntity.getEdad() <= 17 || compradorEntity.getEdad() >= 81){
			throw new Exception("El usuario NO cumple con el rango de edad.");
		}	
		if(compradorEntity.isEsEmpleado() == true) { //-> Si es empleado
			if(compradorEntity.getTipoContrato() == null) {
				throw new Exception("Debe asignar algún contrato válido: Fijo ó Indefinido.");
			}
		}else { //-> En caso de que NO sea empleado
			compradorEntity.setTipoContrato(" "); //-> Va vacío porque no es empleado.
		}	
		
		
		*/
		
		
		CompradorEntity comprador = compradorRepository.findById(id).get();
		comprador.setNombreCompleto(compradorEntity.getNombreCompleto());
		comprador.setEdad(compradorEntity.getEdad()); //Actualizo la edad
		comprador.setEsEmpleado(compradorEntity.isEsEmpleado()); //Actualizo estado de empleado
		comprador.setTipoContrato(compradorEntity.getTipoContrato()); //Actualizo el tipo de contrato
		
		return compradorRepository.save(comprador);
	}
	
	
	//-> Método para INHABILITAR compradores	
	
	@Override
	public CompradorEntity desactivarComprador(Long id, CompradorEntity compradorEntity)throws Exception {
		CompradorEntity comprador = compradorRepository.findById(id).get();
		
		if(comprador.isActivo() == false){ //-> Ya estaba inactivo el comprador
			throw new Exception("El comprador ya está inactivo.");
		}		
		comprador.setActivo(false);
		return compradorRepository.save(comprador);
	}
	
	
	
}//-> FinCompradorServiceImpl
