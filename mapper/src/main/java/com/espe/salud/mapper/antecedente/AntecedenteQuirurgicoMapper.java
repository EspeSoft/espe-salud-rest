package com.espe.salud.mapper.antecedente;

import com.espe.salud.domain.entities.antecedente.AntecedenteQuirurgico;
import com.espe.salud.dto.antecedente.AntecedenteQuirurgicoDTO;
import com.espe.salud.mapper.catalogo.EnfermedadCIE10Mapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EnfermedadCIE10Mapper.class})
public interface AntecedenteQuirurgicoMapper {

    @Mapping(source = "codigo", target = "id")
    AntecedenteQuirurgicoDTO toAntecedenteQuirurgicoDTO(AntecedenteQuirurgico antecedenteQuirurgico);

    List<AntecedenteQuirurgicoDTO> toAntecedentesQuirurgicoDTO(List<AntecedenteQuirurgico> antecedenteQuirurgicos);

    @InheritInverseConfiguration
    AntecedenteQuirurgico toAntecedenteQuirurgico(AntecedenteQuirurgicoDTO dto);
}
