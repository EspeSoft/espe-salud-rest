package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoDiscapacidad;
import com.espe.salud.dto.catalogo.TipoDiscapacidadDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoDiscapacidadMapper {

    @Mapping(source = "codigo", target = "id")
    TipoDiscapacidadDTO toTipoDiscapacidadDTO(TipoDiscapacidad tipoDiscapacidad);

    List<TipoDiscapacidadDTO> toTiposDiscapacidadDTO(List<TipoDiscapacidad> tiposDiscapacidad);

    @InheritInverseConfiguration
    TipoDiscapacidad toTipoDiscapacidad(TipoDiscapacidadDTO dto);
}
