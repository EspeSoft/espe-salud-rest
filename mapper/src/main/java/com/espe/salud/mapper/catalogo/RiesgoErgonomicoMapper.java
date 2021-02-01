package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoErgonomico;
import com.espe.salud.dto.catalogo.RiesgoErgonomicoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RiesgoErgonomicoMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    RiesgoErgonomicoDTO toRiesgoErgonomicoDTO(RiesgoErgonomico riesgoErgonomico);

    List<RiesgoErgonomicoDTO> toRiesgosErgonomicosDTO(List<RiesgoErgonomico> riesgosErgonomicos);

    @InheritInverseConfiguration
    RiesgoErgonomico toRiesgoErgonomico(RiesgoErgonomicoDTO dto);
}
