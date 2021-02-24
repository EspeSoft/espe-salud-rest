package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.Region;
import com.espe.salud.dto.catalogo.RegionDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AreaMapper.class})
public interface RegionMapper {

    @Mapping(source = "codigo", target = "id")
    RegionDTO toRegionDTO(Region region);

    @InheritInverseConfiguration
    Region toRegion(RegionDTO dto);

    List<RegionDTO> toRegionesDTO(List<Region> regiones);
}
