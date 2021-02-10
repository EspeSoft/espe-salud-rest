package com.espe.salud.mapper.antecedente;

import com.espe.salud.domain.entities.antecedente.PlanificacionFamiliar;
import com.espe.salud.dto.antecedente.PlanificacionFamiliarDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlanificacionFamiliarMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    PlanificacionFamiliarDTO toPlanificacionFamiliarDTO(PlanificacionFamiliar planificacionFamiliar);

    List<PlanificacionFamiliarDTO> toPlanificacionFamiliarDTO(List<PlanificacionFamiliar> planificacionFamiliar);

    @InheritInverseConfiguration
    PlanificacionFamiliar toPlanificacionFamiliar(PlanificacionFamiliarDTO dto);
}