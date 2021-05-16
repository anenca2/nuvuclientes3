package com.nuvu.clientes.repository;

import com.nuvu.clientes.domain.TipoIdentificacion;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;


/**
* Interface for   TipoIdentificacionRepository.
*
*/
public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacion, Long> {
}
