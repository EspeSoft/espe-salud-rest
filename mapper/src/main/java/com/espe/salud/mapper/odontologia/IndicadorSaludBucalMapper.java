package com.espe.salud.mapper.odontologia;

import com.espe.salud.domain.entities.odontologia.IndicadorSaludBucal;
import com.espe.salud.dto.odontologia.IndicadorSaludBucalDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IndicadorSaludBucalMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    IndicadorSaludBucalDTO toIndicadorSaludBucalDTO(IndicadorSaludBucal indicadorSaludBucal);

    List<IndicadorSaludBucalDTO> toIndicadoresSaludBucalDTO(List<IndicadorSaludBucal> IndicadoresSaludBucal);

    @InheritInverseConfiguration
    IndicadorSaludBucal toIndicadorSaludBucal(IndicadorSaludBucalDTO dto);

}
