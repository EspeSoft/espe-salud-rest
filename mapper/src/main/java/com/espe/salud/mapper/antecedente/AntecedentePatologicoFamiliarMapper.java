package com.espe.salud.mapper.antecedente;

import com.espe.salud.domain.entities.antecedente.AntecedentePatologicoFamiliar;
import com.espe.salud.dto.antecedente.AntecedentePatologicoFamiliarDTO;
import com.espe.salud.mapper.catalogo.TipoEnfermedadMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TipoEnfermedadMapper.class})
public interface AntecedentePatologicoFamiliarMapper {

    @Mapping(source = "codigo", target = "id")
    AntecedentePatologicoFamiliarDTO toAntecedentePatologicoFamiliarDTO(AntecedentePatologicoFamiliar antecedentePatologicoFamiliar);

    List<AntecedentePatologicoFamiliarDTO> toAntecedentesPatologicoFamiliarDTO(List<AntecedentePatologicoFamiliar> antecedentePatologicoFamiliar);

    @InheritInverseConfiguration
    AntecedentePatologicoFamiliar toAntecedentePatologicoFamiliar(AntecedentePatologicoFamiliarDTO dto);
}