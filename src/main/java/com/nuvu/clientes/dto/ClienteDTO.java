package com.nuvu.clientes.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ClienteDTO.class);
    private String apellidos;
    private String codPostal;
    private String correo;
    private String direccion;
    private Date fechaNacimiento;
    private Long idCliente;
    private Long identificacion;
    private String nombres;
    private String sexo;
    private String telefono1;
    private String telefono2;
    private Long idTipoIdentificacion_TipoIdentificacion;
    private Long nroCuenta;
    

    public ClienteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

	public ClienteDTO(String apellidos, String codPostal, String correo, String direccion, Date fechaNacimiento,
			Long idCliente, Long identificacion, String nombres, String sexo, String telefono1, String telefono2,
			Long idTipoIdentificacion_TipoIdentificacion, Long nroCuenta) {
		super();
		this.apellidos = apellidos;
		this.codPostal = codPostal;
		this.correo = correo;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.idCliente = idCliente;
		this.identificacion = identificacion;
		this.nombres = nombres;
		this.sexo = sexo;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.idTipoIdentificacion_TipoIdentificacion = idTipoIdentificacion_TipoIdentificacion;
		this.nroCuenta = nroCuenta;
	}



	public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public Long getIdTipoIdentificacion_TipoIdentificacion() {
        return idTipoIdentificacion_TipoIdentificacion;
    }

    public void setIdTipoIdentificacion_TipoIdentificacion(
        Long idTipoIdentificacion_TipoIdentificacion) {
        this.idTipoIdentificacion_TipoIdentificacion = idTipoIdentificacion_TipoIdentificacion;
    }
    
    public Long getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(Long nroCuenta) {
		this.nroCuenta = nroCuenta;
	}



	@Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());

            return super.toString();
        }
    }
}
