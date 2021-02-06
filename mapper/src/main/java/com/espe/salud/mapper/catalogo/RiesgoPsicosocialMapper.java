package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.RiesgoPsicosocial;
import com.espe.salud.dto.catalogo.RiesgoPsicosocialDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RiesgoPsicosocialMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    RiesgoPsicosocialDTO toRiesgoPsicosocialDTO(RiesgoPsicosocial riesgoPsicosocial);

    List<RiesgoPsicosocialDTO> toRiesgosPsicosocialsDTO(List<RiesgoPsicosocial> riesgosPsicosocials);

    @InheritInverseConfiguration
    RiesgoPsicosocial toRiesgoPsicosocial(RiesgoPsicosocialDTO dto);
}
