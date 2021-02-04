package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.Area;
import com.espe.salud.dto.catalogo.AreaDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AreaMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    AreaDTO toAreaDTO(Area area);

    List<AreaDTO> toAreaDTO(List<Area> areas);

    @InheritInverseConfiguration
    Area toArea(AreaDTO dto);
}

