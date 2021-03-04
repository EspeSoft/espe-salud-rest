package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.Plurinacionalidad;
import com.espe.salud.dto.catalogo.PlurinacionalidadDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlurinacionalidadMapper {
    @Mapping(source = "codigo", target = "id")
    PlurinacionalidadDTO toPlurinacionalidadDTO(Plurinacionalidad plurinacionalidad);

    @InheritInverseConfiguration
    Plurinacionalidad toPlurinacionalidad(PlurinacionalidadDTO dto);

    List<PlurinacionalidadDTO> toPlurinacionalidadesDTO(List<Plurinacionalidad> plurinacionalidades);
}
