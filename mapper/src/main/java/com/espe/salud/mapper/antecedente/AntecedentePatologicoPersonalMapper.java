package com.espe.salud.mapper.antecedente;

import com.espe.salud.domain.entities.antecedente.AntecedentePatologicoPersonal;
import com.espe.salud.dto.antecedente.AntecedentePatologicoPersonalDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AntecedentePatologicoPersonalMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    AntecedentePatologicoPersonalDTO toAntecedentePatologicoPersonalDTO(AntecedentePatologicoPersonal antecedentePatologicoPersonal);
    List<AntecedentePatologicoPersonalDTO> toAntecedentePatologicoPersonalDTO(List<AntecedentePatologicoPersonal> antecedentePatologicoPersonals);

    @InheritInverseConfiguration
    AntecedentePatologicoPersonal toAntecedentePatologicoPersonal(AntecedentePatologicoPersonalDTO dto);
}

