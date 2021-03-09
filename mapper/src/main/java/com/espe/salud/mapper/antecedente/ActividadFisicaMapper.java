package com.espe.salud.mapper.antecedente;

import com.espe.salud.domain.entities.antecedente.ActividadFisica;
import com.espe.salud.dto.antecedente.ActividadFisicaDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActividadFisicaMapper {

    @Mapping(source = "codigo", target = "id")
    ActividadFisicaDTO toActividadFisicaDTO(ActividadFisica actividadFisica);

    List<ActividadFisicaDTO> toActividadesFisicasDTO(List<ActividadFisica> actividadesFisicas);

    @InheritInverseConfiguration
    ActividadFisica toActividadFisica(ActividadFisicaDTO dto);
}
