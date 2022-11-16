package com.tdea.demo.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;

import com.tdea.demo.models.dtos.CompradorInDto;
import com.tdea.demo.models.dtos.CompradorOutDto;
import com.tdea.demo.models.entities.CompradorEntity;

public interface CompradorController {

	ResponseEntity<?> registrarComprador(CompradorInDto compradorDto);
	
	ResponseEntity<?> actualizarComprador(Long id, CompradorEntity entity);
	
	ResponseEntity<List<CompradorEntity>> mostrarCompradores();
			
}
