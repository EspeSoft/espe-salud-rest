package com.espe.salud.mapper.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteEnfermedadProfesional;
import com.espe.salud.dto.ocupacional.AntecedenteEnfermedadProfesionalDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AntecedenteEnfermedadProfesionalMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    AntecedenteEnfermedadProfesionalDTO toAntecedenteEnfermedadProfesionalDto(AntecedenteEnfermedadProfesional antecedente);

    List<AntecedenteEnfermedadProfesionalDTO> toAntecedentesEnfermedadesProfesionalDto(List<AntecedenteEnfermedadProfesional> antecedentes);

    @InheritInverseConfiguration
    AntecedenteEnfermedadProfesional toAntecedenteEnfermedadProfesional(AntecedenteEnfermedadProfesionalDTO dto);
}
