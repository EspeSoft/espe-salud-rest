package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.ExamenLaboratorio;
import com.espe.salud.dto.catalogo.ExamenLaboratorioDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExamenLaboratorioMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    ExamenLaboratorioDTO toExamenLaboratorioDTO(ExamenLaboratorio examenLaboratorio);

    List<ExamenLaboratorioDTO> toExamenLaboratorioDTO(List<ExamenLaboratorio> examenlaboratorios);

    @InheritInverseConfiguration
    ExamenLaboratorio toExamenLaboratorio(ExamenLaboratorioDTO dto);
}
