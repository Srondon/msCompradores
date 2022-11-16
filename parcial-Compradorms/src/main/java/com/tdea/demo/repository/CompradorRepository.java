package com.tdea.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.tdea.demo.models.entities.CompradorEntity;

public interface CompradorRepository extends CrudRepository<CompradorEntity, Long>{
	
	/*	 
	 *  Consulto un usuario por el numero de documento.
	 * 
	 * */	
	Optional<CompradorEntity> findByNumeroDocumento(String numeroDocumento);
	//-> Optional: La entidad puede llegar o no.
	
	List<CompradorEntity> findAllByActivo(boolean activo);
	//-> Consulta que me trae todos si está activos.
	
	
}
