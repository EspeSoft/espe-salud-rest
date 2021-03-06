package com.espe.salud.mapper.evolucion;

import com.espe.salud.domain.entities.evolucion.Diagnostico;
import com.espe.salud.dto.evolucion.DiagnosticoDTO;
import com.espe.salud.mapper.catalogo.EnfermedadCIE10Mapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EnfermedadCIE10Mapper.class})
public interface DiagnosticoMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    DiagnosticoDTO toDiagnosticoDTO(Diagnostico diagnostico);

    List<DiagnosticoDTO> toDiagnosticosDTO(List<Diagnostico> diagnosticos);

    @InheritInverseConfiguration
    Diagnostico toDiagnostico(DiagnosticoDTO dto);
}
