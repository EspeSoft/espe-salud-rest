package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.FrecuenciaMedicacionHabitual;
import com.espe.salud.dto.catalogo.FrecuenciaMedicacionHabitualDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FrecuenciaMedicacionHabitualMapper {
    @Mapping(source = "codigo", target = "id")
    FrecuenciaMedicacionHabitualDTO toFrecuenciaMedicacionHabitualDTO(FrecuenciaMedicacionHabitual frecuenciaMedicacionHabitual);

    @InheritInverseConfiguration
    FrecuenciaMedicacionHabitual toFrecuenciaMedicacionHabitual(FrecuenciaMedicacionHabitualDTO dto);

    List<FrecuenciaMedicacionHabitualDTO> toFrecuencias(List<FrecuenciaMedicacionHabitual> domainList);
}
