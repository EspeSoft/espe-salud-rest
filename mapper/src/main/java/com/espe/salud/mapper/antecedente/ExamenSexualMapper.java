package com.espe.salud.mapper.antecedente;

import com.espe.salud.domain.entities.antecedente.ExamenSexual;
import com.espe.salud.dto.antecedente.ExamenSexualDTO;
import com.espe.salud.mapper.catalogo.TipoExamenSexualMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TipoExamenSexualMapper.class})
public interface ExamenSexualMapper {

    @Mapping(source = "codigo", target = "id")
    ExamenSexualDTO toExamenSexualDTO(ExamenSexual examenSexual);

    List<ExamenSexualDTO> toExamenesSexualesDTO(List<ExamenSexual> examenSexual);

    @InheritInverseConfiguration
    ExamenSexual toExamenSexual(ExamenSexualDTO dto);
}