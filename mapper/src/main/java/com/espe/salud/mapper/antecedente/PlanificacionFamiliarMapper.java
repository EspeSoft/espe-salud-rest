package com.espe.salud.mapper.antecedente;

import com.espe.salud.domain.entities.antecedente.PlanificacionFamiliar;
import com.espe.salud.dto.antecedente.PlanificacionFamiliarDTO;
import com.espe.salud.mapper.catalogo.TipoPlanificacionFamiliarMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TipoPlanificacionFamiliarMapper.class})
public interface PlanificacionFamiliarMapper {

    @Mapping(source = "codigo", target = "id")
    PlanificacionFamiliarDTO toPlanificacionFamiliarDTO(PlanificacionFamiliar planificacionFamiliar);

    List<PlanificacionFamiliarDTO> toPlanificacionesFamiliaresDTO(List<PlanificacionFamiliar> planificacionFamiliar);

    @InheritInverseConfiguration
    PlanificacionFamiliar toPlanificacionFamiliar(PlanificacionFamiliarDTO dto);
}