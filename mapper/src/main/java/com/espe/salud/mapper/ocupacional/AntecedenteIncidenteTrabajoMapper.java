package com.espe.salud.mapper.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteIncidenteTrabajo;
import com.espe.salud.dto.ocupacional.AntecedenteIncidenteTrabajoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AntecedenteIncidenteTrabajoMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    AntecedenteIncidenteTrabajoDTO toAntecedenteIncidenteTrabajoDto(AntecedenteIncidenteTrabajo antecedenteIncidenteTrabajo);

    List<AntecedenteIncidenteTrabajoDTO> toAntecedentesIncidentesTrabajoDto(List<AntecedenteIncidenteTrabajo> antecedenteIncidenteTrabajos);

    @InheritInverseConfiguration
    AntecedenteIncidenteTrabajo toAntecedenteIncidenteTrabajo(AntecedenteIncidenteTrabajoDTO dto);
}
