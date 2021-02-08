package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.Subdivision;
import com.espe.salud.dto.catalogo.SubdivisionDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
   
@Mapper(componentModel = "spring")
public interface SubdivisionMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    SubdivisionDTO toSubdivisionDTO(Subdivision subdivision);

    List<SubdivisionDTO> toSubdivisionsDTO(List<Subdivision> subdivisiones);

    @InheritInverseConfiguration
    Subdivision toSubdivision(SubdivisionDTO dto);
}
