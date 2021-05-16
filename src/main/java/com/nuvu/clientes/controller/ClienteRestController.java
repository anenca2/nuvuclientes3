package com.nuvu.clientes.controller;

import com.nuvu.clientes.domain.*;
import com.nuvu.clientes.dto.ClienteDTO;
import com.nuvu.clientes.dto.MensajeDTO;
import com.nuvu.clientes.mapper.ClienteMapper;
import com.nuvu.clientes.service.ClienteService;
import com.nuvu.clientes.service.TarjetaClienteService;
import com.nuvu.clientes.service.TipoIdentificacionService;
import com.nuvu.clientes.utility.Constantes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
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
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*")
public class ClienteRestController {
    private static final Logger log = LoggerFactory.getLogger(ClienteRestController.class);
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private TarjetaClienteService tarjetaClienteService;
    @Autowired
    private TipoIdentificacionService tipoIdentificacionService;
//    @Autowired
//    private ClienteMapper clienteMapper;

    @Secured("ROLE_USER")
    @GetMapping(value = "/findById/{idCliente}")
    public ResponseEntity<?> findById(@AuthenticationPrincipal User user, @PathVariable("idCliente")
    Long idCliente) {
        log.debug("Request to findById() Cliente");
        ClienteDTO clienteDTO = new ClienteDTO();
        try {
            Cliente cliente = clienteService.findById(idCliente).get();
            
            clienteDTO.setApellidos(cliente.getApellidos());
            clienteDTO.setCodPostal(cliente.getCodPostal());
            clienteDTO.setCorreo(cliente.getCorreo());
            clienteDTO.setDireccion(cliente.getDireccion());
            clienteDTO.setFechaNacimiento(cliente.getFechaNacimiento());
            clienteDTO.setIdCliente(cliente.getIdCliente());
            clienteDTO.setIdentificacion(cliente.getIdentificacion());
            clienteDTO.setIdTipoIdentificacion_TipoIdentificacion(cliente.getTipoIdentificacion().getIdTipoIdentificacion());
            clienteDTO.setNombres(cliente.getNombres());
            clienteDTO.setSexo(cliente.getSexo());
            clienteDTO.setTelefono1(cliente.getTelefono1());
            clienteDTO.setTelefono2(cliente.getTelefono2());
            return ResponseEntity.ok()
                                 .body(clienteDTO);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(Constantes.ERR_MSG);
        }
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll(@AuthenticationPrincipal User user) {
        log.debug("Request to findAll() Cliente");
        List<ClienteDTO> listClienteDTO = new ArrayList<>();
        try {
        	List<Cliente> listCliente = clienteService.findAll();
        	listCliente.forEach(obj -> listClienteDTO.add(
        				new ClienteDTO(obj.getApellidos(),
        							   obj.getCodPostal(),
        							   obj.getCorreo(),
        							   obj.getDireccion(),
        							   obj.getFechaNacimiento(),
        							   obj.getIdCliente(),
        							   obj.getIdentificacion(),
        							   obj.getNombres(),
        							   obj.getSexo(),
        							   obj.getTelefono1(),
        							   obj.getTelefono2(), 
        							   obj.getTipoIdentificacion().getIdTipoIdentificacion(),
        							   tarjetaClienteService.findByIdClienteNroCuenta(obj.getIdCliente())
        							   )//Cierre DTO
        							    
        			));
            return ResponseEntity.ok()
                                 .body(listClienteDTO);
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(Constantes.ERR_MSG);
        }
    }

    @Secured("ROLE_ADMIN")
    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@AuthenticationPrincipal User user, @RequestBody
    ClienteDTO clienteDTO) {
        log.debug("Request to save Cliente: {}", clienteDTO);

        try {
            Cliente cliente = new Cliente();
            cliente.setApellidos(clienteDTO.getApellidos());
        	cliente.setCodPostal(clienteDTO.getCodPostal());
        	cliente.setCorreo(clienteDTO.getCorreo());
        	cliente.setDireccion(clienteDTO.getDireccion());
        	cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
        	cliente.setIdentificacion(clienteDTO.getIdentificacion());
        	cliente.setNombres(clienteDTO.getNombres());
        	cliente.setSexo(clienteDTO.getSexo());
        	cliente.setTelefono1(clienteDTO.getTelefono1());
        	cliente.setTelefono2(clienteDTO.getTelefono2());
        	Optional<TipoIdentificacion> tipo = tipoIdentificacionService.findById(clienteDTO.getIdTipoIdentificacion_TipoIdentificacion());
        	cliente.setTipoIdentificacion((tipo.isPresent()) ? tipo.get() : null);
            cliente = clienteService.save(cliente);
            
            if(cliente != null && cliente.getIdCliente() != null) {
            	TarjetaCliente tarjetaCliente = new TarjetaCliente();
            	tarjetaCliente.setCliente(cliente);
            	
            	TarjetaClienteId tarjetaClienteId = new TarjetaClienteId();
                tarjetaClienteId.setIdCliente(cliente.getIdCliente());
                tarjetaClienteId.setNroTarjeta(clienteDTO.getNroCuenta());
                tarjetaCliente.setId(tarjetaClienteId);
                tarjetaCliente = tarjetaClienteService.save(tarjetaCliente);
            }

            return ResponseEntity.ok()
                                 .body(new MensajeDTO("OK", "Registro insertado correctamente", true));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(Constantes.ERR_MSG);
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody
    ClienteDTO clienteDTO) {
        log.debug("Request to update Cliente: {}", clienteDTO);

        try {
            Cliente cliente = new Cliente();
            cliente.setApellidos(clienteDTO.getApellidos());
        	cliente.setCodPostal(clienteDTO.getCodPostal());
        	cliente.setCorreo(clienteDTO.getCorreo());
        	cliente.setDireccion(clienteDTO.getDireccion());
        	cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
        	cliente.setIdentificacion(clienteDTO.getIdentificacion());
        	cliente.setNombres(clienteDTO.getNombres());
        	cliente.setSexo(clienteDTO.getSexo());
        	cliente.setTelefono1(clienteDTO.getTelefono1());
        	cliente.setTelefono2(clienteDTO.getTelefono2());
        	cliente.setIdCliente(clienteDTO.getIdCliente());
        	Optional<TipoIdentificacion> tipo = tipoIdentificacionService.findById(clienteDTO.getIdTipoIdentificacion_TipoIdentificacion());
        	cliente.setTipoIdentificacion((tipo.isPresent()) ? tipo.get() : null);
            cliente = clienteService.update(cliente);
            
            if(cliente != null && cliente.getIdCliente() != null) {
            	TarjetaCliente tarjetaCliente = new TarjetaCliente();
            	tarjetaCliente.setCliente(cliente);
            	
            	TarjetaClienteId tarjetaClienteId = new TarjetaClienteId();
                tarjetaClienteId.setIdCliente(cliente.getIdCliente());
                tarjetaClienteId.setNroTarjeta(clienteDTO.getNroCuenta());
                tarjetaCliente.setId(tarjetaClienteId);
                tarjetaCliente = tarjetaClienteService.save(tarjetaCliente);
            }

            return ResponseEntity.ok()
                                 .body(new MensajeDTO("OK", "Registro actualizado correctamente", true));
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(Constantes.ERR_MSG);
        }
    }

    @DeleteMapping(value = "/delete/{idCliente}")
    public ResponseEntity<?> delete(@PathVariable("idCliente")
    Long idCliente) throws Exception {
        log.debug("Request to delete Cliente");

        try {
            Cliente cliente = clienteService.findById(idCliente).get();

            clienteService.delete(cliente);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);

            return ResponseEntity.badRequest().body(Constantes.ERR_MSG);
        }
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(clienteService.count());
    }
}
