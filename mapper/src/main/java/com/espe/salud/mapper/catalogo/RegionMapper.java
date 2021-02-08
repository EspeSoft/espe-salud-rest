package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.Region;
import com.espe.salud.dto.catalogo.RegionDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegionMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    RegionDTO toRegionDTO(Region region);

    List<RegionDTO> toRegionDTO(List<Region> regiones);

    @InheritInverseConfiguration
    Region toRegion(RegionDTO dto);
}
