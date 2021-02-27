package com.espe.salud.mapper.ocupacional;

import com.espe.salud.domain.entities.ocupacional.FactorRiesgoPuestoActual;
import com.espe.salud.dto.ocupacional.FactorRiesgoPuestoActualDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FactorRiesgoPuestoActualMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    FactorRiesgoPuestoActualDTO toFactorRiesgoPuestoActualDto(FactorRiesgoPuestoActual factor);

    List<FactorRiesgoPuestoActualDTO> toFactoreRiesgosPuestoActualDto(List<FactorRiesgoPuestoActual> factores);

    @InheritInverseConfiguration
    FactorRiesgoPuestoActual toFactorRiesgoPuestoActual(FactorRiesgoPuestoActualDTO dto);
}
