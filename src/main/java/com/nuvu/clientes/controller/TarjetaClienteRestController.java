package com.nuvu.clientes.controller;

import com.nuvu.clientes.domain.*;
import com.nuvu.clientes.dto.ClienteDTO;
import com.nuvu.clientes.dto.MensajeDTO;
import com.nuvu.clientes.dto.TarjetaClienteDTO;
import com.nuvu.clientes.mapper.TarjetaClienteMapper;
import com.nuvu.clientes.service.ClienteService;
import com.nuvu.clientes.service.TarjetaClienteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/tarjetaCliente")
@CrossOrigin(origins = "*")
public class TarjetaClienteRestController {
    private static final Logger log = LoggerFactory.getLogger(TarjetaClienteRestController.class);
    @Autowired
    private TarjetaClienteService tarjetaClienteService;
    @Autowired
    private ClienteService clienteService;
//    @Autowired
//    private TarjetaClienteMapper tarjetaClienteMapper;

    @GetMapping(value = "/findById//{nroTarjeta}/{idCliente}")
    public ResponseEntity<?> findById(
        @PathVariable("nroTarjeta")
    Long nroTarjeta, @PathVariable("idCliente")
    Long idCliente) {
        log.debug("Request to findById() TarjetaCliente");

        try {
            TarjetaClienteId id = new TarjetaClienteId();

            id.setNroTarjeta(nroTarjeta);
            id.setIdCliente(idCliente);

            TarjetaCliente tarjetaCliente = tarjetaClienteService.findById(id)
                                                                 .get();
            TarjetaClienteDTO tarjetaClienteDTO = new TarjetaClienteDTO();
            tarjetaClienteDTO.setIdCliente((tarjetaCliente.getCliente() != null) ? tarjetaCliente.getCliente().getIdCliente() : null);
            tarjetaClienteDTO.setIdCliente_Cliente((tarjetaCliente.getCliente() != null) ? tarjetaCliente.getCliente().getIdCliente() : null);
            tarjetaClienteDTO.setNroTarjeta((tarjetaCliente.getId() != null) ? tarjetaCliente.getId().getNroTarjeta() : null);
            return ResponseEntity.ok()
                                 .body(tarjetaClienteDTO);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() {
        log.debug("Request to findAll() TarjetaCliente");

        try {
        	List<TarjetaCliente> listTarjeta = tarjetaClienteService.findAll();
        	List<TarjetaClienteDTO> listClienteDTO = new ArrayList<>();
        	listTarjeta.forEach(obj -> listClienteDTO.add(
        			new TarjetaClienteDTO(obj.getId().getNroTarjeta(), 
        								  obj.getCliente().getIdCliente(), 
        								  obj.getId().getIdCliente())
        			));
            return ResponseEntity.ok()
                                 .body(listClienteDTO);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(
        @RequestBody
    TarjetaClienteDTO tarjetaClienteDTO) {
        log.debug("Request to save TarjetaCliente: {}", tarjetaClienteDTO);

        try {
            TarjetaCliente tarjetaCliente = new TarjetaCliente();
            Optional<Cliente> cliente = clienteService.findById(tarjetaClienteDTO.getIdCliente());
        	tarjetaCliente.setCliente((cliente.isPresent()) ? cliente.get() : null);
        	
        	TarjetaClienteId tarjetaClienteId = new TarjetaClienteId();
            tarjetaClienteId.setIdCliente((cliente.isPresent()) ? cliente.get().getIdCliente() : null);
            tarjetaClienteId.setNroTarjeta(tarjetaClienteDTO.getNroTarjeta());
            tarjetaCliente.setId(tarjetaClienteId);
            tarjetaCliente = tarjetaClienteService.save(tarjetaCliente);

            return ResponseEntity.ok()
                                 .body(new MensajeDTO("OK", "Registro insertado correctamente", true));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(
        @RequestBody
    TarjetaClienteDTO tarjetaClienteDTO) {
        log.debug("Request to update TarjetaCliente: {}", tarjetaClienteDTO);

        try {
        	TarjetaCliente tarjetaCliente = new TarjetaCliente();
            Optional<Cliente> cliente = clienteService.findById(tarjetaClienteDTO.getIdCliente());
        	tarjetaCliente.setCliente((cliente.isPresent()) ? cliente.get() : null);
        	
        	TarjetaClienteId tarjetaClienteId = new TarjetaClienteId();
            tarjetaClienteId.setIdCliente((cliente.isPresent()) ? cliente.get().getIdCliente() : null);
            tarjetaClienteId.setNroTarjeta(tarjetaClienteDTO.getNroTarjeta());
            tarjetaCliente.setId(tarjetaClienteId);
            tarjetaCliente = tarjetaClienteService.update(tarjetaCliente);

            return ResponseEntity.ok()
                                 .body(new MensajeDTO("OK", "Registro actualizado correctamente", true));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete//{nroTarjeta}/{idCliente}")
    public ResponseEntity<?> delete(
        @PathVariable("nroTarjeta")
    Long nroTarjeta, @PathVariable("idCliente")
    Long idCliente) throws Exception {
        log.debug("Request to delete TarjetaCliente");

        try {
            TarjetaClienteId id = new TarjetaClienteId();

            id.setNroTarjeta(nroTarjeta);
            id.setIdCliente(idCliente);

            TarjetaCliente tarjetaCliente = tarjetaClienteService.findById(id)
                                                                 .get();

            tarjetaClienteService.delete(tarjetaCliente);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(tarjetaClienteService.count());
    }
}
