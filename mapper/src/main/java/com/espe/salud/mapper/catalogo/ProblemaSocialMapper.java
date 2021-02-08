package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.ProblemaSocial;
import com.espe.salud.dto.catalogo.ProblemaSocialDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProblemaSocialMapper {
    @Mapping(source = "codigo", target = "id")
    ProblemaSocialDTO toProblemaSocialDTO(ProblemaSocial problemaSocial);

    List<ProblemaSocialDTO> toProblemasSocialesDTO(List<ProblemaSocial> problemasSociales);

    @InheritInverseConfiguration
    ProblemaSocial toProblemaSocial(ProblemaSocialDTO dto);
}
