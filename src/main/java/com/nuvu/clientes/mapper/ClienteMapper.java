package com.nuvu.clientes.mapper;

import com.nuvu.clientes.domain.Cliente;
import com.nuvu.clientes.dto.ClienteDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
* Mapper Build with MapStruct https://mapstruct.org
* MapStruct is a code generator that greatly simplifies the
* implementation of mappings between Java bean type
* based on a convention over configuration approach.
*/
@Mapper
public interface ClienteMapper {
    @Mapping(source = "tipoIdentificacion.idTipoIdentificacion", target = "idTipoIdentificacion_TipoIdentificacion")
    public ClienteDTO clienteToClienteDTO(Cliente cliente)
        throws Exception;

    @Mapping(source = "idTipoIdentificacion_TipoIdentificacion", target = "tipoIdentificacion.idTipoIdentificacion")
    public Cliente clienteDTOToCliente(ClienteDTO clienteDTO)
        throws Exception;

    public List<ClienteDTO> listClienteToListClienteDTO(List<Cliente> clientes)
        throws Exception;

    public List<Cliente> listClienteDTOToListCliente(
        List<ClienteDTO> clienteDTOs) throws Exception;
}
