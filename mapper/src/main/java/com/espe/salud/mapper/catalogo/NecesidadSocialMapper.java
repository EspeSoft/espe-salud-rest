package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.NecesidadSocial;
import com.espe.salud.dto.catalogo.NecesidadSocialDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NecesidadSocialMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    NecesidadSocialDTO toNecesidadSocialDTO(NecesidadSocial necesidadSocial);

    List<NecesidadSocialDTO> toNecesidadesSocialesDTO(List<NecesidadSocial> necesidades);

    @InheritInverseConfiguration
    NecesidadSocial toNecesidadSocial(NecesidadSocialDTO dto);
}
