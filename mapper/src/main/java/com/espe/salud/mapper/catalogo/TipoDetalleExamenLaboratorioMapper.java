package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoDetalleExamenLaboratorio;
import com.espe.salud.dto.catalogo.TipoDetalleExamenLaboratorioDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoDetalleExamenLaboratorioMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    TipoDetalleExamenLaboratorioDTO toDetalleExamenLaboratorioDTO(TipoDetalleExamenLaboratorio tipoDetalleExamenLaboratorio);

    List<TipoDetalleExamenLaboratorioDTO> toDetalleExamenLaboratorioDTO(List<TipoDetalleExamenLaboratorio> tipoDetalleExamenlaboratorios);

    @InheritInverseConfiguration
    TipoDetalleExamenLaboratorio toDetalleExamenLaboratorio(TipoDetalleExamenLaboratorioDTO dto);
}
