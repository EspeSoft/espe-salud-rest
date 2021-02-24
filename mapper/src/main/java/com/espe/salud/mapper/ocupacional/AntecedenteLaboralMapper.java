package com.espe.salud.mapper.ocupacional;

import com.espe.salud.domain.entities.ocupacional.AntecedenteLaboral;
import com.espe.salud.dto.ocupacional.AntecedenteLaboralDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AntecedenteLaboralMapper {
    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    AntecedenteLaboralDTO toAntecedenteLaboralDto(AntecedenteLaboral antecedente);

    List<AntecedenteLaboralDTO> toAntecedentesLaboralesDto(List<AntecedenteLaboral> antecedentes);

    @InheritInverseConfiguration
    AntecedenteLaboral toAntecedenteLaboral(AntecedenteLaboralDTO dto);
}
