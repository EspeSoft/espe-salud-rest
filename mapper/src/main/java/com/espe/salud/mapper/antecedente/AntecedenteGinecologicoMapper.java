package com.espe.salud.mapper.antecedente;

import com.espe.salud.domain.entities.antecedente.AntecedenteGinecologico;
import com.espe.salud.dto.antecedente.AntecedenteGinecologicoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AntecedenteGinecologicoMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    AntecedenteGinecologicoDTO toAntecedenteGinecologicoDTO(AntecedenteGinecologico antecedenteGinecologico);

    List<AntecedenteGinecologicoDTO> toAntecedenteGinecologicoDTO(List<AntecedenteGinecologico> antecedenteGinecologico);

    @InheritInverseConfiguration
    AntecedenteGinecologico toAntecedenteGinecologico(AntecedenteGinecologicoDTO dto);
}