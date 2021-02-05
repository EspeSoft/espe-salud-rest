package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoFisico;
import com.espe.salud.dto.catalogo.RiesgoFisicoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RiesgoFisicoMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    RiesgoFisicoDTO toRiesgoFisicoDTO(RiesgoFisico riesgoFisico);

    List<RiesgoFisicoDTO> toRiesgosFisicosDTO(List<RiesgoFisico> riesgosFisicos);

    @InheritInverseConfiguration
    RiesgoFisico toRiesgoFisico(RiesgoFisicoDTO dto);
}
