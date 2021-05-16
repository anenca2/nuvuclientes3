package com.nuvu.clientes.mapper;

import com.nuvu.clientes.domain.TipoIdentificacion;
import com.nuvu.clientes.dto.TipoIdentificacionDTO;

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
public interface TipoIdentificacionMapper {
    public TipoIdentificacionDTO tipoIdentificacionToTipoIdentificacionDTO(
        TipoIdentificacion tipoIdentificacion) throws Exception;

    public TipoIdentificacion tipoIdentificacionDTOToTipoIdentificacion(
        TipoIdentificacionDTO tipoIdentificacionDTO) throws Exception;

    public List<TipoIdentificacionDTO> listTipoIdentificacionToListTipoIdentificacionDTO(
        List<TipoIdentificacion> tipoIdentificacions) throws Exception;

    public List<TipoIdentificacion> listTipoIdentificacionDTOToListTipoIdentificacion(
        List<TipoIdentificacionDTO> tipoIdentificacionDTOs)
        throws Exception;
}
