package com.espe.salud.mapper.antecedente;

import com.espe.salud.domain.entities.antecedente.ExamenSexual;
import com.espe.salud.dto.antecedente.ExamenSexualDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExamenSexualMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    ExamenSexualDTO toExamenSexualDTO(ExamenSexual examenSexual);

    List<ExamenSexualDTO> toExamenSexualDTO(List<ExamenSexual> examenSexual);

    @InheritInverseConfiguration
    ExamenSexual toExamenSexual(ExamenSexualDTO dto);
}