package com.tdea.demo.controllers.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tdea.demo.controllers.CompradorController;
import com.tdea.demo.models.dtos.CompradorInDto;
import com.tdea.demo.models.dtos.CompradorOutDto;
import com.tdea.demo.models.entities.CompradorEntity;
import com.tdea.demo.services.CompradorService;

@RestController
public class CompradorControllerImpl implements CompradorController{

	@Autowired
	private CompradorService compradorService; 

	
	//-> Método para CREAR compradores
	
	@Override
	@PostMapping("/")
	public ResponseEntity<?> registrarComprador(@RequestBody CompradorInDto compradorDto){
		CompradorOutDto dto;
		
		MyCustomExceptions h = new MyCustomExceptions();
		//-> Para poder usar las validaciones generales.		
		
		try {							
			
			dto = compradorService.registrarComprador(compradorDto);
			
			/*	Esto NO me dio, pero sería chvere mirarlo con el profesor.
			h.validacionesGenerales(compradorDto.getNombreCompleto(), compradorDto.getEdad(),
			 compradorDto.isEsEmpleado(), compradorDto.getTipoContrato());
			 */					
			
		} catch (Exception e) {
			return new ResponseEntity<String>("No cumple con las condiciones para registrar"
					+ " o ya se encuentra registrado en la Base de Datos. ", HttpStatus.BAD_REQUEST);
			//-> Pongo Bad_Querest porque no cumple con la edad o la cédula ya existe en la BDD.
		}
		return new ResponseEntity<CompradorOutDto>(dto, HttpStatus.CREATED);
	}

	
	//-> Método para ACTUALIZAR compradores
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarComprador(@PathVariable Long id, @RequestBody CompradorEntity compradorEntity){
		CompradorEntity nuevoCompradorEntity = null;
		try {
			nuevoCompradorEntity = compradorService.actualizarComprador(id, compradorEntity);
		} catch (Exception e) {
			return new ResponseEntity<>(nuevoCompradorEntity, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CompradorEntity>(nuevoCompradorEntity, HttpStatus.OK);
	}
	
	//-> Método para MOSTRAR compradores
	
	@GetMapping("/")	
	public ResponseEntity<List<CompradorEntity>> mostrarCompradores() {
		List<CompradorEntity> compradores = compradorService.mostrarCompradores();
		return new ResponseEntity<List<CompradorEntity>>(compradores, HttpStatus.OK);
	}
	
	//-> Método para INHABILITAR compradores
	
	@PostMapping("/{id}")
	public ResponseEntity<?> desactivarComprador(@PathVariable Long id, CompradorEntity compradorEntity){			
		CompradorEntity nuevoCompradorEntity;
		try {
			 nuevoCompradorEntity = compradorService.desactivarComprador(id, compradorEntity);
		}catch(Exception e){
			return new ResponseEntity<String>("Ya se encuentra inactivo ó no existe el comprador.", HttpStatus.BAD_REQUEST);
		}
				
		return new ResponseEntity<CompradorEntity>(nuevoCompradorEntity, HttpStatus.OK);
	}

	
} //-> Fin clase CompradoreController
