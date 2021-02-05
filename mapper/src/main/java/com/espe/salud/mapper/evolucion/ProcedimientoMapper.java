package com.espe.salud.mapper.evolucion;

import com.espe.salud.domain.entities.evolucion.Procedimiento;
import com.espe.salud.dto.evolucion.ProcedimientoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProcedimientoMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    ProcedimientoDTO toProcedimientoDTO (Procedimiento procedimiento);

    List<ProcedimientoDTO> toProcedimientoDTO(List<Procedimiento> procedimientos);

    @InheritInverseConfiguration
    Procedimiento  toProcedimiento(ProcedimientoDTO dto);
}
