package com.tdea.demo.models.mappers;

import org.springframework.stereotype.Component;

import com.tdea.demo.models.dtos.CompradorInDto;
import com.tdea.demo.models.dtos.CompradorOutDto;
import com.tdea.demo.models.entities.CompradorEntity;

@Component
public class CompradorMapper implements EntityMapper<CompradorEntity, CompradorOutDto, CompradorInDto>{

	@Override
	public CompradorEntity dtoToEntity(CompradorInDto dto) {
		return new CompradorEntity(dto.getNombreCompleto(), dto.getNumeroDocumento(), 
				dto.getEdad(), dto.getTipoContrato());
	}

	@Override
	public CompradorOutDto entityToDto(CompradorEntity entity) {
		CompradorOutDto dto = new CompradorOutDto();
		dto.setNombreCompleto("Nombre del comprador/empleado: " + entity.getNombreCompleto());
		dto.setEsEmpleado("El tipo de contrato es: " + entity.getTipoContrato());		
		return dto;		
	}

	
	
}
