package com.espe.salud.mapper.evolucion;

import com.espe.salud.domain.entities.evolucion.Prescripcion;
import com.espe.salud.dto.evolucion.PrescripcionDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrescripcionMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    PrescripcionDTO toPrescripcionDTO(Prescripcion prescripcion);
    List<PrescripcionDTO> toPrescripcionesDTO(List<Prescripcion> prescripciones);
    @InheritInverseConfiguration
    Prescripcion toPrescripcion(PrescripcionDTO dto);
}
