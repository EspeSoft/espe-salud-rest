package com.espe.salud.mapper.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteAccidenteTrabajo;
import com.espe.salud.dto.ocupacional.AntecedenteAccidenteTrabajoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AntecedenteAccidenteTrabajoMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    AntecedenteAccidenteTrabajoDTO toAntecedenteAccidenteTrabajoDto(AntecedenteAccidenteTrabajo antecedenteAccidenteTrabajo);

    List<AntecedenteAccidenteTrabajoDTO> toAntecedentesAccidentesTrabajoDto(List<AntecedenteAccidenteTrabajo> antecedenteAccidenteTrabajos);

    @InheritInverseConfiguration
    AntecedenteAccidenteTrabajo toAntecedenteAccidenteTrabajo(AntecedenteAccidenteTrabajoDTO dto);
}
