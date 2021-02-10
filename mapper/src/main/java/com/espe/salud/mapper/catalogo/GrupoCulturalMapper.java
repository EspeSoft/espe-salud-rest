package com.espe.salud.mapper.catalogo;

import com.espe.salud.domain.entities.catalogo.GrupoCultural;
import com.espe.salud.dto.catalogo.GrupoCulturalDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GrupoCulturalMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    GrupoCulturalDTO toGrupoCulturalDTO(GrupoCultural grupoCultural);

    List<GrupoCulturalDTO> toGrupoCulturalDTO(List<GrupoCultural> grupoCulturals);

    @InheritInverseConfiguration
    GrupoCultural toGrupoCultural(GrupoCulturalDTO dto);
}
