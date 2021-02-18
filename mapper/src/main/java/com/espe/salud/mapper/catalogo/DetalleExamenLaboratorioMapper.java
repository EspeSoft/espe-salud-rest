package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.DetalleExamenLaboratorio;
import com.espe.salud.dto.catalogo.DetalleExamenLaboratorioDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetalleExamenLaboratorioMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    DetalleExamenLaboratorioDTO toDetalleExamenLaboratorioDTO(DetalleExamenLaboratorio detalleExamenLaboratorio);

    List<DetalleExamenLaboratorioDTO> toDetalleExamenLaboratorioDTO(List<DetalleExamenLaboratorio> detalleExamenlaboratorios);

    @InheritInverseConfiguration
    DetalleExamenLaboratorio toDetalleExamenLaboratorio(DetalleExamenLaboratorioDTO dto);
}
