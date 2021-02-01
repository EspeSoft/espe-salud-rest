package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoBiologico;
import com.espe.salud.dto.catalogo.RiesgoBiologicoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RiesgoBiologicoMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    RiesgoBiologicoDTO toRiesgoBiologicoDTO(RiesgoBiologico riesgoBiologico);

    List<RiesgoBiologicoDTO> toRiesgosBiologicosDTO(List<RiesgoBiologico> riesgosBiologicos);

    @InheritInverseConfiguration
    RiesgoBiologico toRiesgoBiologico(RiesgoBiologicoDTO dto);
}
