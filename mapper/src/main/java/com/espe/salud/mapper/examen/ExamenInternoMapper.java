package com.espe.salud.mapper.examen;

import com.espe.salud.domain.entities.examen.ExamenInterno;
import com.espe.salud.dto.examen.ExamenInternoDTO;
import com.espe.salud.mapper.catalogo.OrganoSistemaMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OrganoSistemaMapper.class})
public interface ExamenInternoMapper {
    @Mapping(source = "codigo", target = "id")
    ExamenInternoDTO toExamenInternoDTO(ExamenInterno examenInterno);

    @InheritInverseConfiguration
    ExamenInterno toExamenInterno(ExamenInternoDTO dto);

    List<ExamenInternoDTO> toExamenesInternosDTO(List<ExamenInterno> examenesInternos);
}
