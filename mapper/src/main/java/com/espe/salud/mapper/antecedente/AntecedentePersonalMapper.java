package com.espe.salud.mapper.antecedente;

import com.espe.salud.domain.entities.antecedente.AntecedentePersonal;
import com.espe.salud.dto.antecedente.AntecedentePersonalDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AntecedentePersonalMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    AntecedentePersonalDTO toAntecedentePersonalDTO(AntecedentePersonal antecedentePersonal);

    List<AntecedentePersonalDTO> toAntecedentePersonalesDTO(List<AntecedentePersonal> antecedentePersonales);

    @InheritInverseConfiguration
    AntecedentePersonal toAntecedentePersonal(AntecedentePersonalDTO dto);

}
