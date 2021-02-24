package com.espe.salud.mapper.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteEmpleoAnterior;
import com.espe.salud.dto.ocupacional.AntecedenteEmpleoAnteriorDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AntecedenteEmpleoAnteriorMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    AntecedenteEmpleoAnteriorDTO toAntecedenteEmpleoAnteriorDto(AntecedenteEmpleoAnterior antecedente);

    List<AntecedenteEmpleoAnteriorDTO> toAntecedentesEmpleosAnteriorDto(List<AntecedenteEmpleoAnterior> antecedentes);

    @InheritInverseConfiguration
    AntecedenteEmpleoAnterior toAntecedenteEmpleoAnterior(AntecedenteEmpleoAnteriorDTO dto);
}
