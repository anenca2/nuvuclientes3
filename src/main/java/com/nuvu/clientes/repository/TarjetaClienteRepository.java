package com.nuvu.clientes.repository;

import com.nuvu.clientes.domain.TarjetaCliente;
import com.nuvu.clientes.domain.TarjetaClienteId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


/**
* Interface for   TarjetaClienteRepository.
*
*/
@Repository
public interface TarjetaClienteRepository extends JpaRepository<TarjetaCliente, TarjetaClienteId>{

	@Query(value = "select tacli.nro_tarjeta from tarjeta_cliente tacli "
			+ " join cliente cli on cli.id_cliente = tacli.id_cliente where  "
			+ " tacli.id_cliente = :idCliente FETCH FIRST 1 ROWS ONLY", nativeQuery = true)
	public Long findByIdClienteNroCuenta(@Param("idCliente")Long idCliente);
}
