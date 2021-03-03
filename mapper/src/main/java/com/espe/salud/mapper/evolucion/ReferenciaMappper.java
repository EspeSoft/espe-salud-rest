package com.espe.salud.mapper.evolucion;

import com.espe.salud.domain.entities.evolucion.Referencia;
import com.espe.salud.dto.evolucion.ReferenciaDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReferenciaMappper {
    ReferenciaDTO toReferenciaDTO(Referencia contacto);

    @InheritInverseConfiguration
    Referencia toReferencia(ReferenciaDTO dto);
}
