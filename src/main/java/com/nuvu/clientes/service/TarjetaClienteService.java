package com.nuvu.clientes.service;

import com.nuvu.clientes.domain.TarjetaCliente;
import com.nuvu.clientes.domain.TarjetaClienteId;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface TarjetaClienteService extends GenericService<TarjetaCliente, TarjetaClienteId> {
	
	public Long findByIdClienteNroCuenta(Long idCliente);
}
