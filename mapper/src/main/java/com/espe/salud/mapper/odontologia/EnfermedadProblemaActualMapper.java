package com.espe.salud.mapper.odontologia;

import com.espe.salud.domain.entities.odontologia.EnfermedadProblemaActual;
import com.espe.salud.dto.odontologia.EnfermedadProblemaActualDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnfermedadProblemaActualMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    EnfermedadProblemaActualDTO toEnfermedadProblemaActualDTO(EnfermedadProblemaActual enfermedadProblemaActual);

    List<EnfermedadProblemaActualDTO> toEnfermedadesProblemasActualesDTO(List<EnfermedadProblemaActual> EnfermedadesProblemasActuales);

    @InheritInverseConfiguration
    EnfermedadProblemaActual toEnfermedadProblemaActual(EnfermedadProblemaActualDTO dto);

}
