package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoMecanico;
import com.espe.salud.dto.catalogo.RiesgoMecanicoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RiesgoMecanicoMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    RiesgoMecanicoDTO toRiesgoMecanicoDTO(RiesgoMecanico riesgoMecanico);

    List<RiesgoMecanicoDTO> toRiesgosMecanicosDTO(List<RiesgoMecanico> riesgosMecanicos);

    @InheritInverseConfiguration
    RiesgoMecanico toRiesgoMecanico(RiesgoMecanicoDTO dto);
}
