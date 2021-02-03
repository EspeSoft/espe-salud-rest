package com.espe.salud.mapper.antecedente;

import com.espe.salud.domain.entities.antecedente.AntecedentePatologicoFamiliar;
import com.espe.salud.dto.antecedente.AntecedentePatologicoFamiliaDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AntecedentePatologicoFamiliarMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    AntecedentePatologicoFamiliaDTO toAntecedentePatologicoFamiliarDTO(AntecedentePatologicoFamiliar antecedentePatologicoFamiliar);

    List<AntecedentePatologicoFamiliaDTO> toAntecedentePatologicoFamiliarDTO(List<AntecedentePatologicoFamiliar> antecedentePatologicoFamiliar);

    @InheritInverseConfiguration
    AntecedentePatologicoFamiliar toAntecedentePatologicoFamiliar(AntecedentePatologicoFamiliaDTO dto);
}
