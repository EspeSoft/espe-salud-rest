package com.espe.salud.mapper.antecedente;

import com.espe.salud.domain.entities.antecedente.AntecedenteQuirurgico;
import com.espe.salud.dto.antecedente.AntecedenteQuirurgicoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AntecedenteQuirurgicoMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    AntecedenteQuirurgicoDTO toAntecedenteQuirurgicoDTO(AntecedenteQuirurgico antecedenteQuirurgico);
    List<AntecedenteQuirurgicoDTO> toAntecedenteQuirurgicoDTO(List<AntecedenteQuirurgico> antecedenteQuirurgicos);

    @InheritInverseConfiguration
    AntecedenteQuirurgico toAntecedenteQuirurgico(AntecedenteQuirurgicoDTO dto);
}
