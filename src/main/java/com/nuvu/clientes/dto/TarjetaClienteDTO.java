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
public class TarjetaClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TarjetaClienteDTO.class);
    private Long nroTarjeta;
    private Long idCliente;
    private Long idCliente_Cliente;

    
    
    public TarjetaClienteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TarjetaClienteDTO(Long nroTarjeta, Long idCliente, Long idCliente_Cliente) {
		super();
		this.nroTarjeta = nroTarjeta;
		this.idCliente = idCliente;
		this.idCliente_Cliente = idCliente_Cliente;
	}

	public Long getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(Long nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdCliente_Cliente() {
        return idCliente_Cliente;
    }

    public void setIdCliente_Cliente(Long idCliente_Cliente) {
        this.idCliente_Cliente = idCliente_Cliente;
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
