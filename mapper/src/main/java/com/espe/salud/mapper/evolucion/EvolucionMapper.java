package com.espe.salud.mapper.evolucion;

import com.espe.salud.domain.entities.evolucion.Evolucion;
import com.espe.salud.dto.evolucion.EvolucionDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EvolucionMapper {
    EvolucionDTO toEvolucionDTO(Evolucion evolucion);
    List<EvolucionDTO> toEvolucionesDTO(List<Evolucion> evoluciones);
    @InheritInverseConfiguration
    Evolucion toEvolucion(EvolucionDTO dto);
}
