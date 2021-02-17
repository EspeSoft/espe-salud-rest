package com.espe.salud.mapper.odontologia;

import com.espe.salud.domain.entities.odontologia.ExamenSistemaEstomatognatico;
import com.espe.salud.dto.odontologia.ExamenSistemaEstomatognaticoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExamenSistemaEstomatognaticoMapper {

    @Mappings({
            @Mapping(source = "codigo", target = "id")
    })
    ExamenSistemaEstomatognaticoDTO toExamenSistemaEstomatognaticoDTO(ExamenSistemaEstomatognatico examenSistemaEstomatognatico);

    List<ExamenSistemaEstomatognaticoDTO> toExamenesSistemaEstomatognaticoDTO(List<ExamenSistemaEstomatognatico> ExamenesSistemaEstomatognatico);

    @InheritInverseConfiguration
    ExamenSistemaEstomatognatico toExamenSistemaEstomatognatico(ExamenSistemaEstomatognaticoDTO dto);

}
