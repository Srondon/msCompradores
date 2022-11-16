package com.tdea.demo.services;

import java.util.List;
import com.tdea.demo.models.dtos.CompradorInDto;
import com.tdea.demo.models.dtos.CompradorOutDto;
import com.tdea.demo.models.entities.CompradorEntity;

public interface CompradorService {
		
	CompradorOutDto registrarComprador(CompradorInDto compradorInDto) throws Exception;
	
	CompradorEntity actualizarComprador(Long id, CompradorEntity compradorEntity) throws Exception;
	
	List<CompradorEntity> mostrarCompradores();	
	
	CompradorEntity desactivarComprador(Long id, CompradorEntity compradorEntity) throws Exception;
	
	
	
}
