package com.tdea.demo.controllers.impl;

public class MyCustomExceptions {

	
	MyCustomExceptions(){		
	}
	
	public void validacionesGenerales(String nombre, Integer edad, 
			boolean esEmpleado, String tipoContrato) throws CustomException {		
		
		//-> Valido si el campo nombre está vacio
		if(nombre == null) {
			throw new CustomException("El campo NombreCompleto se encuentra vacío.");
		}
		
		//-> Valido que la edad si sea la permitida
		if(edad <= 17 || edad >= 81){
			throw new CustomException("No cumple con el rango de edad.");
		}		
		
		//-> Valido el tipo de contrato
		if(esEmpleado == true) {
			String tpContrato1 = "Fijo";
			String tpContrato2 = "Indefinido";			
			if(tipoContrato != tpContrato1 || tipoContrato != tpContrato2){
				throw new CustomException("Ingrese un contrato valido: Fijo ó Indefinido.");	
				}
			}else {
				tipoContrato = " ";  //-> Vacío porque NO es empleado
			}
		}


}



