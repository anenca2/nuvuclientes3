package com.nuvu.clientes.service;

import com.nuvu.clientes.domain.*;
import com.nuvu.clientes.exception.*;
import com.nuvu.clientes.repository.*;
import com.nuvu.clientes.utility.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.*;

import java.util.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springframework.data.domain.Example;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service
public class TarjetaClienteServiceImpl implements TarjetaClienteService {
    private static final Logger log = LoggerFactory.getLogger(TarjetaClienteServiceImpl.class);
    @Autowired
    private TarjetaClienteRepository tarjetaClienteRepository;
    @Autowired
    private Validator validator;

    @Override
    public void validate(TarjetaCliente tarjetaCliente)
        throws Exception {
        try {
            Set<ConstraintViolation<TarjetaCliente>> constraintViolations = validator.validate(tarjetaCliente);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<TarjetaCliente> constraintViolation : constraintViolations) {
                    strMessage.append(constraintViolation.getPropertyPath()
                                                         .toString());
                    strMessage.append(" - ");
                    strMessage.append(constraintViolation.getMessage());
                    strMessage.append(". \n");
                }

                throw new Exception(strMessage.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return tarjetaClienteRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TarjetaCliente> findAll() {
        log.debug("finding all TarjetaCliente instances");

        return tarjetaClienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public TarjetaCliente save(TarjetaCliente entity) throws Exception {
        log.debug("saving TarjetaCliente instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "TarjetaCliente");
            }

            validate(entity);

            if (tarjetaClienteRepository.findById(entity.getId()).isPresent()) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            return tarjetaClienteRepository.save(entity);
        } catch (Exception e) {
            log.error("save TarjetaCliente failed", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(TarjetaCliente entity) throws Exception {
        log.debug("deleting TarjetaCliente instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("TarjetaCliente");
        }

        if (entity.getId().getNroTarjeta() == null) {
            throw new ZMessManager().new EmptyFieldException("nroTarjeta");
        }

        if (entity.getId().getIdCliente() == null) {
            throw new ZMessManager().new EmptyFieldException("idCliente");
        }

        try {
            tarjetaClienteRepository.deleteById(entity.getId());
            log.debug("delete TarjetaCliente successful");
        } catch (Exception e) {
            log.error("delete TarjetaCliente failed", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteById(TarjetaClienteId id) throws Exception {
        log.debug("deleting TarjetaCliente instance");

        if (id == null) {
            throw new ZMessManager().new EmptyFieldException("id");
        }

        if (tarjetaClienteRepository.findById(id).isPresent()) {
            delete(tarjetaClienteRepository.findById(id).get());
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public TarjetaCliente update(TarjetaCliente entity)
        throws Exception {
        log.debug("updating TarjetaCliente instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "TarjetaCliente");
            }

            validate(entity);

            return tarjetaClienteRepository.save(entity);
        } catch (Exception e) {
            log.error("update TarjetaCliente failed", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TarjetaCliente> findById(TarjetaClienteId id)
        throws Exception {
        log.debug("getting TarjetaCliente instance");

        return tarjetaClienteRepository.findById(id);
    }

	@Override
	public Long findByIdClienteNroCuenta(Long idCliente) {
		Long nroCuenta = tarjetaClienteRepository.findByIdClienteNroCuenta(idCliente);
		return (nroCuenta != null) ? nroCuenta : 0;
	}
}
