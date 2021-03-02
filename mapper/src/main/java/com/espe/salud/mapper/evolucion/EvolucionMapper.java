package com.espe.salud.mapper.evolucion;

import com.espe.salud.domain.entities.evolucion.Evolucion;
import com.espe.salud.dto.evolucion.EvolucionDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EvolucionMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    EvolucionDTO toEvolucionDTO(Evolucion evolucion);

    List<EvolucionDTO> toEvolucionesDTO(List<Evolucion> evoluciones);

    @InheritInverseConfiguration
    Evolucion toEvolucion(EvolucionDTO dto);
}
