package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.EnfermedadCIE10;
import com.espe.salud.dto.catalogo.AreaDTO;
import com.espe.salud.dto.catalogo.EnfermedadCIE10DTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnfermedadCIE10Mapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    EnfermedadCIE10DTO toEnfermedadCIE10DTO(EnfermedadCIE10 enfermedadCIE10);

    List<EnfermedadCIE10DTO> toEnfermedadCIE10DTO(List<EnfermedadCIE10DTO> enfermedadesCIE10DTO);

    @InheritInverseConfiguration
    EnfermedadCIE10 toEnfermedadCIE10(EnfermedadCIE10DTO dto);
}
