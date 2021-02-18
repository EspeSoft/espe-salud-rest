package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.TipoProcedimiento;
import com.espe.salud.dto.catalogo.TipoProcedimientoDTO;
import com.espe.salud.dto.evolucion.ProcedimientoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoProcedimientoMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    TipoProcedimientoDTO toTipoProcedimientoDTO(TipoProcedimiento tipoProcedimiento);

    List<TipoProcedimientoDTO> toTipoProcedimientoDTO(List<TipoProcedimiento> tipoProcedimientos);

    @InheritInverseConfiguration
    TipoProcedimiento toTipoProcedimiento(TipoProcedimientoDTO dto);
}
