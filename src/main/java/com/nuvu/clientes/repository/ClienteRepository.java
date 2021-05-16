package com.nuvu.clientes.repository;

import com.nuvu.clientes.domain.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;


/**
* Interface for   ClienteRepository.
*
*/
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
