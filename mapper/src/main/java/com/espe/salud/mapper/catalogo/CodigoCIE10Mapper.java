package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.CodigoCIE10;
import com.espe.salud.dto.catalogo.CodigoCIE10DTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CodigoCIE10Mapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    CodigoCIE10DTO toCodigoCIE10DTO(CodigoCIE10 codigoCIE10);

    List<CodigoCIE10DTO> toCodigoCIE10DTO(List<CodigoCIE10DTO> enfermedadesCIE10DTO);

    @InheritInverseConfiguration
    CodigoCIE10 toCodigoCIE10(CodigoCIE10DTO dto);

}
