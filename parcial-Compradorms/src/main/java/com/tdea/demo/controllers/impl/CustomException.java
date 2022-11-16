package com.tdea.demo.controllers.impl;

public class CustomException extends Exception{ //-> Exception es la clase padre de todas las exepciones.

	public static final long serialVersionUID = 700L; //-> Es obligatorio para que pueda funcionar correctamente. 
	//-> Es un ID para el RunTime de Java
		
	public CustomException(String mensaje) { 
		super(mensaje);		
	}
	
}
