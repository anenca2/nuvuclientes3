package com.nuvu.clientes.controller;

import com.nuvu.clientes.domain.*;
import com.nuvu.clientes.dto.MensajeDTO;
import com.nuvu.clientes.dto.TipoIdentificacionDTO;
import com.nuvu.clientes.mapper.TipoIdentificacionMapper;
import com.nuvu.clientes.service.TipoIdentificacionService;

import java.util.ArrayList;
import java.util.List;

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
@RequestMapping("/api/tipoIdentificacion")
@CrossOrigin(origins = "*")
public class TipoIdentificacionRestController {
    private static final Logger log = LoggerFactory.getLogger(TipoIdentificacionRestController.class);
    @Autowired
    private TipoIdentificacionService tipoIdentificacionService;
//    @Autowired
//    private TipoIdentificacionMapper tipoIdentificacionMapper;

    @GetMapping(value = "/findById/{idTipoIdentificacion}")
    public ResponseEntity<?> findById(
        @PathVariable("idTipoIdentificacion")
    Long idTipoIdentificacion) {
        log.debug("Request to findById() TipoIdentificacion");

        try {
            TipoIdentificacion tipoIdentificacion = tipoIdentificacionService.findById(idTipoIdentificacion)
                                                                             .get();
            TipoIdentificacionDTO tipoIdentificacionDTO = new 
            		TipoIdentificacionDTO(
            				tipoIdentificacion.getCodTipoIdentificacion(),
            				tipoIdentificacion.getIdTipoIdentificacion(),
            				tipoIdentificacion.getNombre()
            		); 
            return ResponseEntity.ok()
                                 .body(tipoIdentificacionDTO);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() {
        log.debug("Request to findAll() TipoIdentificacion");

        try {
        	List<TipoIdentificacion> listTipoIdentificacion = tipoIdentificacionService.findAll();
        	List<TipoIdentificacionDTO> listTipoIdentificacionDTO = new ArrayList<>();
        	listTipoIdentificacion.forEach(obj -> listTipoIdentificacionDTO.add(
        				new TipoIdentificacionDTO(
        						obj.getCodTipoIdentificacion(),
        						obj.getIdTipoIdentificacion(),
        						obj.getNombre()
        				)
        			));
            return ResponseEntity.ok()
                                 .body(listTipoIdentificacionDTO);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(
        @RequestBody
    TipoIdentificacionDTO tipoIdentificacionDTO) {
        log.debug("Request to save TipoIdentificacion: {}",
            tipoIdentificacionDTO);

        try {
        	TipoIdentificacion tipoIdentificacion = new TipoIdentificacion();
        	tipoIdentificacion.setCodTipoIdentificacion(tipoIdentificacionDTO.getCodTipoIdentificacion());
        	tipoIdentificacion.setNombre(tipoIdentificacionDTO.getNombre());
            tipoIdentificacion = tipoIdentificacionService.save(tipoIdentificacion);

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
    TipoIdentificacionDTO tipoIdentificacionDTO) {
        log.debug("Request to update TipoIdentificacion: {}",
            tipoIdentificacionDTO);

        try {
        	TipoIdentificacion tipoIdentificacion = new TipoIdentificacion();
        	tipoIdentificacion.setCodTipoIdentificacion(tipoIdentificacionDTO.getCodTipoIdentificacion());
        	tipoIdentificacion.setNombre(tipoIdentificacionDTO.getNombre());
        	tipoIdentificacion.setIdTipoIdentificacion(tipoIdentificacionDTO.getIdTipoIdentificacion());
            tipoIdentificacion = tipoIdentificacionService.update(tipoIdentificacion);

            return ResponseEntity.ok()
                                 .body(new MensajeDTO("OK", "Registro actualizado correctamente", true));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete/{idTipoIdentificacion}")
    public ResponseEntity<?> delete(
        @PathVariable("idTipoIdentificacion")
    Long idTipoIdentificacion) throws Exception {
        log.debug("Request to delete TipoIdentificacion");

        try {
            TipoIdentificacion tipoIdentificacion = tipoIdentificacionService.findById(idTipoIdentificacion)
                                                                             .get();

            tipoIdentificacionService.delete(tipoIdentificacion);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(tipoIdentificacionService.count());
    }
}
