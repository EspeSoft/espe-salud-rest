package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.Area;
import com.espe.salud.dto.catalogo.AreaDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AreaMapper {

    @Mapping(source = "codigo", target = "id")
    AreaDTO toAreaDTO(Area area);

    @InheritInverseConfiguration
    Area toArea(AreaDTO dto);

    List<AreaDTO> toAreasDTO(List<Area> areas);
}

