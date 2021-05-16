package com.nuvu.clientes.mapper;

import com.nuvu.clientes.domain.TarjetaCliente;
import com.nuvu.clientes.dto.TarjetaClienteDTO;

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
public interface TarjetaClienteMapper {
    @Mapping(source = "cliente.idCliente", target = "idCliente_Cliente")
    public TarjetaClienteDTO tarjetaClienteToTarjetaClienteDTO(
        TarjetaCliente tarjetaCliente) throws Exception;

    @Mapping(source = "idCliente_Cliente", target = "cliente.idCliente")
    public TarjetaCliente tarjetaClienteDTOToTarjetaCliente(
        TarjetaClienteDTO tarjetaClienteDTO) throws Exception;

    public List<TarjetaClienteDTO> listTarjetaClienteToListTarjetaClienteDTO(
        List<TarjetaCliente> tarjetaClientes) throws Exception;

    public List<TarjetaCliente> listTarjetaClienteDTOToListTarjetaCliente(
        List<TarjetaClienteDTO> tarjetaClienteDTOs) throws Exception;
}
