package com.nuvu.clientes.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class MensajeDTO {
	
	private String codigo;	
	private String mensaje;
	private boolean errores;
	
	public MensajeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public MensajeDTO(String codigo, String mensaje, boolean errores) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.errores = errores;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public boolean isErrores() {
		return errores;
	}
	public void setErrores(boolean errores) {
		this.errores = errores;
	}
	
	

}
