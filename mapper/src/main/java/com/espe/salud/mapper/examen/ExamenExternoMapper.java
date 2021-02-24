package com.espe.salud.mapper.examen;

import com.espe.salud.domain.entities.examen.ExamenExterno;
import com.espe.salud.dto.examen.ExamenExternoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExamenExternoMapper {
    @Mapping(source = "codigo", target = "id")
    ExamenExternoDTO toExamenExternoDTO(ExamenExterno examenExterno);

    @InheritInverseConfiguration
    ExamenExterno toExamenExterno(ExamenExternoDTO dto);

    List<ExamenExternoDTO> toExamenesExternosDTO(List<ExamenExterno> examenesExternos);
}
