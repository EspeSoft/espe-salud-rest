package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.OrientacionSexual;
import com.espe.salud.dto.catalogo.OrientacionSexualDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrientacionSexualMapper {

    @Mapping(source = "codigo", target = "id")
    OrientacionSexualDTO toOrientacionSexualDTO(OrientacionSexual orientacionSexual);

    @InheritInverseConfiguration
    OrientacionSexual toOrientacionSexual(OrientacionSexualDTO dto);

    List<OrientacionSexualDTO> toOrientacionesSexualesDTO(List<OrientacionSexual> orientacionesSexuales);
}
