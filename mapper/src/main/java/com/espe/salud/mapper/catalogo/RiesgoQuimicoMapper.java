package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoQuimico;
import com.espe.salud.dto.catalogo.RiesgoQuimicoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RiesgoQuimicoMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    RiesgoQuimicoDTO toRiesgoQuimicoDTO(RiesgoQuimico riesgoQuimico);

    List<RiesgoQuimicoDTO> toRiesgosQuimicosDTO(List<RiesgoQuimico> riesgosQuimicos);

    @InheritInverseConfiguration
    RiesgoQuimico toRiesgoQuimico(RiesgoQuimicoDTO dto);
}


