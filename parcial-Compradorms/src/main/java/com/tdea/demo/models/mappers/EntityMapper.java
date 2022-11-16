package com.tdea.demo.models.mappers;

public interface EntityMapper<Entity, OutDto, InDto> {

	Entity dtoToEntity(InDto inDto);
	
	OutDto entityToDto(Entity entity);
	
	
}
