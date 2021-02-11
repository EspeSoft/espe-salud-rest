package com.espe.salud.mapper.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteEmpleoAnterior;
import com.espe.salud.dto.ocupacional.AntecedenteEmpleoAnteriorDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AntecedenteLaboralMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    AntecedenteEmpleoAnteriorDTO toAntecedenteEmpleoAnteriorDTO(AntecedenteEmpleoAnterior diagnostico);

    List<AntecedenteEmpleoAnteriorDTO> toAntecedentesEmpleoAnteriorDTO(List<AntecedenteEmpleoAnterior> diagnostico);

    @InheritInverseConfiguration
    AntecedenteEmpleoAnterior toAntecedenteEmpleoAnterior(AntecedenteEmpleoAnteriorDTO dto);
    
}
